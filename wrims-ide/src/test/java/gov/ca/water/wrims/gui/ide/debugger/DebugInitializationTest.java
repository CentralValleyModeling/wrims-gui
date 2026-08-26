package gov.ca.water.wrims.gui.ide.debugger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import gov.ca.water.wrims.gui.ide.debugger.core.DebugCorePlugin;
import gov.ca.water.wrims.gui.ide.debugger.launcher.WPPLaunchDelegate;
import gov.ca.water.wrims.gui.ide.debugger.model.WPPDebugTarget;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;
import org.mockito.MockedStatic;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

/** Tests debug startup, socket initialization, JDWP configuration, and cleanup. */
class DebugInitializationTest {

    private final String originalJdwpPort = System.getProperty("wrims.jdwp.port");

    @AfterEach
    void restoreJdwpPort() {
        if (originalJdwpPort == null) {
            System.clearProperty("wrims.jdwp.port");
        } else {
            System.setProperty("wrims.jdwp.port", originalJdwpPort);
        }
    }

    @Test
    /** Verifies debug sessions use an automatically allocated JDWP port by default. */
    void defaultsToDynamicJdwpPort() throws Exception {
        System.clearProperty("wrims.jdwp.port");

        assertEquals("-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:0",
                remoteDebugSettings());
    }

    @Test
    /** Verifies configured JDWP ports are honored and JDWP can be disabled. */
    void usesConfiguredJdwpPortAndSupportsDisabledValues() throws Exception {
        System.setProperty("wrims.jdwp.port", " 5006 ");
        assertEquals("-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5006",
                remoteDebugSettings());

        System.setProperty("wrims.jdwp.port", "off");
        assertEquals("", remoteDebugSettings());

        System.setProperty("wrims.jdwp.port", "false");
        assertEquals("", remoteDebugSettings());
    }

    @Test
    /** Verifies startup sends each required request before enabling run controls. */
    void getStartSendsAllStartupRequestsBeforeEnablingRunControls() throws Exception {
        List<String> requests = new ArrayList<>();
        TestDebugTarget target = allocate(TestDebugTarget.class);
        target.requests = requests;

        target.getStart();

        assertEquals(List.of(
                "start",
            "time:" + DebugCorePlugin.debugYear + "/"
                + DebugCorePlugin.debugMonth + "/"
                + DebugCorePlugin.debugDay + "/"
                + DebugCorePlugin.debugCycle,
            "conditional_breakpoint:" + DebugCorePlugin.conditionalBreakpoint), requests);
        assertTrue(target.controlsEnabled);
    }

    @Test
    /** Verifies a missing startup response is propagated as a debug failure. */
    void getStartFailsWhenStartupRequestHasNoResponse() throws Exception {
        TestDebugTarget target = allocate(TestDebugTarget.class);
        target.requests = new ArrayList<>();
        target.returnNull = true;

        assertThrows(DebugException.class, target::getStart);
        assertFalse(target.controlsEnabled);
    }

    @Test
    /** Verifies an available VM port can be connected to successfully. */
    void socketConnectionSucceedsWhenPortIsAvailable() throws Exception {
        try (ServerSocket server = new ServerSocket(0)) {
            TestDebugTarget target = allocate(TestDebugTarget.class);
            Method connect = WPPDebugTarget.class.getDeclaredMethod("connectSocketWithRetry", int.class);
            connect.setAccessible(true);

            try (Socket socket = invokeSocket(connect, target, server.getLocalPort())) {
                assertTrue(socket.isConnected());
            }
        }
    }

    @Test
    /** Verifies socket initialization stops when the VM process has already terminated. */
    void socketConnectionStopsImmediatelyWhenProcessTerminated() throws Exception {
        TestDebugTarget target = allocate(TestDebugTarget.class);
        setProcess(target, processProxy(true));
        Method connect = WPPDebugTarget.class.getDeclaredMethod("connectSocketWithRetry", int.class);
        connect.setAccessible(true);

        InvocationTargetException failure = assertThrows(InvocationTargetException.class,
                () -> connect.invoke(target, 1));
        assertTrue(failure.getCause() instanceof IOException);
        assertTrue(failure.getCause().getMessage().contains("terminated before opening port 1"));
    }

    @Test
    /** Verifies a process started for debugging is cleaned up after initialization fails. */
    void cleanupTerminatesStartedJavaProcess() throws Exception {
        Process process = new ProcessBuilder(javaBinary(), "-version").start();
        Method cleanup = WPPLaunchDelegate.class.getDeclaredMethod("cleanupStartedDebugProcess", IProcess.class,
                Process.class);
        cleanup.setAccessible(true);

        cleanup.invoke(new WPPLaunchDelegate(), null, process);

        assertTrue(process.waitFor(1, java.util.concurrent.TimeUnit.SECONDS));
    }

    @Test
    /** Verifies a registered debug target is retained for a regular debug session. */
    void runDebugSessionRegistersTargetAndReturnsProcessExitCode() throws Exception {
        Method runDebugSession = WPPLaunchDelegate.class.getDeclaredMethod("runDebugSession", ILaunch.class,
                int.class, int.class, boolean.class);
        runDebugSession.setAccessible(true);
        ILaunch launch = mock(ILaunch.class);
        Runtime runtime = mock(Runtime.class);
        Process process = mock(Process.class);
        IProcess eclipseProcess = mock(IProcess.class);
        when(runtime.exec("WRIMSv3_Engine.bat")).thenReturn(process);
        when(process.exitValue()).thenReturn(17);

        try (MockedStatic<Runtime> runtimeMock = mockStatic(Runtime.class);
            MockedStatic<DebugPlugin> debugPluginMock = mockStatic(DebugPlugin.class);
            MockedConstruction<WPPDebugTarget> targetMock = mockConstruction(WPPDebugTarget.class)) {
            runtimeMock.when(Runtime::getRuntime).thenReturn(runtime);
            debugPluginMock.when(() -> DebugPlugin.newProcess(launch, process, "DebugWPP"))
                .thenReturn(eclipseProcess);

            int exitCode = invokeRunDebugSession(runDebugSession, launch, false);

            assertEquals(17, exitCode);
            verify(launch).addDebugTarget(targetMock.constructed().get(0));
            verify(launch, org.mockito.Mockito.never()).removeDebugTarget(any());
            verify(process).waitFor();
        }
    }

    @Test
    /** Verifies completed sessions remove their target and destroy the engine process. */
    void runDebugSessionRemovesTargetWhenRequested() throws Exception {
        Method runDebugSession = WPPLaunchDelegate.class.getDeclaredMethod("runDebugSession", ILaunch.class,
            int.class, int.class, boolean.class);
        runDebugSession.setAccessible(true);
        ILaunch launch = mock(ILaunch.class);
        Runtime runtime = mock(Runtime.class);
        Process process = mock(Process.class);
        IProcess eclipseProcess = mock(IProcess.class);
        when(runtime.exec("WRIMSv3_Engine.bat")).thenReturn(process);
        when(process.exitValue()).thenReturn(0);

        try (MockedStatic<Runtime> runtimeMock = mockStatic(Runtime.class);
            MockedStatic<DebugPlugin> debugPluginMock = mockStatic(DebugPlugin.class);
            MockedConstruction<WPPDebugTarget> targetMock = mockConstruction(WPPDebugTarget.class)) {
            runtimeMock.when(Runtime::getRuntime).thenReturn(runtime);
            debugPluginMock.when(() -> DebugPlugin.newProcess(launch, process, "DebugWPP"))
                .thenReturn(eclipseProcess);

            assertEquals(0, invokeRunDebugSession(runDebugSession, launch, true));

            verify(launch).removeDebugTarget(targetMock.constructed().get(0));
            verify(process).destroy();
        }
    }

    @Test
    /** Verifies initialization failure cleans up an unregistered debug process. */
    void runDebugSessionCleansUpWhenTargetInitializationFails() throws Exception {
        Method runDebugSession = WPPLaunchDelegate.class.getDeclaredMethod("runDebugSession", ILaunch.class,
            int.class, int.class, boolean.class);
        runDebugSession.setAccessible(true);
        ILaunch launch = mock(ILaunch.class);
        Runtime runtime = mock(Runtime.class);
        Process process = mock(Process.class);
        IProcess eclipseProcess = mock(IProcess.class);
        when(runtime.exec("WRIMSv3_Engine.bat")).thenReturn(process);
        when(process.isAlive()).thenReturn(true);
        when(process.waitFor(5, java.util.concurrent.TimeUnit.SECONDS)).thenReturn(true);
        when(eclipseProcess.isTerminated()).thenReturn(false);

        try (MockedStatic<Runtime> runtimeMock = mockStatic(Runtime.class);
            MockedStatic<DebugPlugin> debugPluginMock = mockStatic(DebugPlugin.class);
            MockedConstruction<WPPDebugTarget> targetMock = mockConstruction(WPPDebugTarget.class,
                (target, context) -> doThrow(new DebugException(
                    new Status(IStatus.ERROR, "test", "startup failed"))).when(target).getStart())) {
            runtimeMock.when(Runtime::getRuntime).thenReturn(runtime);
            debugPluginMock.when(() -> DebugPlugin.newProcess(launch, process, "DebugWPP"))
                .thenReturn(eclipseProcess);

            InvocationTargetException failure = assertThrows(InvocationTargetException.class,
                () -> invokeRunDebugSession(runDebugSession, launch, false));

            assertTrue(failure.getCause() instanceof DebugException);
            verify(eclipseProcess).terminate();
            verify(process).destroy();
            verifyNoInteractions(launch);
        }
    }

        private static int invokeRunDebugSession(Method method, ILaunch launch, boolean removeTarget) throws Exception {
        return (int) method.invoke(new WPPLaunchDelegate(), launch, 1, 2, removeTarget);
        }

    private static String remoteDebugSettings() throws Exception {
        Method method = WPPLaunchDelegate.class.getDeclaredMethod("getRemoteDebugSettings");
        method.setAccessible(true);
        return (String) method.invoke(new WPPLaunchDelegate());
    }

    private static Socket invokeSocket(Method method, WPPDebugTarget target, int port) throws Exception {
        return (Socket) method.invoke(target, port);
    }

    private static void setProcess(WPPDebugTarget target, IProcess process) throws Exception {
        java.lang.reflect.Field field = WPPDebugTarget.class.getDeclaredField("fProcess");
        field.setAccessible(true);
        field.set(target, process);
    }

    private static IProcess processProxy(boolean terminated) {
        AtomicBoolean isTerminated = new AtomicBoolean(terminated);
        return (IProcess) Proxy.newProxyInstance(IProcess.class.getClassLoader(), new Class<?>[] {IProcess.class},
                (proxy, method, args) -> {
                    if (method.getName().equals("isTerminated")) {
                        return isTerminated.get();
                    }
                    if (method.getReturnType() == boolean.class) {
                        return false;
                    }
                    return null;
                });
    }

    private static String javaBinary() {
        return java.nio.file.Path.of(System.getProperty("java.home"), "bin", "java.exe").toString();
    }

    @SuppressWarnings("unchecked")
    private static <T> T allocate(Class<T> type) throws Exception {
        java.lang.reflect.Field field = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        return (T) ((sun.misc.Unsafe) field.get(null)).allocateInstance(type);
    }

    private static class TestDebugTarget extends WPPDebugTarget {
        private List<String> requests = new ArrayList<>();
        private boolean returnNull;
        private boolean controlsEnabled;

        TestDebugTarget() throws Exception {
            super(null, null, 0, 0);
        }

        @Override
        public String sendRequest(String request) throws DebugException {
            requests.add(request);
            return returnNull ? null : "ok";
        }

        @Override
        public void enableRunMenuWithStart() {
            controlsEnabled = true;
        }
    }
}