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
			= Path.of(String.format("..%1$swrims-install%1$ssrc%1$smain%1$sresources%1$sbranding%1$ssplash.bmp",
					File.pathSeparator)).toAbsolutePath();
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
		try (InputStream in = new FileInputStream(LOGO_PATH.toString())) {
			ImageData data = new ImageData(in);
			image = new Image(null, data);
		} catch (IOException ex) {
			LOGGER.atFiner().log("Could not load image", ex);
			image = null;
		}
	}


}
