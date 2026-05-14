package gov.ca.water.wrims.gui.ide.about.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

import com.google.common.flogger.FluentLogger;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;

public final class ImageLoader {
	private static final FluentLogger LOGGER = FluentLogger.forEnclosingClass();
	public static final String SYSTEM_PROPERTY = "gov.ca.water.wrims.image";
	public static final String LOGO_FILE = System.getProperty(SYSTEM_PROPERTY,
			String.format("plugins%1$sorg.eclipse.epp.package.common_4.36.0.20250605-1300%1$sunversioned_splash.bmp",
					File.separator));
	private static ImageLoader instance;
	private Image image;

	private ImageLoader() {
		loadImage();
	}

	public static ImageLoader getInstance() {
		if (instance == null) {
			instance = new ImageLoader();
		}
		return instance;
	}

	public Image getImage() {
		return image;
	}

	private void loadImage() {
		Path logoPath = Path.of(LOGO_FILE).toAbsolutePath();
		LOGGER.atFiner().log("Loading image from: " + logoPath);
		try (InputStream in = new FileInputStream(logoPath.toString())) {
			ImageData data = new ImageData(in);
			LOGGER.atFiner().log("Image data loaded");
			image = new Image(null, data);
		} catch (IOException ex) {
			LOGGER.atFiner().withCause(ex).log("Could not load image");
			image = null;
		}
	}
}
