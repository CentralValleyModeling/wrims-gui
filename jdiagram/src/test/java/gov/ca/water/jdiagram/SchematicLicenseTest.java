package gov.ca.water.jdiagram;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SchematicLicenseTest
{
	private static ByteArrayInputStream resource(String content)
	{
		return new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
	}

	@Test
	void systemPropertyWinsOverEnvironmentAndResource()
	{
		Properties properties = new Properties();
		properties.setProperty(SchematicLicense.SYSTEM_PROPERTY, " prop-key ");
		Map<String, String> environment = Map.of(SchematicLicense.ENVIRONMENT_VARIABLE, "env-key");

		Optional<String> key = SchematicLicense.resolveKey(properties, environment, resource("licenseKey=resource-key"));

		assertEquals(Optional.of("prop-key"), key);
	}

	@Test
	void environmentWinsOverResource()
	{
		Map<String, String> environment = Map.of(SchematicLicense.ENVIRONMENT_VARIABLE, "env-key");

		Optional<String> key = SchematicLicense.resolveKey(new Properties(), environment, resource("licenseKey=resource-key"));

		assertEquals(Optional.of("env-key"), key);
	}

	@Test
	void resourceUsedWhenNothingElseSet()
	{
		Optional<String> key = SchematicLicense.resolveKey(new Properties(), Map.of(), resource("licenseKey=resource-key"));

		assertEquals(Optional.of("resource-key"), key);
	}

	@Test
	void blankValuesAreTreatedAsMissing()
	{
		Properties properties = new Properties();
		properties.setProperty(SchematicLicense.SYSTEM_PROPERTY, "   ");
		Map<String, String> environment = Map.of(SchematicLicense.ENVIRONMENT_VARIABLE, "");

		Optional<String> key = SchematicLicense.resolveKey(properties, environment, resource("licenseKey="));

		assertTrue(key.isEmpty());
	}

	@Test
	void missingEverythingYieldsEmpty()
	{
		assertTrue(SchematicLicense.resolveKey(new Properties(), Map.of(), null).isEmpty());
	}
}
