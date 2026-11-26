package gov.ca.water.jdiagram.host;

import java.util.AbstractSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.prefs.Preferences;

import gov.ca.water.hecdssvue.DssPluginCore;
import gov.ca.water.jdiagram.core.SchematicDataSource;
import gov.ca.water.wrims.gui.ide.debugger.core.DebugCorePlugin;
import gov.ca.water.wrims.gui.ide.debugger.exception.WPPException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import hec.hecmath.HecMath;

/**
 * {@link SchematicDataSource} backed by the WRIMS IDE ({@link DebugCorePlugin}) and DSS Vue ({@link DssPluginCore})
 * plugin state. This is the adapter between the shared statics the legacy plugin used directly and the
 * host-neutral interfaces in jdiagram-core.
 */
public final class WrimsSchematicDataSource implements SchematicDataSource
{
	/** Time window file name, relative to {@link DebugCorePlugin#dataDir}. Formerly SchematicPluginCore.twFile. */
	public static final String TW_FILE = "twSchematic.prf";

	/** Shape library output path. Formerly hard-coded in the legacy SchematicEditor.addToShapeLibrary(). */
	public static final String SHAPE_LIB_PATH = "d:/temp/shapes.xml";

	private static final int STUDY_COUNT = 4;

	@Override
	public boolean isDebugging() {
		return DebugCorePlugin.isDebugging;
	}

	@Override
	public String getDataDir() {
		return DebugCorePlugin.dataDir;
	}

	/**
	 * Live, read-only view of {@link DssPluginCore#allStorageNames}. It is queried once per variable while values are
	 * calculated, so it delegates rather than copying the list on every call.
	 */
	@Override
	public Set<String> storageNames() {
		return new AbstractSet<>() {
			private List<String> names() {
				List<String> names = DssPluginCore.allStorageNames;
				return names == null ? Collections.emptyList() : names;
			}

			@Override
			public boolean contains(Object o) {
				return names().contains(o);
			}

			@Override
			public Iterator<String> iterator() {
				return Collections.unmodifiableList(names()).iterator();
			}

			@Override
			public int size() {
				return names().size();
			}
		};
	}

	@Override
	public Optional<HecMath> series(int alt, String name) {
		return name == null ? Optional.empty() : Optional.ofNullable(getSchematicVariableData(alt).get(name.toLowerCase()));
	}

	@Override
	public Object target() {
		return DebugCorePlugin.target;
	}

	@Override
	public String shapeLibPath() {
		return SHAPE_LIB_PATH;
	}

	@Override
	public Preferences getPreferences() {
		return DssPluginCore._preferences;
	}

	@Override
	public void setPreferences(Preferences preferences) {
		DssPluginCore._preferences = preferences;
	}

	/**
	 * @return the data loaded for study {@code index} (see {@link WrimsSchematicPanelBase#loadAllSchematicVariableData()}),
	 * or an empty map if nothing has been loaded for it yet. Never null.
	 */
	@Override
	public Map<String, HecMath> getSchematicVariableData(int index) {
		Map<String, HecMath>[] all = DssPluginCore.allSchematicVariableData;
		if (all == null || index < 0 || index >= Math.min(all.length, STUDY_COUNT) || all[index] == null) {
			return Collections.emptyMap();
		}
		return all[index];
	}

	@Override
	public String getTwFile() {
		return TW_FILE;
	}

	@Override
	public void reportError(Throwable t) {
		WPPException.handleException(t instanceof Exception e ? e : new Exception(t));
	}

	@Override
	public void showWarning(String message) {
		Display display = PlatformUI.getWorkbench().getDisplay();
		display.asyncExec(() -> {
			IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			Shell shell = window == null ? display.getActiveShell() : window.getShell();
			MessageBox messageBox = new MessageBox(shell, SWT.ICON_WARNING | SWT.OK);
			messageBox.setText("Warning");
			messageBox.setMessage(message);
			messageBox.open();
		});
	}
}
