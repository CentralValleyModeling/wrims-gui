.. _7-advanced-execution:

Advanced Execution
==================

.. _23-advanced-batch-run-gui:

23. Advanced Batch Run GUI
--------------------------

**Purpose**

This chapter explains how to run multiple studies through the GUI.

**Before you start**

- You already have one or more valid launch files.
- **WRIMS 2 GUI** is open.

**Procedure**

Open **WRIMS 2 GUI**, then go to:

- **Run > Batch Run**

The Batch Run dialog appears.

.. image:: diagrams/frames/23_Advanced_BatchRunGUI/23_Advanced_BatchRunGUI_720.png

You can add launch files for different study types, such as:

- a regular study;
- a multi-step study;
- a position-analysis study.

.. image:: diagrams/frames/23_Advanced_BatchRunGUI/23_Advanced_BatchRunGUI_2640.png

To add launch files:

1. Browse to the launch file.

.. image:: diagrams/frames/23_Advanced_BatchRunGUI/23_Advanced_BatchRunGUI_1200.png

2. Select it.
3. Click **Add**.

.. image:: diagrams/frames/23_Advanced_BatchRunGUI/23_Advanced_BatchRunGUI_1320.png

**Sequential vs parallel**

The Batch Run dialog includes a checkbox that determines whether the studies run:

- **sequentially**;
- **in parallel**.

If the checkbox is selected, the runs are sequential. If it is cleared, the runs are parallel.

.. image:: diagrams/frames/23_Advanced_BatchRunGUI/23_Advanced_BatchRunGUI_3480.png

**Start all**

After the launch files are added and the run mode is selected:

1. Click **Start All**.

.. image:: diagrams/frames/23_Advanced_BatchRunGUI/23_Advanced_BatchRunGUI_3600.png

All selected studies begin running. Depending on the run types, multiple command windows may appear, and multi-step or position-analysis studies may proceed in blocks with intermediate processing between periods.

**Notes**

- Parallel execution can increase resource usage significantly.
- Make sure each launch file is valid before adding it to the batch list.

**Related sections**

- :ref:`24. Advanced Batch Run Cmd <24-advanced-batch-run-cmd>`
- :ref:`25. Advanced Multi Study Run <25-advanced-multi-study-run>`
- :ref:`27. DSS Wrims DSS Perspective <27-dss-wrims-dss-perspective>`


.. _24-advanced-batch-run-cmd:

24. Advanced Batch Run Cmd
--------------------------

**Purpose**

This chapter explains how to run multiple studies outside **WRIMS 2 GUI** from the command line.

**Before you start**

- You have one or more valid launch files.
- You can access the WRIMS package ``batchrun`` folder.

.. image:: diagrams/frames/24_Advanced_BatchRunCmd/24_Advanced_BatchRunCmd_600.png

**Procedure**

The WRIMS 2 package contains a ``batchrun`` folder. In this folder, the following batch files are available:

- ``parallelbatchrun``
- ``sequentialbatchrun``

.. image:: diagrams/frames/24_Advanced_BatchRunCmd/24_Advanced_BatchRunCmd_720.png

These scripts support:

- regular studies;
- multi-step studies;
- position-analysis studies;
- combinations of these workflows.

**Launch file group**

Before running the batch scripts, create a launch-file group file, ``.lfg``, which lists the launch files to run.

To prepare it:

1. Open the ``.lfg`` file in a text editor.

.. image:: diagrams/frames/24_Advanced_BatchRunCmd/24_Advanced_BatchRunCmd_2400.png

2. Put one launch-file path on each line.

.. image:: diagrams/frames/24_Advanced_BatchRunCmd/24_Advanced_BatchRunCmd_2640.png

3. Save the file.

A single ``.lfg`` file can contain, for example:

- one regular study launch file;
- one multi-step study launch file;
- one position-analysis study launch file.

**Run the batch script**

Return to the ``batchrun`` folder and run:

- ``parallelbatchrun`` for parallel execution;
- ``sequentialbatchrun`` for sequential execution.

.. image:: diagrams/frames/24_Advanced_BatchRunCmd/24_Advanced_BatchRunCmd_4680.png

The example shown here uses the parallel batch run and displays multiple studies running at the same time.

.. image:: diagrams/frames/24_Advanced_BatchRunCmd/24_Advanced_BatchRunCmd_5520.png

**Notes**

- The ``.lfg`` file is the primary input list for command-line batch running.
- Choose the parallel or sequential script based on workflow requirements and available machine resources.

**Related sections**

- :ref:`23. Advanced Batch Run GUI <23-advanced-batch-run-gui>`
- :ref:`25. Advanced Multi Study Run <25-advanced-multi-study-run>`
- :ref:`26. Advanced Position Analysis <26-advanced-position-analysis>`


.. _25-advanced-multi-study-run:

25. Advanced Multi Study Run
----------------------------

**Purpose**

This chapter depends on concepts introduced in launch file creation and batch execution. Review **03. Basic Create Launch File**, **23. Advanced Batch Run GUI**, and **24. Advanced Batch Run Cmd** before configuring multi-study workflows.

This chapter shows how to set up and run a **multi-study run**.

**Before you start**

- You have a coordinated workflow that requires multiple studies to run in sequence or in blocks.
- You know the file paths and time settings for each study in the group.

**Procedure**

A multi-study run contains several studies that run together as a coordinated workflow.

In the example shown here, there are three studies:

- study one;
- study two;
- study three.

The launch file is placed above the study folders so that it can control all of them.

**Open the configuration**

1. Load the multi-study run project.

.. image:: diagrams/frames/25_Advanced_MultiStudyRun/25_Advanced_MultiStudyRun_360.png

.. image:: diagrams/frames/25_Advanced_MultiStudyRun/25_Advanced_MultiStudyRun_600.png

2. Open **Run Configuration**.

.. image:: diagrams/frames/25_Advanced_MultiStudyRun/25_Advanced_MultiStudyRun_2040.png

3. Select the multi-study launch file.

.. image:: diagrams/frames/25_Advanced_MultiStudyRun/25_Advanced_MultiStudyRun_2160.png

**Main tab**

In the **Main** tab:

.. image:: diagrams/frames/25_Advanced_MultiStudyRun/25_Advanced_MultiStudyRun_2280.png

1. Specify the number of studies, such as ``3``.
2. Configure the main WRESL file, DV file, SV file, initial file, Part A, Part F, start date, and end date for study one.

Relative paths are recommended.

**Multi Study Runner tab**

In the **Multi Study Runner** tab, choose whether the run uses:

- **fixed duration**;
- **variable duration**.

.. image:: diagrams/frames/25_Advanced_MultiStudyRun/25_Advanced_MultiStudyRun_5280.png

**Fixed duration**

With fixed duration, specify a number of months, such as ``12``.

The execution pattern is then:

- study one runs 12 months;
- study two runs 12 months;
- study three runs 12 months;
- the run returns to study one for the next block.

**Variable duration**

With variable duration, specify a variable-duration file. A sample file may be available in the templates area.

.. image:: diagrams/frames/25_Advanced_MultiStudyRun/25_Advanced_MultiStudyRun_5880.png

.. image:: diagrams/frames/25_Advanced_MultiStudyRun/25_Advanced_MultiStudyRun_6240.png

.. image:: diagrams/frames/25_Advanced_MultiStudyRun/25_Advanced_MultiStudyRun_6360.png

A variable-duration file can define different month blocks for different rounds, such as:

- 72 months;
- then 120 months;
- then 36 months.

**Configure study two and study three**

For each additional study, configure:

- main WRESL file;
- DV file;
- SV file;
- initial file;
- Part A;
- Part F;
- initial Part F;
- SV Part F.

.. image:: diagrams/frames/25_Advanced_MultiStudyRun/25_Advanced_MultiStudyRun_9360.png

**Initial condition logic**

Initial-condition transfer works as follows:

- In the first round, each study uses its own initial file.
- After the first round:
  - study one DV becomes the initial condition for study two;
  - study two DV becomes the initial condition for study three;
  - the last study DV becomes the initial condition for study one in the next round.

**Data transfer files**

**Data transfer files** move selected DSS records from one study to the next.

.. image:: diagrams/frames/25_Advanced_MultiStudyRun/25_Advanced_MultiStudyRun_13800.png

A transfer file can include:

- **DV to DV** transfer;
- **DV to SV** transfer.

Examples include:

- a time series in the DV file of study one can be transferred to the DV file of study two;
- a time series in the DV file of study one can also be transferred to the SV file of study two.

.. image:: diagrams/frames/25_Advanced_MultiStudyRun/25_Advanced_MultiStudyRun_13920.png

The source and destination Part B values are mapped, while Part C remains the same.

**Run the multi-study workflow**

After all settings are configured, click **Run**.

The studies then rotate through the selected time blocks and continue forward through the simulation period.

**Notes**

- Relative paths are strongly recommended.
- Choose fixed or variable duration based on how long each study should run before handing control to the next one.

**Related sections**

- :ref:`23. Advanced Batch Run GUI <23-advanced-batch-run-gui>`
- :ref:`24. Advanced Batch Run Cmd <24-advanced-batch-run-cmd>`
- :ref:`27. DSS Wrims DSS Perspective <27-dss-wrims-dss-perspective>`


.. _26-advanced-position-analysis:

26. Advanced Position Analysis
------------------------------

**Purpose**

This chapter depends on launch-file setup and is closely related to re-simulation concepts. Review **03. Basic Create Launch File** and **22. Debug Force Variable Resimulation** before using position analysis.

This chapter shows how to set up and run a **Position Analysis** study.

**Before you start**

- You have a study suitable for repeated simulation with shifted initial conditions.
- You understand the desired start interval and duration for each position-analysis block.

**Procedure**

A Position Analysis study has a folder structure similar to a regular study. The main difference is in the launch configuration.

In Position Analysis:

- the same initial condition is reused for different simulation periods;
- the initial condition is shifted forward by a selected interval.

For example:

- the initial condition from October 1921 is used to simulate October 1921 to September 1922;
- then it is shifted and used again for October 1922 to September 1923;
- then again for October 1923 to September 1924.

**Configure Position Analysis**

1. Open the study launch configuration.

.. image:: diagrams/frames/26_Advanced_PositionAnalysis/26_Advanced_PositionAnalysis_1320.png

2. In the **Main** tab, check **Position Analysis**.

.. image:: diagrams/frames/26_Advanced_PositionAnalysis/26_Advanced_PositionAnalysis_3360.png

3. Set the usual file fields and dates.

Then open the **Position Analysis** tab.

.. image:: diagrams/frames/26_Advanced_PositionAnalysis/26_Advanced_PositionAnalysis_4680.png

**PA Start Interval**

The **PA Start Interval** defines how often the initial condition is shifted forward.

For example:

- ``12`` months means the same initial condition is reused every 12 months.

.. image:: diagrams/frames/26_Advanced_PositionAnalysis/26_Advanced_PositionAnalysis_4800.png

**PA Duration**

The **PA Duration** defines how long each simulation block runs.

For example:

- ``12`` months means each shifted run simulates 12 months.

.. image:: diagrams/frames/26_Advanced_PositionAnalysis/26_Advanced_PositionAnalysis_6240.png

The interval and duration do not need to be the same, although they often are.

**Delete shifted initial files**

The option **Delete PA Initial File After run completed** controls whether the shifted initial-condition files are deleted after the run.

.. image:: diagrams/frames/26_Advanced_PositionAnalysis/26_Advanced_PositionAnalysis_12120.png

**Reset output start date**

The option **Reset the Start Date of DV DSS Output** allows the simulated output to be shifted to another output year, such as mapping all results to a common year like 2013.

**Important date rule**

The start date must be the **first day of the month**.

For example:

- use **October 1**;
- do not use **October 31**.

.. image:: diagrams/frames/26_Advanced_PositionAnalysis/26_Advanced_PositionAnalysis_13320.png

Using the first day of the month avoids problems when shifting the initial condition by a number of months.

**Run**

After configuration, click **Run**.

.. image:: diagrams/frames/26_Advanced_PositionAnalysis/26_Advanced_PositionAnalysis_13680.png

The run then follows a repeating pattern:

- simulate a block;
- shift the initial condition;
- simulate the next block;
- continue through the study period.

**Notes**

- This workflow is useful for understanding how the same starting position performs across different historical windows.
- Choose **PA Start Interval** and **PA Duration** carefully; they do not have to be the same.

**Related sections**

- :ref:`03. Basic Create Launch File <03-basic-create-launch-file>`
- :ref:`22. Debug Force Variable Resimulation <22-debug-force-variable-resimulation>`
- :ref:`27. DSS Wrims DSS Perspective <27-dss-wrims-dss-perspective>`
