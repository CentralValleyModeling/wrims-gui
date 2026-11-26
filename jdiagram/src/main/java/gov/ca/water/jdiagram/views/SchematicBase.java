package gov.ca.water.jdiagram.views;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.util.function.Consumer;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;

import com.mindfusion.diagramming.Diagram;
import com.mindfusion.diagramming.DiagramView;
import gov.ca.water.jdiagram.core.SchematicContext;
import gov.ca.water.jdiagram.host.EclipsePlatformHarness;
import gov.ca.water.jdiagram.host.SchematicHost;
import gov.ca.water.jdiagram.swing.PlatformHarness;
import gov.ca.water.jdiagram.swing.views.SchematicPanel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

/**
 * This view represents the schematic drawing
 * Eclipse view that hosts a jdiagram-swing {@link SchematicPanel} through the SWT_AWT bridge. All schematic behavior
 * (toolbar, value labels, zoom, search, editing) lives in jdiagram-swing/jdiagram-core; this class only supplies the
 * heavyweight container, the WRIMS {@link PlatformHarness}, and the Eclipse selection provider.
 */
public abstract class SchematicBase extends ViewPart {

	private Composite swingContainer;

	private final DiagramSelectionProvider selectionProvider = new DiagramSelectionProvider();

	private volatile SchematicPanel schematic;

	/**
	 * Creates the Swing schematic. Called on the AWT event thread.
	 *
	 * @param context the plugin-wide schematic context
	 * @param harness the host harness for this view
	 */
	protected abstract SchematicPanel createSchematic(SchematicContext context, PlatformHarness harness);

	/**
	 * @return true if this view should drive the Schematic Overview view
	 */
	protected boolean providesOverview() {
		return false;
	}

	@Override
	public void createPartControl(Composite parent) {
		swingContainer = new Composite(parent, SWT.BACKGROUND | SWT.EMBEDDED);
		Frame frame = SWT_AWT.new_Frame(swingContainer);
		getSite().setSelectionProvider(selectionProvider);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(swingContainer, "gov.ca.dwr.calsim.jdiagram.viewer");

		Consumer<gov.ca.water.jdiagram.swing.views.SchematicOverview> overviewTarget =
				providesOverview() ? SchematicBase::showInOverviewView : null;
		EclipsePlatformHarness harness = new EclipsePlatformHarness(SchematicHost.dataSource(), overviewTarget);
		// Resolved here on the SWT thread; the panel fills the toolbar later from the EDT.
		harness.setActionBars(getViewSite().getActionBars());

		// Swing components are built on the EDT; the SWT thread only creates the embedded frame.
		SwingUtilities.invokeLater(() -> {
			Panel heavyweight = new Panel(new BorderLayout());
			JRootPane root = new JRootPane();
			heavyweight.add(root);
			frame.add(heavyweight);

			JPanel content = new JPanel(new BorderLayout());
			root.getContentPane().add(content, BorderLayout.CENTER);

			SchematicPanel panel = createSchematic(SchematicHost.context(), harness);
			harness.setPanel(panel);
			panel.createPartControl(content);
			panel.getSelectionProvider().addSelectionChangedListener(e -> {
				if (!e.isEmpty()) {
					selectionProvider.setSelection(new DiagramItemSelection(e.getFirstElement()));
				}
			});
			schematic = panel;
			frame.validate();
		});
	}

	/** Shows {@code overview} in the Schematic Overview view, if that view is open. Runs on the SWT thread. */
	private static void showInOverviewView(gov.ca.water.jdiagram.swing.views.SchematicOverview overview) {
		SchematicOverview view = SchematicOverview.find();
		if (view != null) {
			view.setOverview(overview);
		}
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	@Override
	public void setFocus() {
		swingContainer.setFocus();
	}

	/**
	 * @return the Swing schematic, or null until it has been created on the EDT
	 */
	public SchematicPanel getSchematic() {
		return schematic;
	}

	/**
	 * @return the diagram, or null until the schematic has been created
	 */
	public Diagram getDiagram() {
		SchematicPanel panel = schematic;
		return panel == null ? null : panel.getDiagram();
	}

	/**
	 * @return the diagram view, or null until the schematic has been created
	 */
	public DiagramView getDiagramView() {
		SchematicPanel panel = schematic;
		return panel == null ? null : panel.getDiagramView();
	}

	/**
	 * Recalculates the value labels. See {@link SchematicPanel#refreshValues(int, boolean)}.
	 */
	public void refreshValues(int index, boolean force) {
		SchematicPanel panel = schematic;
		if (panel != null) {
			SwingUtilities.invokeLater(() -> panel.refreshValues(index, force));
		}
	}
}