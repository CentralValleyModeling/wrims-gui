package gov.ca.water.jdiagram;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mindfusion.diagramming.DiagramView;

/**
 * Applies the MindFusion JDiagram license key. The key is never stored in source control. It is resolved, in order, from:
 * <ol>
 * <li>the {@value #SYSTEM_PROPERTY} system property</li>
 * <li>the {@value #ENVIRONMENT_VARIABLE} environment variable</li>
 * <li>the optional {@value #RESOURCE} bundle resource, which the Gradle build generates when a key is supplied</li>
 * </ol>
 * When no key is found JDiagram runs in its unlicensed (trial) mode and a warning is printed once.
 */
public final class SchematicLicense
{
	public static final String SYSTEM_PROPERTY = "wrims.mindfusion.licenseKey";
	public static final String ENVIRONMENT_VARIABLE = "MINDFUSION_LICENSE_KEY";
	public static final String RESOURCE = "/mindfusion-license.properties";
	public static final String RESOURCE_KEY = "licenseKey";

	private static final Logger LOGGER = Logger.getLogger(SchematicLicense.class.getName());
	private static final AtomicBoolean APPLIED = new AtomicBoolean();

	private SchematicLicense()
	{
		throw new AssertionError("Utility class");
	}

	public static void apply()
	{
		if(!APPLIED.compareAndSet(false, true))
		{
			return;
		}
		Optional<String> key = resolveKey(System.getProperties(), System.getenv(), SchematicLicense.class.getResourceAsStream(RESOURCE));
		if(key.isPresent())
		{
			DiagramView.setLicenseKey(key.get());
		}
		else
		{
			LOGGER.log(Level.WARNING, "No MindFusion JDiagram license key found (set -D{0} or {1}); running unlicensed.",
					new Object[]{SYSTEM_PROPERTY, ENVIRONMENT_VARIABLE});
		}
	}

	static Optional<String> resolveKey(Properties systemProperties, Map<String, String> environment, InputStream resource)
	{
		Optional<String> fromProperty = clean(systemProperties.getProperty(SYSTEM_PROPERTY));
		Optional<String> fromEnvironment = clean(environment.get(ENVIRONMENT_VARIABLE));
		Optional<String> fromResource = readResource(resource);
		return fromProperty.or(() -> fromEnvironment).or(() -> fromResource);
	}

	private static Optional<String> readResource(InputStream resource)
	{
		if(resource == null)
		{
			return Optional.empty();
		}
		try(InputStream in = resource)
		{
			Properties properties = new Properties();
			properties.load(in);
			return clean(properties.getProperty(RESOURCE_KEY));
		}
		catch(IOException e)
		{
			LOGGER.log(Level.WARNING, e, () -> "Unable to read " + RESOURCE);
			return Optional.empty();
		}
	}

	private static Optional<String> clean(String value)
	{
		return Optional.ofNullable(value).map(String::trim).filter(s -> !s.isEmpty());
	}
}
