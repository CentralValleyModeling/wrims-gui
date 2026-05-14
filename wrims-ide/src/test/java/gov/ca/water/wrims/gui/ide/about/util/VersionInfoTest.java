package gov.ca.water.wrims.gui.ide.about.util;

import org.junit.jupiter.api.Test;

import static gov.ca.water.wrims.gui.ide.about.util.VersionInfo.SYSTEM_PROPERTY;
import static org.junit.jupiter.api.Assertions.assertEquals;

final class VersionInfoTest {
	@Test
	void testVersionInfo() {
		System.setProperty(SYSTEM_PROPERTY, "src/test/resources/version.properties");
		VersionInfo info = VersionInfo.getInstance();
		assertEquals("3.0.0-beta", info.getVersion());
		assertEquals("2026-01-01", info.getBuildDate());
		assertEquals("3.0.1-beta", info.getEngineVersion());
		assertEquals("WRIMS 3", info.getApplicationName());
		System.clearProperty(SYSTEM_PROPERTY);
	}

	@Test
	void testSingleton() {
		System.setProperty(SYSTEM_PROPERTY, "src/test/resources/version.properties");
		VersionInfo info = VersionInfo.getInstance();
		VersionInfo info2 = VersionInfo.getInstance();
		assertEquals(info, info2);
		System.clearProperty(SYSTEM_PROPERTY);
	}
}
