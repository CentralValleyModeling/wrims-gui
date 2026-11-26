package gov.ca.water.jdiagram.host;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Panel;
import java.util.Objects;
import javax.swing.Action;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;

import gov.ca.water.jdiagram.swing.toolbars.ToolBarContributor;
import gov.ca.water.jdiagram.utils.SwingActions;
import org.eclipse.jface.action.ControlContribution;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

/**
 * {@link ToolBarContributor} for an Eclipse {@link IToolBarManager}.
 * <ul>
 * <li>Swing actions are wrapped with {@link SwingActions#toEclipseAction}.</li>
 * <li>Swing controls are embedded in the toolbar through a {@link ControlContribution} holding an SWT_AWT frame.</li>
 * </ul>
 * Methods are called on the AWT event thread; all toolbar changes are posted to the SWT thread in call order.
 */
public final class EclipseToolBarContributor implements ToolBarContributor {
	private final IToolBarManager manager;
	private final Display display;
	private final Runnable afterUpdate;

	/**
	 * @param manager the toolbar to fill
	 * @param display the display that owns {@code manager}
	 * @param afterUpdate run on the SWT thread after {@link #update()} (e.g. {@code IActionBars::updateActionBars});
	 * may be null
	 */
	public EclipseToolBarContributor(IToolBarManager manager, Display display, Runnable afterUpdate) {
		this.manager = Objects.requireNonNull(manager, "manager");
		this.display = Objects.requireNonNull(display, "display");
		this.afterUpdate = afterUpdate;
	}

	@Override
	public void addAction(Action action) {
		runOnSwt(() -> manager.add(SwingActions.toEclipseAction(action, display)));
	}

	@Override
	public void addComponent(String id, JComponent component) {
		if (component.getName() == null) {
			component.setName(id);
		}
		// The embedded frame is only as big as the toolbar item, so combo lists must open in their own window.
		disableLightweightPopups(component);
		// Read the size here, on the EDT, rather than from the SWT thread.
		Dimension preferred = component.getPreferredSize();
		runOnSwt(() -> manager.add(new SwingControlContribution(id, component, preferred.width)));
	}

	@Override
	public void update() {
		runOnSwt(() -> {
			manager.update(true);
			if (afterUpdate != null) {
				afterUpdate.run();
			}
		});
	}

	private void runOnSwt(Runnable task) {
		if (display.isDisposed()) {
			return;
		}
		if (display.getThread() == Thread.currentThread()) {
			task.run();
		} else {
			// asyncExec, not syncExec: blocking the EDT on the SWT thread can deadlock the SWT_AWT bridge.
			display.asyncExec(task);
		}
	}

	private static void disableLightweightPopups(Component component) {
		if (component instanceof JComboBox<?> combo) {
			combo.setLightWeightPopupEnabled(false);
		}
		if (component instanceof Container container) {
			for (Component child : container.getComponents()) {
				disableLightweightPopups(child);
			}
		}
	}

	/**
	 * Toolbar item that hosts a Swing component in an SWT_AWT frame.
	 */
	private static final class SwingControlContribution extends ControlContribution
	{
		private final JComponent component;
		private final int width;

		SwingControlContribution(String id, JComponent component, int width) {
			super(id);
			this.component = component;
			this.width = width;
		}

		@Override
		protected Control createControl(Composite parent) {
			Composite embedded = new Composite(parent, SWT.EMBEDDED | SWT.NO_BACKGROUND);
			Frame frame = SWT_AWT.new_Frame(embedded);
			SwingUtilities.invokeLater(() -> {
				// Same heavyweight Panel + JRootPane pattern as SchematicBase, so Swing repaints correctly.
				Panel heavyweight = new Panel(new BorderLayout());
				JRootPane root = new JRootPane();
				heavyweight.add(root);
				root.getContentPane().add(component, BorderLayout.CENTER);
				frame.add(heavyweight);
				frame.validate();
			});
			return embedded;
		}

		@Override
		protected int computeWidth(Control control) {
			return width;
		}
	}
}
