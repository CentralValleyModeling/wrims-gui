package gov.ca.water.wrims.gui.ide.about.util;

import org.junit.jupiter.api.Test;

import static gov.ca.water.wrims.gui.ide.about.util.TermsAndConditionsLoader.SYSTEM_PROPERTY;
import static org.junit.jupiter.api.Assertions.assertEquals;

final class TermsAndConditionsLoaderTest {
	@Test
	void testTCLoader() {
		System.setProperty(SYSTEM_PROPERTY, "src/test/resources/terms_and_conditions.txt");
		TermsAndConditionsLoader loader = TermsAndConditionsLoader.getInstance();
		String termsAndConditions = loader.getTermsAndConditions().replace("\r", "").replace("\n", "");
		assertEquals("These are test terms and conditions.<a href=\"http://www.water.ca.gov\">DWR</a>",
				termsAndConditions);
		System.clearProperty(SYSTEM_PROPERTY);
	}

	@Test
	void testSingleton() {
		System.setProperty(SYSTEM_PROPERTY, "src/test/resources/terms_and_conditions.txt");
		TermsAndConditionsLoader loader = TermsAndConditionsLoader.getInstance();
		TermsAndConditionsLoader loader2 = TermsAndConditionsLoader.getInstance();
		assertEquals(loader, loader2);
		System.clearProperty(SYSTEM_PROPERTY);
	}
}
