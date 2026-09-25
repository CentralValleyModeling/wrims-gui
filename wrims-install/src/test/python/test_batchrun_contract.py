"""Run with the built vista/bin/vscript.bat from installer/WSIDIGenerator."""
import os
import shutil
import subprocess
import sys
import tempfile
import threading
import unittest

sys.path.insert(0, os.getcwd())
import SequentialStudyTab
import ParallelStudyTab


class BatchRunContractTest(unittest.TestCase):
    def setUp(self):
        self.cwd = os.getcwd()
        self.work = tempfile.mkdtemp(prefix="wrims-batch-contract-")
        self.success_batch = os.path.join(self.work, "success.bat")
        self.failure_batch = os.path.join(self.work, "failure.bat")
        with open(self.success_batch, "w") as stream:
            stream.write("@exit /b 0\r\n")
        with open(self.failure_batch, "w") as stream:
            stream.write("@exit /b 7\r\n")

    def tearDown(self):
        os.chdir(self.cwd)
        shutil.rmtree(self.work)

    def test_worker_execute_returns_batch_status(self):
        self.assertEqual(7, SequentialStudyTab.StudyTab().execute(self.failure_batch, 0))
        self.assertEqual(7, ParallelStudyTab.StudyTab().execute(self.failure_batch, 0))

    def test_missing_batch_is_not_success(self):
        self.assertNotEqual(0, SequentialStudyTab.StudyTab().execute(
            os.path.join(self.work, "missing.bat"), 0))

    def test_windows_batch_preserves_status_across_timeout(self):
        batch = os.path.join(self.work, "preserve-status.bat")
        with open(batch, "w") as stream:
            stream.write("@echo off\r\n")
            stream.write("cmd /c exit /b 23\r\n")
            stream.write("set \"WRIMS_EXIT=%errorlevel%\"\r\n")
            stream.write("timeout /t 0 > NUL\r\n")
            stream.write("exit %WRIMS_EXIT%\r\n")
        self.assertEqual(23, subprocess.call(
            ["cmd.exe", "/d", "/c", "call", batch]))
        # The legacy ordinary launcher observes cmd/start, which returns zero;
        # this assertion also proves that exit (not exit /b) closes its child.
        self.assertEqual(0, subprocess.call(
            ["cmd.exe", "/d", "/c", "start", "/min", "/w", batch]))

    def check_template(self, filename):
        with open(filename) as stream:
            lines = stream.readlines()
        names = ["studyDvNames", "lookupNames", "engineNames", "launchNames", "offsets"]
        for index, name in enumerate(names, 28):
            self.assertTrue(lines[index].strip().startswith(name + "="))
            lines[index] = "        " + name + "=[]\n"
        compile("".join(lines), filename, "exec")

    def test_sequential_template_slots(self):
        self.check_template("SequentialMain_template.py")

    def test_parallel_template_slots(self):
        self.check_template("ParallelMain_template.py")

    def make_inputs(self, count):
        dv_names = []
        lookups = []
        for index in range(count):
            folder = os.path.join(self.work, "study-" + str(index))
            os.mkdir(folder)
            lookups.append(folder)
            dv = os.path.join(folder, "output.dss")
            with open(dv, "w") as stream:
                stream.write("fixture, not a DSS dataset")
            dv_names.append(dv)
        return dv_names, lookups

    def run_contract(self, module, statuses, curve_failure_index=None):
        events = []
        self.last_events = events
        dv_names, lookups = self.make_inputs(len(statuses))
        self.last_dv_names = dv_names

        class Curve:
            def __init__(self, name, wsi, di, maximum, dv, lookup, launch, offset):
                self.name = name
                self.study = dv_names.index(dv)

            def load(self, filename):
                events.append((self.study, "load"))

            def execute(self):
                events.append((self.study, "curve"))
                if self.study == curve_failure_index:
                    raise RuntimeError("expected curve failure for study %d" %
                                       (self.study + 1))

        class Probe(module.StudyTab):
            def execute(self, engine, index):
                events.append((index, "model"))
                return statuses[index]

        original = module.WsiDiGenCl
        module.WsiDiGenCl = Curve
        try:
            args = (dv_names, ["a"], ["wsi"], ["di"], [1], lookups,
                    [self.success_batch] * len(statuses), ["study.launch"] * len(statuses),
                    [1] * len(statuses))
            Probe().runForWsi(*args)
        finally:
            module.WsiDiGenCl = original
        return events, dv_names

    def test_sequential_three_iterations_then_next_study(self):
        events, dv_names = self.run_contract(SequentialStudyTab, [0, 0])
        for index in range(2):
            self.assertEqual(["model", "load", "curve"] * 3,
                             [kind for study, kind in events if study == index])
            for iteration in range(2):
                self.assertTrue(os.path.exists(
                    dv_names[index][:-4] + "_" + str(iteration) + ".dss"))
        self.assertEqual([0] * 9 + [1] * 9, [study for study, kind in events])

    def test_sequential_failure_stops_before_dss_and_next_study(self):
        with self.assertRaisesRegexp(RuntimeError, "study 1, iteration 1, exit code 7"):
            self.run_contract(SequentialStudyTab, [7, 0])
        self.assertEqual([(0, "model")], self.last_events)
        self.assertFalse(os.path.exists(self.last_dv_names[0][:-4] + "_0.dss"))

    def test_parallel_success_waits_for_all_studies(self):
        events, unused = self.run_contract(ParallelStudyTab, [0, 0])
        for index in range(2):
            self.assertEqual(3, len([event for event in events
                                    if event == (index, "model")]))
            self.assertEqual(3, len([event for event in events
                                    if event == (index, "load")]))
            self.assertEqual(3, len([event for event in events
                                    if event == (index, "curve")]))

    def test_parallel_one_failure_is_reported_after_other_study_finishes(self):
        with self.assertRaisesRegexp(RuntimeError, "study 2.*exit code 7"):
            self.run_contract(ParallelStudyTab, [0, 7])
        self.assertEqual([(1, "model")], [event for event in self.last_events
                                          if event[0] == 1])
        self.assertEqual(3, len([event for event in self.last_events
                                if event == (0, "curve")]))

    def test_parallel_multiple_failures_are_reported_in_study_order(self):
        try:
            self.run_contract(ParallelStudyTab, [7, 9])
            self.fail("Expected parallel failure")
        except RuntimeError as error:
            message = str(error)
            self.assertIn("study 1", message)
            self.assertIn("exit code 7", message)
            self.assertIn("study 2", message)
            self.assertIn("exit code 9", message)
            self.assertLess(message.index("study 1"), message.index("study 2"))
        self.assertFalse(any(kind in ("load", "curve")
                             for study, kind in self.last_events))

    def test_sequential_curve_failure_reaches_interpreter(self):
        with self.assertRaisesRegexp(RuntimeError, "expected curve failure for study 1"):
            self.run_contract(SequentialStudyTab, [0], curve_failure_index=0)

    def test_parallel_curve_failure_reaches_main_thread(self):
        with self.assertRaisesRegexp(RuntimeError, "study 1.*expected curve failure"):
            self.run_contract(ParallelStudyTab, [0], curve_failure_index=0)

    def test_parallel_threads_overlap_and_finish_before_return(self):
        second_started = threading.Event()
        completed = []

        class Probe(ParallelStudyTab.StudyTab):
            def runForWsiStudy(self, k, *args):
                if k == 0:
                    if not second_started.wait(5):
                        raise RuntimeError("Second study did not start concurrently")
                else:
                    second_started.set()
                completed.append(k)

        Probe().runForWsi(["a", "b"], [], [], [], [], [], [], [], [])
        self.assertEqual([0, 1], sorted(completed))


if __name__ == "__main__":
    unittest.main()
