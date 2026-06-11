package gov.ca.water.wrims.gui.ide.wsidi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import gov.ca.water.wrims.engine.core.components.ControllerBatch;

public final class RunEngine
{
	private static final int maxHeapSize = 4096; // Default heap size in MB
	private static final int stackSize = 1024; // Default stack size in KB
	private static final String timezone = "UTC";
	private static final String name = "51677";

	private final String externalPath;
	private final String configFilePath;

	private RunEngine(String externalPath, String configFilePath) {
		this.externalPath = externalPath;
		this.configFilePath = configFilePath;
	}

	public void execute() throws IOException
	{
		List<String> command = buildCommand();

		ProcessBuilder processBuilder = new ProcessBuilder(command);
		processBuilder.inheritIO(); // This allows output to be seen in console

		Process process = processBuilder.start();

		// Optionally wait for process completion
		try {
			int exitCode = process.waitFor();
			if (exitCode != 0) {
				System.err.println("WRIMS engine execution failed with exit code: " + exitCode);
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			throw new RuntimeException("Process was interrupted", e);
		}
	}

	private List<String> buildCommand() {
		List<String> command = new ArrayList<>();

		// Java executable
		command.add("jre\\bin\\java");

		// JVM arguments
		command.add("-Xmx" + maxHeapSize + "m");
		command.add("-Xss" + stackSize + "K");
		command.add("-Duser.timezone=" + timezone);

		if (name != null) {
			command.add("-Dname=" + name);
		}

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
}
