package gov.ca.water.jdiagram.host;

import java.io.File;
import java.util.List;
import java.util.Vector;
import java.util.function.Consumer;
import java.util.prefs.Preferences;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.google.common.flogger.FluentLogger;
import com.mindfusion.diagramming.DiagramItem;
import com.mindfusion.diagramming.DiagramView;
import com.mindfusion.diagramming.InplaceEditable;
import gov.ca.water.hecdssvue.DssPluginCore;
import gov.ca.water.hecdssvue.views.DSSCatalogView;
import gov.ca.water.hecdssvue.views.DSSMonthlyView;
import gov.ca.water.hecdssvue.views.DSSPlotView;
import gov.ca.water.hecdssvue.views.DSSTableView;
import gov.ca.water.jdiagram.core.SchematicDataSource;
import gov.ca.water.jdiagram.swing.PlatformHarness;
import gov.ca.water.jdiagram.swing.toolbars.ToolBarContributor;
import gov.ca.water.jdiagram.swing.views.SchematicOverview;
import gov.ca.water.jdiagram.swing.views.SchematicPanel;
import gov.ca.water.jdiagram.swing.utils.IconLoad;
import gov.ca.water.jdiagram.utils.EclipseIconLoader;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;

import hec.hecmath.HecMath;
import hec.hecmath.HecMathException;
import hec.io.DataContainer;

/**
 * {@link PlatformHarness} for the Eclipse (WRIMS GUI) host. One instance per schematic view part.
 * <p>
 * The Swing schematic runs on the AWT event thread inside an SWT_AWT bridge. Swing dialogs (decimal places, PDF
 * options, time windows, font chooser) therefore keep the default {@link PlatformHarness#launchDialog(Runnable)},
 * which runs them on the EDT; only workbench calls are marshalled to the SWT display thread.
 */
public final class EclipsePlatformHarness implements PlatformHarness {
	private static final FluentLogger logger = FluentLogger.forEnclosingClass();
	private static final String SCHEMATICS_DIRECTORY = "SCHEMATICS_DIRECTORY";

	private final SchematicDataSource dataSource;
	private final Consumer<SchematicOverview> overviewConsumer;
	private SchematicPanel panel;
	private volatile IActionBars actionBars;

	/**
	 * @param dataSource source of schematic series, used to open the DSS views
	 * @param overviewConsumer receives the schematic's overview once created, on the SWT thread (e.g. to show it in
	 * the Schematic Overview view); may be null
	 */
	public EclipsePlatformHarness(SchematicDataSource dataSource, Consumer<SchematicOverview> overviewConsumer) {
		this.dataSource = dataSource;
		this.overviewConsumer = overviewConsumer;
	}

	/**
	 * Associates the harness with the panel it serves, so DSS requests can resolve the clicked variable.
	 */
	public void setPanel(SchematicPanel panel) {
		this.panel = panel;
	}

	@Override
	public JPanel mtp() {
		return DssPluginCore.mtp;
	}

	@Override
	public void setMtpDecimalPlaces(int numberDecimals) {
		if (DssPluginCore.mtp != null) {
			DssPluginCore.mtp.setDecimalPlaces(numberDecimals);
		}
	}

	/**
	 * Shows the double-clicked variable in the DSS monthly, plot and table views.
	 * <p>
	 * {@link PlatformHarness#showDssView()} does not say which variable was double-clicked, so it is taken from the
	 * panel's selection: the first click of a double click selects the node or link.
	 */
	@Override
	public void showDssView() {
		String name = selectedName();
		if (name == null) {
			return;
		}
		final Vector<DataContainer> data = new Vector<>();
		for (int i = 0; i < 4; i++) {
			HecMath series = dataSource.getSchematicVariableData(i).get(name);
			if (series != null) {
				try {
					data.add(series.getData());
				} catch (HecMathException e) {
					logger.atFine().withCause(e).log("Error getting data for variable %s", name);
				}
			}
		}
		if (data.isEmpty()) {
			return;
		}
		final IWorkbench workbench = PlatformUI.getWorkbench();
		workbench.getDisplay().asyncExec(() -> {
			IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
			IWorkbenchPage activePage = window == null ? null : window.getActivePage();
			if (activePage == null) {
				return;
			}
			try {
				DSSMonthlyView dmv = (DSSMonthlyView) activePage.showView(DSSMonthlyView.ID);
				dmv.showSelected(data);
				DSSPlotView dpv = (DSSPlotView) activePage.showView(DSSPlotView.ID);
				DSSTableView dtv = (DSSTableView) activePage.showView(DSSTableView.ID);
				SwingUtilities.invokeLater(() -> {
					dpv.showSelected(data);
					dtv.showSelected(data);
				});
			} catch (PartInitException e) {
				logger.atWarning().withCause(e).log("Unable to open DSS views");
			}
		});
	}

	/**
	 * Opens the DSS perspective and selects the currently selected schematic variable in the DSS catalog.
	 */
	@Override
	public void showDSSPerspective() {
		final String name = selectedName();
		final String perspectiveId = DssPluginCore.dssPerspectiveID;
		if (perspectiveId == null) {
			return;
		}
		final IWorkbench workbench = PlatformUI.getWorkbench();
		workbench.getDisplay().asyncExec(() -> {
			try {
				IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
				workbench.showPerspective(perspectiveId, window);
				if (name == null) {
					return;
				}
				DSSCatalogView dcv = (DSSCatalogView) workbench.getActiveWorkbenchWindow().getActivePage().findView(DSSCatalogView.ID);
				if (dcv == null) {
					return;
				}
				Table table = dcv.getViewer().getTable();
				for (int i = 0; i < table.getItemCount(); i++) {
					TableItem ti = table.getItem(i);
					if (ti.getText(1).equalsIgnoreCase(name)) {
						table.setSelection(i);
						table.showItem(ti);
					}
				}
				ISelectionProvider selProvider = dcv.getSite().getSelectionProvider();
				selProvider.setSelection(selProvider.getSelection());
			} catch (WorkbenchException e) {
				logger.atWarning().withCause(e).log("Unable to open DSS perspective %s", perspectiveId);
			}
		});
	}

	/**
	 * No-op: SchematicPanel shows its own Swing font chooser after this call. The legacy SWT FontDialog is no longer
	 * used, which avoids a blocking hop from the AWT thread to the SWT thread.
	 */
	@Override
	public void launchFontDialog() {
		// The Swing FontChooser opened by SchematicPanel handles font selection.
	}

	/**
	 * Uses a Swing chooser on the EDT (the caller's thread) rather than an SWT FileDialog: getting a result back from
	 * the SWT thread would need {@code Display.syncExec} from the AWT thread, which can deadlock the SWT_AWT bridge.
	 */
	@Override
	public String launchFileDialog() {
		Preferences prefs = Preferences.userNodeForPackage(EclipsePlatformHarness.class);
		JFileChooser chooser = new JFileChooser(prefs.get(SCHEMATICS_DIRECTORY, System.getProperty("user.dir")));
		chooser.setDialogTitle("Schematic file");
		FileNameExtensionFilter schematics = new FileNameExtensionFilter("Schematic (*.xml, *.cht)", "xml", "cht");
		chooser.addChoosableFileFilter(schematics);
		chooser.addChoosableFileFilter(new FileNameExtensionFilter("PDF (*.pdf)", "pdf"));
		chooser.addChoosableFileFilter(new FileNameExtensionFilter("SVG (*.svg)", "svg"));
		chooser.setFileFilter(schematics);
		int result = chooser.showDialog(panel == null ? null : panel.getContentPane(), "Select");
		File file = chooser.getSelectedFile();
		if (result != JFileChooser.APPROVE_OPTION || file == null) {
			return null;
		}
		if (file.getParent() != null) {
			prefs.put(SCHEMATICS_DIRECTORY, file.getParent());
		}
		return file.getAbsolutePath();
	}

	@Override
	public void launchViewPart(SchematicOverview overview, DiagramView view, JPanel container) {
		if (overviewConsumer == null) {
			return;
		}
		PlatformUI.getWorkbench().getDisplay().asyncExec(() -> overviewConsumer.accept(overview));
	}

	/**
	 * Sets the action bars of the part hosting the schematic. Call from the SWT thread (e.g. in
	 * {@code createPartControl}) before the panel fills its toolbar.
	 */
	public void setActionBars(IActionBars actionBars) {
		this.actionBars = actionBars;
	}

	@Override
	public Consumer<Action> getToolBarConsumer() {
		ToolBarContributor contributor = getToolBarContributor();
		return a -> {
			contributor.addAction(a);
			contributor.update();
		};
	}

	@Override
	public ToolBarContributor getToolBarContributor() {
		IActionBars bars = actionBars != null ? actionBars : activePartActionBars();
		if (bars == null) {
			logger.atFine().log("No action bars found for schematic part");
			return new ToolBarContributor() {
				@Override
				public void addAction(Action action) {
					// nowhere to add it
				}

				@Override
				public void addComponent(String id, JComponent component) {
					// nowhere to add it
				}
			};
		}
		return new EclipseToolBarContributor(bars.getToolBarManager(), PlatformUI.getWorkbench().getDisplay(),
				bars::updateActionBars);
	}

	/**
	 * Fallback when {@link #setActionBars} was not called. Only works on the SWT thread: elsewhere the workbench
	 * reports no active window.
	 */
	private static IActionBars activePartActionBars() {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IWorkbenchPage page = window == null ? null : window.getActivePage();
		IWorkbenchPart part = page == null ? null : page.getActivePart();
		if (part instanceof IViewPart view) {
			return view.getViewSite().getActionBars();
		} else if (part instanceof IEditorPart editor) {
			return editor.getEditorSite().getActionBars();
		}
		return null;
	}

	/**
	 * @return the lower-case variable name of the selected node or link, or null
	 */
	private String selectedName() {
		if (panel == null) {
			return null;
		}
		List<DiagramItem> selection = panel.getSelectionProvider().getSelection();
		if (selection.isEmpty() || !(selection.getFirst() instanceof InplaceEditable editable)) {
			return null;
		}
		String text = editable.getTextToEdit();
		return text == null ? null : text.toLowerCase();
	}

	@Override
	public IconLoad getIconLoader() {
		return new EclipseIconLoader();
	}
}
