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
	public static final Path LOGO_PATH
			= Path.of(String.format("plugins%1$sorg.eclipse.epp.package.common_4.36.0.20250605-1300%1$sunversioned_splash.bmp",
					File.separator)).toAbsolutePath();
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
		LOGGER.atFiner().log("Loading image from: " + LOGO_PATH);
		try (InputStream in = new FileInputStream(LOGO_PATH.toString())) {
			ImageData data = new ImageData(in);
			LOGGER.atFiner().log("Image data loaded");
			image = new Image(null, data);
		} catch (IOException ex) {
			LOGGER.atFiner().withCause(ex).log("Could not load image");
			image = null;
		}
	}


}
