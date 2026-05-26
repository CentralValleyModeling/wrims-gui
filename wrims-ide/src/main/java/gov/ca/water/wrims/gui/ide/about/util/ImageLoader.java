package gov.ca.water.wrims.gui.ide.about.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

import com.google.common.flogger.FluentLogger;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;

public final class ImageLoader
{
	private static final FluentLogger LOGGER = FluentLogger.forEnclosingClass();
	public static final String SYSTEM_PROPERTY = "gov.ca.water.wrims.image";
	public static String SPLASH_IMAGE_FILE;
	private static final String SPLASH_IMAGE_NAME = "unversioned_splash.bmp";
	private static ImageLoader instance;
	private static ResourceManager resourceManager;
	static final int WIDTH = 452 - 20;
	static final int HEIGHT = 302 - 20;
	private Image image;

	private ImageLoader()
	{
		loadImage();
	}

	public static ImageLoader getInstance(String imagePluginName, ResourceManager manager)
	{
		SPLASH_IMAGE_FILE = System.getProperty(SYSTEM_PROPERTY,
				String.format("plugins%1$s%2$s%1$s%3$s",
						File.separator, imagePluginName, SPLASH_IMAGE_NAME));
		resourceManager = manager;
		if(instance == null)
		{
			instance = new ImageLoader();
		} else {
			// Check if the image is disposed and reload if necessary
			if (instance.image != null && instance.image.isDisposed()) {
				instance.loadImage();
			}
		}
		return instance;
	}

	public Image getImage()
	{
		return image;
	}

	private void loadImage()
	{
		Path logoPath = Path.of(SPLASH_IMAGE_FILE).toAbsolutePath();
		LOGGER.atFiner().log("Loading image from: " + logoPath);
		try(InputStream in = new FileInputStream(logoPath.toString()))
		{
			ImageData data = new ImageData(in);
			ImageData scaledData = data.scaledTo(WIDTH, HEIGHT);
			LOGGER.atFiner().log("Image data loaded");
			ImageDescriptor desc = ImageDescriptor.createFromImageData(scaledData);
			image = resourceManager.create(desc);
		}
		catch(IOException ex)
		{
			LOGGER.atFiner().withCause(ex).log("Could not load image");
			image = null;
		}
	}
}
