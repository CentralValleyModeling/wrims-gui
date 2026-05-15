package gov.ca.water.wrims.gui.ide.about.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

import com.google.common.flogger.FluentLogger;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;

public final class ImageLoader {
	private static final FluentLogger LOGGER = FluentLogger.forEnclosingClass();
	public static final String SYSTEM_PROPERTY = "gov.ca.water.wrims.image";
	public static String LOGO_FILE;
	private static final String IMAGE_NAME = "unversioned_splash.bmp";
	private static ImageLoader instance;
	private Image image;

	private ImageLoader() {
		loadImage();
	}

	public static ImageLoader getInstance(String imagePluginName) {
		LOGO_FILE = System.getProperty(SYSTEM_PROPERTY,
				String.format("plugins%1$s%2$s%1$s%3$s",
						File.separator, imagePluginName, IMAGE_NAME));
		if (instance == null) {
			instance = new ImageLoader();
		}
		return instance;
	}

	public Image getImage() {
		return image;
	}

	public void dispose() {
		if (image != null && !image.isDisposed()) {
			LOGGER.atFiner().log("Disposing image");
			image.dispose();
		}
	}

	private void loadImage() {
		Path logoPath = Path.of(LOGO_FILE).toAbsolutePath();
		LOGGER.atFiner().log("Loading image from: " + logoPath);
		try (InputStream in = new FileInputStream(logoPath.toString())) {
			ImageData data = new ImageData(in);
			LOGGER.atFiner().log("Image data loaded");
			image = new Image(Display.getCurrent(), data);
		} catch (IOException ex) {
			LOGGER.atFiner().withCause(ex).log("Could not load image");
			image = null;
		}
	}
}
