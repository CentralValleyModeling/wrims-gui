package gov.ca.water.wrims.gui.ide.about.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Properties;

import com.google.common.flogger.FluentLogger;

public final class VersionInfo {
	private static final FluentLogger LOGGER = FluentLogger.forEnclosingClass();
	public static final String SYSTEM_PROPERTY = "gov.ca.water.wrims.version.properties";
	private static final String VERSION_PROPERTIES = System.getProperty(SYSTEM_PROPERTY, "version.properties");
	private static final String VERSION_FALLBACK = "unknown";
	private static final VersionInfo instance = new VersionInfo();

	private String version = null;
	private String buildDate = null;
	private String engineVersion = null;
	private String applicationName = null;
	private String imagePlugin = null;

	private VersionInfo() {
		loadVersionInfo();
	}

	public static VersionInfo getInstance() {
		return instance;
	}

	private void loadVersionInfo() {
		Properties props = new Properties();
		Path propertiesPath = Path.of(VERSION_PROPERTIES).toAbsolutePath();
		LOGGER.atFiner().log("Loading version info from: " + propertiesPath);
		try (InputStream is = new FileInputStream(propertiesPath.toFile())) {
				props.load(is);
				LOGGER.atFiner().log("Version info loaded: %s", props);
				version = props.getProperty("version", VERSION_FALLBACK);
				buildDate = props.getProperty("build.date", VERSION_FALLBACK);
				engineVersion = props.getProperty("engine.version", VERSION_FALLBACK);
				applicationName = props.getProperty("application.name", "WRIMS GUI");
				imagePlugin = props.getProperty("image.plugin", VERSION_FALLBACK);
			if (version == null || buildDate == null || engineVersion == null || applicationName == null
					|| imagePlugin == null || imagePlugin.isEmpty() || version.isEmpty() || buildDate.isEmpty()
					|| engineVersion.isEmpty() || applicationName.isEmpty()) {
				// Fallback values if properties file is not found
				LOGGER.atFiner().log("Version info not found, using fallback values");
				setDefaultValues();
			}
		} catch (IOException e) {
			LOGGER.atFiner().withCause(e).log("Could not load version info");
			setDefaultValues();
		}
	}

	private void setDefaultValues() {
		version = VERSION_FALLBACK;
		buildDate = VERSION_FALLBACK;
		engineVersion = VERSION_FALLBACK;
		applicationName = "WRIMS GUI";
		imagePlugin = VERSION_FALLBACK;
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

	public String getImagePlugin() {
		return imagePlugin;
	}
}
