package gov.ca.water.wrims.gui.ide.about.util;

import java.io.FileInputStream;
import java.io.InputStream;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.junit.jupiter.api.Test;

import static gov.ca.water.wrims.gui.ide.about.util.ImageLoader.SYSTEM_PROPERTY;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

final class ImageLoaderTest {
	@Test
	void testLoader()
	{
		ResourceManager manager = new LocalResourceManager(JFaceResources.getResources());
		System.setProperty(SYSTEM_PROPERTY, "src/test/resources/TEST_images/AllGoals.png");
		ImageLoader loader = ImageLoader.getInstance("", manager);
		Image image = loader.getImage();
		assertNotNull(image);
		assertEquals(412, image.getImageData().width);
		assertEquals(523, image.getImageData().height);
		assertNotNull(image.getImageData().data, "Image data should not be null");
		System.clearProperty(SYSTEM_PROPERTY);
	}

	@Test
	void testSingleton() {
		System.setProperty(SYSTEM_PROPERTY, "src/test/resources/TEST_images/AllGoals.png");
		ResourceManager manager = new LocalResourceManager(JFaceResources.getResources());
		ImageLoader loader = ImageLoader.getInstance("", manager);
		ImageLoader loader2 = ImageLoader.getInstance("", manager);
		assertEquals(loader, loader2);
		Image image = loader.getImage();
		Image image2 = loader2.getImage();
		assertNotNull(image);
		assertNotNull(image2);
		assertEquals(image, image2);
		System.clearProperty(SYSTEM_PROPERTY);
	}

	@Test
	void testImageEquality() throws Exception
	{
		ResourceManager manager = new LocalResourceManager(JFaceResources.getResources());
		String path = "src/test/resources/TEST_images/AllGoals.png";
		System.setProperty(SYSTEM_PROPERTY, path);
		// Load the image using the loader
		ImageLoader loader = ImageLoader.getInstance("", manager);
		Image image = loader.getImage();
		assertNotNull(image, "Image should not be null");

		Image controlImage;
		try(InputStream in = new FileInputStream(path))
		{
			ImageData data = new ImageData(in);
			controlImage = new Image(null, data);
		}
		System.clearProperty(SYSTEM_PROPERTY);

		assertNotNull(controlImage, "Control image should not be null");

		// Compare image data, as the objects themselves will not be equal
		assertArrayEquals(image.getImageData().data, controlImage.getImageData().data,
				"Loaded image should be equal to control image");
	}
}