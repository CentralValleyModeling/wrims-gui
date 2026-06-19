package gov.ca.water.wrims.gui.ide.wsidi;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.common.flogger.FluentLogger;
import gov.ca.water.wrims.engine.core.components.ControllerBatch;

public final class RunEngine {
	private static final FluentLogger logger = FluentLogger.forEnclosingClass();
	private static final String JRE_PLUGIN_PREFIX = "org.eclipse.justj.openjdk.hotspot.jre.full";
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
				logger.atSevere().log("WRIMS engine execution failed with exit code: %s", exitCode);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			throw new RuntimeException("Process was interrupted", e);
		}
	}

	private List<String> buildCommand() {
		List<String> command = new ArrayList<>();

		// Java executable
		String jrePluginFolder = findJrePluginFolder();
		command.add("plugins\\" + jrePluginFolder + "\\jre\\bin\\java");

		// JVM arguments
		command.add("-Xmx" + MAX_HEAP_SIZE + "m");
		command.add("-Xss" + STACK_SIZE + "K");
		command.add("-Duser.timezone=" + TIMEZONE);
		command.add("-Dname=" + NAME);

		// Library path
		String libraryPath = externalPath + ";lib";
		command.add("-Djava.library.path=" + libraryPath);

		// Classpath
		command.add("-cp");
		String classpath = String.format("%s;lib/*", externalPath);
		command.add(classpath);

		// Main class and arguments
		command.add(ControllerBatch.class.getCanonicalName());
		command.add("-config=" + configFilePath);

		logger.atFiner().log("Executing command: %s", command);

		return command;
	}

	private String findJrePluginFolder() {
		String pluginsPath = "plugins";
		File pluginsDir = new File(pluginsPath);
		if (!pluginsDir.exists() || !pluginsDir.isDirectory()) {
			logger.atWarning().log("Plugins directory not found: %s", pluginsPath);
			return null;
		}

		File[] directories = pluginsDir.listFiles(File::isDirectory);
		if (directories == null) {
			logger.atWarning().log("Failed to list directories in: %s", pluginsPath);
			return null;
		}

		for (File dir : directories) {
			if (dir.getName().startsWith(JRE_PLUGIN_PREFIX)) {
				logger.atFiner().log("Found JRE plugin folder: %s", dir.getName());
				return dir.getName();
			}
		}

		logger.atWarning().log("JRE plugin folder with prefix '%s' not found in: %s", JRE_PLUGIN_PREFIX, pluginsPath);
		return null;
	}
}
