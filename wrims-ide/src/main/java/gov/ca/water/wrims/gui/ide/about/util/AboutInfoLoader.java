package gov.ca.water.wrims.gui.ide.about.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

import com.google.common.flogger.FluentLogger;
import org.apache.commons.io.IOUtils;

public class AboutInfoLoader {
	private static final FluentLogger LOGGER = FluentLogger.forEnclosingClass();
	private static final String ABOUT_FILE = "about_wrims.txt";
	private static final String ABOUT_TEXT_FALLBACK = "WRIMS (Water Resources Integrated Modeling System) is a"
			+ "generalized water resources modeling system for evaluating operational alternatives of large,"
			+ "complex river basins.";
	private static AboutInfoLoader instance;
	private String aboutText;

	private AboutInfoLoader() {
		loadAbout();
	}

	public static AboutInfoLoader getInstance() {
		if (instance == null) {
			instance = new AboutInfoLoader();
		}
		return instance;
	}

	public String getAboutText() {
		return aboutText;
	}

	private void loadAbout() {
		Path aboutPath = Path.of(ABOUT_FILE).toAbsolutePath();
		LOGGER.atFiner().log("Loading about panel text content from: " + aboutPath);
		try (InputStream is = new FileInputStream(aboutPath.toFile())) {
			if(is.available() != 0) {
				aboutText = IOUtils.toString(is, StandardCharsets.UTF_8);
			} else {
				LOGGER.atFiner().log("About text not found, using fallback values");
				setDefaultValues();
			}
		} catch(IOException e) {
			setDefaultValues();
		}
	}

	private void setDefaultValues() {
		aboutText = ABOUT_TEXT_FALLBACK;
	}
}
