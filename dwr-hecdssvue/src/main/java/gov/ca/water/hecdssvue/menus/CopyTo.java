package gov.ca.water.hecdssvue.menus;

import gov.ca.water.hecdssvue.DssPluginCore;
import gov.ca.water.hecdssvue.components.CatalogListSelection;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

public class CopyTo implements IWorkbenchWindowActionDelegate{		
	
	@Override
	public void run(IAction action) {
		final CatalogListSelection ls = new CatalogListSelection();
		ls.setDirectory(DssPluginCore.lastCopiedDssFolder);
		ls.copyRecords(true);
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(IWorkbenchWindow window) {
		// TODO Auto-generated method stub

	}
}
