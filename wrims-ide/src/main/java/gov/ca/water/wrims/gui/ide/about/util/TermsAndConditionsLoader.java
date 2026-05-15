package gov.ca.water.wrims.gui.ide.about.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

import com.google.common.flogger.FluentLogger;
import org.apache.commons.io.IOUtils;

public final class TermsAndConditionsLoader {
	private static final FluentLogger LOGGER = FluentLogger.forEnclosingClass();
	public static final String SYSTEM_PROPERTY = "gov.ca.water.wrims.terms.conditions";
	private static final String TERMS_AND_CONDITIONS = System.getProperty(SYSTEM_PROPERTY,
			"terms_and_conditions.txt");
	private static final TermsAndConditionsLoader instance = new TermsAndConditionsLoader();
	private String termsAndConditions;

	private TermsAndConditionsLoader() {
		loadTerms();
	}

	public static TermsAndConditionsLoader getInstance() {
		return instance;
	}

	public String getTermsAndConditions() {
		return termsAndConditions;
	}

	private void loadTerms() {
		Path termsPath = Path.of(TERMS_AND_CONDITIONS).toAbsolutePath();
		LOGGER.atFiner().log("Loading terms and conditions from: " + termsPath);
		try (InputStream is = new FileInputStream(termsPath.toFile())) {
			termsAndConditions = IOUtils.toString(is, StandardCharsets.UTF_8);
			if (termsAndConditions.isEmpty() || termsAndConditions.isBlank()) {
				LOGGER.atFiner().log("Terms and conditions not found, using fallback values");
				setDefaultValues();
			}
		} catch(IOException e) {
			setDefaultValues();
		}
	}

	private void setDefaultValues() {
		termsAndConditions = "No terms and conditions available.";
	}
}
