package gov.ca.water.jdiagram.views;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Panel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;

import gov.ca.water.jdiagram.swing.views.SchematicPanel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

/**
 * This represents the overview to the schematic being displayed by the SchematicView
 * Eclipse view showing the overview of the schematic displayed by the {@link SchematicView}. It hosts the
 * jdiagram-swing {@link gov.ca.water.jdiagram.swing.views.SchematicOverview} created by that view's
 * {@link SchematicPanel}, so zooming in the schematic updates the same overview component.
 */
public class SchematicOverview extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = SchematicOverview.class.getCanonicalName();

	private Composite swingContainer;

	/** Accessed on the EDT only. */
	private JPanel holder;

	/** Overview received before the part control was built. Accessed on the EDT only. */
	private gov.ca.water.jdiagram.swing.views.SchematicOverview pending;

	@Override
	public void createPartControl(Composite parent) {
		swingContainer = new Composite(parent, SWT.BACKGROUND | SWT.EMBEDDED);
		Frame frame = SWT_AWT.new_Frame(swingContainer);

		// Pick up the overview if the Schematic View already exists; otherwise it is pushed here when created.
		SchematicPanel schematic = null;
		IWorkbenchPage page = activePage();
		if (page != null && page.findView(SchematicView.ID) instanceof SchematicView view) {
			schematic = view.getSchematic();
		}
		final SchematicPanel existing = schematic;

		SwingUtilities.invokeLater(() -> {
			Panel heavyweight = new Panel(new BorderLayout());
			JRootPane root = new JRootPane();
			heavyweight.add(root);
			frame.add(heavyweight);
			holder = new JPanel(new BorderLayout());
			root.getContentPane().add(holder, BorderLayout.CENTER);
			if (pending != null) {
				showOverview(pending);
				pending = null;
			} else if (existing != null && existing.getOverview() != null) {
				showOverview(existing.getOverview());
			}
			frame.validate();
		});
	}

	/**
	 * Displays {@code overview} in this view. May be called from any thread.
	 */
	public void setOverview(gov.ca.water.jdiagram.swing.views.SchematicOverview overview) {
		if (overview != null) {
			SwingUtilities.invokeLater(() -> showOverview(overview));
		}
	}

	private void showOverview(gov.ca.water.jdiagram.swing.views.SchematicOverview overview) {
		if (holder == null) {
			// Part control not built yet; createPartControl shows it once the holder exists.
			pending = overview;
			return;
		}
		holder.removeAll();
		holder.add(overview, BorderLayout.CENTER);
		holder.revalidate();
		holder.repaint();
	}

	/**
	 * @return the open overview view in the active page, or null. Must be called on the SWT thread.
	 */
	static SchematicOverview find() {
		IWorkbenchPage page = activePage();
		if (page == null) {
			return null;
		}
		IViewPart part = page.findView(ID);
		return part instanceof SchematicOverview overview ? overview : null;
	}

	private static IWorkbenchPage activePage() {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		return window == null ? null : window.getActivePage();
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	@Override
	public void setFocus() {
		swingContainer.setFocus();
	}
}