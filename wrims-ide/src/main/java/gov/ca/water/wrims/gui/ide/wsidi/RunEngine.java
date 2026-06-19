package gov.ca.water.wrims.gui.ide.wsidi;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.common.flogger.FluentLogger;
import gov.ca.water.wrims.engine.core.components.ControllerBatch;
import gov.ca.water.wrims.gui.ide.about.util.VersionInfo;

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
		String jrePluginFolder = findJrePluginFolder("plugins");
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
		VersionInfo info = VersionInfo.getInstance();
		String engineVer = info.getEngineVersion();
		List<String> jars = new ArrayList<>();
		jars.add("antlr-runtime-");
		jars.add("slf4j-api-");
		jars.add("slf4j-nop-");
		jars.add("wrims-core-");
		jars.add("commons-io-");
		StringBuilder classpath = new StringBuilder(String.format("lib/wrims-core-%s.jar", engineVer));
		for (String jar : jars) {
			String foundJar = getJarFile(jar);
			classpath.append(";lib/").append(foundJar);
		}
		command.add("-cp");
		command.add(classpath.toString());

		// Main class and arguments
		command.add(ControllerBatch.class.getCanonicalName());
		command.add("-config=" + configFilePath);

		return command;
	}

	private String getJarFile(String prefix) {
		File libsDir = new File("lib");
		if (!libsDir.exists() || !libsDir.isDirectory()) {
			logger.atWarning().log("Library directory not found: %s", libsDir);
			return null;
		}

		File[] jars = libsDir.listFiles(File::isFile);
		if (jars == null) {
			logger.atWarning().log("Failed to list jars in: %s", libsDir);
			return null;
		}

		for (File jar : jars) {
			if (jar.getName().startsWith(prefix) && jar.getName().endsWith(".jar")) {
				logger.atFiner().log("Found jar: %s", jar.getName());
				return jar.getName();
			}
		}

		logger.atWarning().log("Jar with prefix '%s' not found in library directory", JRE_PLUGIN_PREFIX);
		return null;
	}

	private String findJrePluginFolder(String pluginsPath) {
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
