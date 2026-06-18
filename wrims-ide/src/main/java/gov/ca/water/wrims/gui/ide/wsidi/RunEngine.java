package gov.ca.water.wrims.gui.ide.wsidi;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.common.flogger.FluentLogger;
import gov.ca.water.wrims.engine.core.components.ControllerBatch;
import gov.ca.water.wrims.gui.ide.debugger.exception.WPPException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

public final class RunEngine {
	private static final FluentLogger logger = FluentLogger.forEnclosingClass();
	private static final int MAX_HEAP_SIZE = 4096; // Default heap size in MB
	private static final int STACK_SIZE = 1024; // Default stack size in KB
	private static final String TIMEZONE = "UTC";
	private static final String NAME = "51677";

	private final String externalPath;
	private final String configFilePath;

	public RunEngine(String externalPath, String configFilePath) {
		this.externalPath = externalPath;
		this.configFilePath = configFilePath;
	}

	public void execute() throws IOException {
		List<String> command = buildCommand();

		ProcessBuilder processBuilder = new ProcessBuilder(command);
		processBuilder.inheritIO(); // This allows output to be seen in console

		Process process = processBuilder.start();

		// Optionally wait for process completion
		try {
			int exitCode = process.waitFor();
			if (exitCode != 0) {
				logger.atWarning().log("WRIMS engine execution failed with exit code: %s", exitCode);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			throw new RuntimeException("Process was interrupted", e);
		}
	}

	private List<String> buildCommand() {
		List<String> command = new ArrayList<>();

		// Java executable
		command.add("plugins\\org.eclipse.justj.openjdk.hotspot.jre.full.win32.x86_64_21.0.7.v20250502-0916\\jre\\bin\\java");
		String jrePath = getJREPath();
		logger.atInfo().log("JRE Path: %s", jrePath);

		// JVM arguments
		command.add("-Xmx" + MAX_HEAP_SIZE + "m");
		command.add("-Xss" + STACK_SIZE + "K");
		command.add("-Duser.timezone=" + TIMEZONE);
		command.add("-Dname=" + NAME);

		// Library path
		String libraryPath = externalPath + ";lib";
		command.add("-Djava.library.path=" + libraryPath);

		// Classpath
		String classpath = "";
		command.add("-cp");
		command.add(classpath);

		// Main class and arguments
		command.add(ControllerBatch.class.getCanonicalName());
		command.add("-config=" + configFilePath);

		return command;
	}

	private static String getJREPath() {
		try {
			Bundle bnd = Platform.getBundle("org.eclipse.justj.openjdk.hotspot.jre.full");
			if (bnd != null) {
				// Get the base URL of the bundle
				URL bundleUrl = bnd.getEntry("/");

				// Resolve the URL to a local file system path
				URL fileUrl = FileLocator.toFileURL(bundleUrl);

				// Convert to a clean file path string
				return fileUrl.getPath();
			}
		} catch (Exception e) {
			WPPException.handleException(e);
		}
		return null;
	}
}
