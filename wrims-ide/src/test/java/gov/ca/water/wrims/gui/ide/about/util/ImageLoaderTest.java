package gov.ca.water.wrims.gui.ide.about.util;

import java.io.FileInputStream;
import java.io.InputStream;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static gov.ca.water.wrims.gui.ide.about.util.ImageLoader.SYSTEM_PROPERTY;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

final class ImageLoaderTest {
	private static final String IMAGE_PATH = "src/test/resources/TEST_images/AllGoals.png";
	private ResourceManager resourceManager;
	private Display display;

	@BeforeEach
	void setUp() {
		// Initialize SWT Display for testing
		if (Display.getCurrent() == null) {
			display = new Display();
		} else {
			display = Display.getCurrent();
		}
		resourceManager = new LocalResourceManager(JFaceResources.getResources());
	}

	@Test
	void testLoader() {
		System.setProperty(SYSTEM_PROPERTY, IMAGE_PATH);
		ImageLoader loader = ImageLoader.getInstance("", resourceManager);
		Image image = loader.getImage();
		assertNotNull(image);
		assertEquals(ImageLoader.WIDTH, image.getImageData().width);
		assertEquals(ImageLoader.HEIGHT, image.getImageData().height);
		assertNotNull(image.getImageData().data, "Image data should not be null");
		System.clearProperty(SYSTEM_PROPERTY);
	}

	@Test
	void testSingleton() {
		System.setProperty(SYSTEM_PROPERTY, IMAGE_PATH);
		ImageLoader loader = ImageLoader.getInstance("", resourceManager);
		ImageLoader loader2 = ImageLoader.getInstance("", resourceManager);
		assertEquals(loader, loader2);
		Image image = loader.getImage();
		Image image2 = loader2.getImage();
		assertNotNull(image);
		assertNotNull(image2);
		assertEquals(image, image2);
		System.clearProperty(SYSTEM_PROPERTY);
	}

	@Test
	void testImageEquality() {
		System.setProperty(SYSTEM_PROPERTY, IMAGE_PATH);
		// Load the image using the loader
		ImageLoader loader = ImageLoader.getInstance("", resourceManager);
		Image image = loader.getImage();
		assertNotNull(image, "Image should not be null");

		Image controlImage = createTestImage();
		System.clearProperty(SYSTEM_PROPERTY);

		assertNotNull(controlImage, "Control image should not be null");

		// Compare image data, as the objects themselves will not be equal
		assertArrayEquals(image.getImageData().data, controlImage.getImageData().data,
				"Loaded image should be equal to control image");
	}

	ImageData createTestImageData() {
		try(InputStream in = new FileInputStream(IMAGE_PATH)) {
			return new ImageData(in).scaledTo(ImageLoader.WIDTH, ImageLoader.HEIGHT);
		} catch(Exception ex) {
			throw new RuntimeException("Failed to create test image data", ex);
		}
	}

	Image createTestImage() {
		return new Image(null, createTestImageData());
	}
}