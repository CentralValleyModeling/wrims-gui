package gov.ca.water.jdiagram.utils;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.SwingUtilities;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.widgets.Display;

/**
 * Converts Swing {@link Action}s into JFace {@link org.eclipse.jface.action.Action}s so that Swing toolbar actions
 * (e.g. those jdiagram-swing adds to {@code PlatformHarness.getToolBar()}) can be contributed to an Eclipse
 * {@code IToolBarManager}.
 */
public final class SwingActions {
	private SwingActions() {
		throw new AssertionError("Utility class");
	}

	/**
	 * Creates a JFace action that mirrors {@code swingAction}.
	 * <ul>
	 * <li>Text, tooltip and icon are copied from {@link Action#NAME}, {@link Action#SHORT_DESCRIPTION} and
	 * {@link Action#SMALL_ICON} (falling back to {@link Action#LARGE_ICON_KEY}).</li>
	 * <li>An action with a {@link Action#SELECTED_KEY} value becomes a check-box action.</li>
	 * <li>Running the JFace action invokes {@link Action#actionPerformed} on the AWT event thread.</li>
	 * <li>Later changes to the Swing action's name, tooltip, icon, enabled or selected state are applied to the JFace
	 * action on the SWT thread. The listener stays registered for the Swing action's lifetime.</li>
	 * </ul>
	 *
	 * @param swingAction the Swing action to wrap
	 * @param display the display whose thread owns the JFace action
	 * @return the JFace action
	 */
	public static IAction toEclipseAction(Action swingAction, Display display) {
		boolean toggle = swingAction.getValue(Action.SELECTED_KEY) instanceof Boolean;
		int style = toggle ? IAction.AS_CHECK_BOX : IAction.AS_PUSH_BUTTON;

		org.eclipse.jface.action.Action eclipseAction = new org.eclipse.jface.action.Action(null, style) {
			@Override
			public void run() {
				String command = (String) swingAction.getValue(Action.ACTION_COMMAND_KEY);
				if (command == null) {
					command = (String) swingAction.getValue(Action.NAME);
				}
				ActionEvent event = new ActionEvent(swingAction, ActionEvent.ACTION_PERFORMED, command);
				SwingUtilities.invokeLater(() -> {
					if (swingAction.isEnabled()) {
						swingAction.actionPerformed(event);
					}
				});
			}
		};

		copyState(swingAction, eclipseAction);

		PropertyChangeListener listener = evt -> {
			if (!display.isDisposed()) {
				display.asyncExec(() -> copyState(swingAction, eclipseAction));
			}
		};
		swingAction.addPropertyChangeListener(listener);
		return eclipseAction;
	}

	private static void copyState(Action swingAction, IAction eclipseAction) {
		Object name = swingAction.getValue(Action.NAME);
		Object tooltip = swingAction.getValue(Action.SHORT_DESCRIPTION);
		eclipseAction.setText(name == null ? "" : name.toString());
		eclipseAction.setToolTipText(tooltip != null ? tooltip.toString() : name == null ? null : name.toString());
		eclipseAction.setEnabled(swingAction.isEnabled());

		Object icon = swingAction.getValue(Action.SMALL_ICON);
		if (!(icon instanceof Icon)) {
			icon = swingAction.getValue(Action.LARGE_ICON_KEY);
		}
		eclipseAction.setImageDescriptor(icon instanceof Icon i ? toImageDescriptor(i) : null);

		if (eclipseAction.getStyle() == IAction.AS_CHECK_BOX) {
			eclipseAction.setChecked(Boolean.TRUE.equals(swingAction.getValue(Action.SELECTED_KEY)));
		}
	}

	/**
	 * Renders a Swing icon into an SWT image descriptor, preserving per-pixel alpha.
	 *
	 * @return the descriptor, or null if the icon has no size
	 */
	public static ImageDescriptor toImageDescriptor(Icon icon) {
		int width = icon.getIconWidth();
		int height = icon.getIconHeight();
		if (width <= 0 || height <= 0) {
			return null;
		}
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = image.createGraphics();
		try {
			icon.paintIcon(null, g, 0, 0);
		} finally {
			g.dispose();
		}

		ImageData data = new ImageData(width, height, 24, new PaletteData(0xFF0000, 0x00FF00, 0x0000FF));
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int argb = image.getRGB(x, y);
				data.setPixel(x, y, argb & 0xFFFFFF);
				data.setAlpha(x, y, (argb >>> 24) & 0xFF);
			}
		}
		return ImageDescriptor.createFromImageDataProvider(zoom -> zoom == 100 ? data : null);
	}
}
