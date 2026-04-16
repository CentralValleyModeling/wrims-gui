package gov.ca.water.wrims.gui.ide.perspective.version;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Properties;

import com.google.common.flogger.FluentLogger;

public final class VersionInfo {
	private static final FluentLogger LOGGER = FluentLogger.forEnclosingClass();
	private static final String VERSION_PROPERTIES = "version.properties";
	private static final String VERSION_FALLBACK = "unknown";
	private static VersionInfo instance;

	private String version;
	private String buildDate;
	private String engineVersion;
	private String applicationName;

	private VersionInfo() {
		loadVersionInfo();
	}

	public static VersionInfo getInstance() {
		if (instance == null) {
			instance = new VersionInfo();
		}
		return instance;
	}

	private void loadVersionInfo() {
		Properties props = new Properties();
		Path propertiesPath = Path.of(VERSION_PROPERTIES).toAbsolutePath();
		LOGGER.atInfo().log("Loading version info from: " + propertiesPath);
		LOGGER.atInfo().log("Is a file?: " + propertiesPath.toFile().isFile());
		try (InputStream is = getClass().getResourceAsStream(propertiesPath.toString())) {
			if (is != null) {
				props.load(is);
				LOGGER.atInfo().log("Version info loaded");
				LOGGER.atInfo().log(props.toString());
				version = props.getProperty("version", VERSION_FALLBACK);
				buildDate = props.getProperty("build.date", VERSION_FALLBACK);
				engineVersion = props.getProperty("engine.version", VERSION_FALLBACK);
				applicationName = props.getProperty("application.name", "WRIMS GUI");
			} else {
				// Fallback values if properties file is not found
				LOGGER.atInfo().log("Version info not found, using fallback values");
				setDefaultValues();
			}
		} catch (IOException e) {
			setDefaultValues();
		}
	}

	private void setDefaultValues() {
		version = VERSION_FALLBACK;
		buildDate = VERSION_FALLBACK;
		engineVersion = VERSION_FALLBACK;
		applicationName = "WRIMS GUI";
	}

	public String getVersion() {
		return version;
	}

	public String getBuildDate() {
		return buildDate;
	}

	public String getEngineVersion() {
		return engineVersion;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public String getFullVersionString() {
		return applicationName + " " + version + " (Engine: " + engineVersion + ", Build: " + buildDate + ")";
	}
}
