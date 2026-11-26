package gov.ca.water.jdiagram.utils;

import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import gov.ca.water.jdiagram.swing.utils.IconLoad;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

public class EclipseIconLoader implements IconLoad {
	@Override
	public Icon openIcon() {
		return loadSharedIcon(ISharedImages.IMG_OPEN_MARKER);
	}

	@Override
	public Icon saveIcon() {
		return loadSharedIcon(ISharedImages.IMG_ETOOL_SAVEAS_EDIT);
	}

	private static Icon loadSharedIcon(String key) {
		ImageDescriptor desc = PlatformUI.getWorkbench()
				.getSharedImages()
				.getImageDescriptor(key);
		if (desc == null) {
			return null;
		}
		ImageData data = desc.getImageData(100);
		if (data == null) {
			return null;
		}
		return new ImageIcon(toBufferedImage(data));
	}

	/**
	 * Converts SWT ImageData (raw, palette-dependent pixels) into an AWT image.
	 * ImageData.data is NOT an encoded image file, so it cannot be passed to
	 * ImageIcon(byte[]) directly.
	 */
	static BufferedImage toBufferedImage(ImageData data) {
		BufferedImage image = new BufferedImage(data.width, data.height, BufferedImage.TYPE_INT_ARGB);
		PaletteData palette = data.palette;
		int transparencyType = data.getTransparencyType();
		ImageData mask = (transparencyType == SWT.TRANSPARENCY_MASK
				|| transparencyType == SWT.TRANSPARENCY_PIXEL)
				? data.getTransparencyMask()
				: null;

		for (int y = 0; y < data.height; y++) {
			for (int x = 0; x < data.width; x++) {
				RGB rgb = palette.getRGB(data.getPixel(x, y));
				int alpha;
				if (transparencyType == SWT.TRANSPARENCY_ALPHA) {
					alpha = data.getAlpha(x, y);
				} else if (mask != null) {
					alpha = mask.getPixel(x, y) == 0 ? 0 : 255;
				} else {
					alpha = 255;
				}
				int argb = (alpha << 24) | (rgb.red << 16) | (rgb.green << 8) | rgb.blue;
				image.setRGB(x, y, argb);
			}
		}
		return image;
	}
}
