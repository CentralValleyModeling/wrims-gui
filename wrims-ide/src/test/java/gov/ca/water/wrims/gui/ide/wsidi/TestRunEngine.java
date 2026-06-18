package gov.ca.water.wrims.gui.ide.wsidi;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

final class TestRunEngine {
	@Disabled("This test relies on the JRE being available, which is only the case in a built WRIMS installation")
	@Test
	void testRunEngine() {
		String externalPath = "J:\\WRIMS\\test_HecLib7\\DCP_NDD_SWP6000_2020\\CALSIM\\Run\\External";
		String configFilePath = "J:\\WRIMS\\test_HecLib7\\DCP_NDD_SWP6000_2020\\CALSIM\\__study.config";
		RunEngine engine = new RunEngine(externalPath, configFilePath);
		assertDoesNotThrow(engine::execute);
	}
}
