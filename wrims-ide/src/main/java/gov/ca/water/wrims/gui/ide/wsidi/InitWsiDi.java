package gov.ca.water.wrims.gui.ide.wsidi;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.common.flogger.FluentLogger;
import gov.ca.water.wrims.gui.ide.wsidi.WSIDIGenerator.Main;
import org.graalvm.polyglot.Context;
import org.graalvm.python.embedding.GraalPyResources;

public final class InitWsiDi {
	private static final FluentLogger logger = FluentLogger.forEnclosingClass();
	private static final String RESOURCE_PATH = "WSIDIGenerator/";
	private static final String PYTHON = "python";

	private InitWsiDi() {}

	public static void run(String studyDvName, String lookupName, String launchName,
			double offset, String externalPath, String configFilePath)
	{
		try(var context = createPythonContext())
		{
			// Configure the Python context to include the path to the Python resources, otherwise a ModuleNotFoundError will occur
			context.getBindings(PYTHON).putMember("sys_path", RESOURCE_PATH);
			context.eval(PYTHON, "import sys");
			context.eval(PYTHON, "sys.path.append(sys_path)");

			Main wsidiMain = context.eval(PYTHON, "from Main import Main; Main()").as(Main.class);

			wsidiMain.main(studyDvName, lookupName, launchName, offset, externalPath, configFilePath);
		}
	}

	private static Context createPythonContext() {
		Path resourcePath = Paths.get(RESOURCE_PATH).toAbsolutePath();
		logger.atFiner().log("WSIDI Generator resource path: %s", resourcePath.toAbsolutePath());
		return GraalPyResources.contextBuilder(resourcePath)
				.allowAllAccess(true)
				.build();
	}
}
