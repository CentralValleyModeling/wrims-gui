package gov.ca.water.wrims.gui.ide.about.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

import com.google.common.flogger.FluentLogger;
import org.apache.commons.io.IOUtils;

public final class AboutInfoLoader {
	private static final FluentLogger LOGGER = FluentLogger.forEnclosingClass();
	public static final String SYSTEM_PROPERTY = "gov.ca.water.wrims.about";
	private static final String ABOUT_FILE = System.getProperty(SYSTEM_PROPERTY, "about_wrims.txt");
	private static final String ABOUT_TEXT_FALLBACK = "WRIMS (Water Resources Integrated Modeling System) is a"
			+ " generalized water resources modeling system for evaluating operational alternatives of large,"
			+ " complex river basins.";
	private static final AboutInfoLoader instance = new AboutInfoLoader();
	private String aboutText;

	private AboutInfoLoader() {
		loadAbout();
	}

	public static AboutInfoLoader getInstance() {
		return instance;
	}

	public String getAboutText() {
		return aboutText;
	}

	private void loadAbout() {
		Path aboutPath = Path.of(ABOUT_FILE).toAbsolutePath();
		LOGGER.atFiner().log("Loading about panel text content from: " + aboutPath);
		try (InputStream is = new FileInputStream(aboutPath.toFile())) {
			aboutText = IOUtils.toString(is, StandardCharsets.UTF_8);
			if (aboutText.isEmpty() || aboutText.isBlank()) {
				LOGGER.atFiner().log("About text not found, using fallback values");
				setDefaultValues();
			}
		} catch(IOException e) {
			LOGGER.atFiner().withCause(e).log("Could not load about panel text content");
			setDefaultValues();
		}
	}

	private void setDefaultValues() {
		aboutText = ABOUT_TEXT_FALLBACK;
	}
}
