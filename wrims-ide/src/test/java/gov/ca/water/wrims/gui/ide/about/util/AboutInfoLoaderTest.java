package gov.ca.water.wrims.gui.ide.about.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class AboutInfoLoaderTest {
	@Test
	void testInfoLoader() {
		System.setProperty(AboutInfoLoader.SYSTEM_PROPERTY, "src/test/resources/about.txt");
		AboutInfoLoader loader = AboutInfoLoader.getInstance();
		assertEquals("This is an example about file for the Wrims IDE.",
				loader.getAboutText());
		System.clearProperty(AboutInfoLoader.SYSTEM_PROPERTY);
	}

	@Test
	void testSingleton() {
		System.setProperty(AboutInfoLoader.SYSTEM_PROPERTY, "src/test/resources/about.txt");
		AboutInfoLoader loader = AboutInfoLoader.getInstance();
		AboutInfoLoader loader2 = AboutInfoLoader.getInstance();
		assertEquals(loader, loader2);
		System.clearProperty(AboutInfoLoader.SYSTEM_PROPERTY);
	}
}
