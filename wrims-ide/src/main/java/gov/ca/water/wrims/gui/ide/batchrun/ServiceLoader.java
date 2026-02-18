package gov.ca.water.wrims.gui.ide.batchrun;

import java.util.Collection;

import org.openide.util.Lookup;
import org.openide.util.lookup.Lookups;


public class ServiceLoader
{
	private ServiceLoader()
	{
		throw new IllegalStateException("Utility class");
	}

	public static void load(String path, Class<?> clazz)
	{
		//this method is just to trigger the loading of the service providers in this package
		Lookup lookup = Lookups.forPath(path);

		Collection<? extends Object> services = lookup.lookupAll(clazz);
		for (Object service : services) {
			System.out.println(service);
		}
	}
}
