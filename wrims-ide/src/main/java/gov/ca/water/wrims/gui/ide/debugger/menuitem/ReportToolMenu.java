package gov.ca.water.wrims.gui.ide.debugger.menuitem;

import gov.ca.water.wrims.gui.ide.debugger.dialog.WPPReportToolDialog;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
public final class ReportToolMenu implements IWorkbenchWindowActionDelegate {

    private IWorkbenchWindow window;
    private WPPReportToolDialog dialog;

    @Override
    public void run(IAction action) {
        if (dialog == null) {
            dialog = new WPPReportToolDialog(window.getShell());
        }
        dialog.openDialog();
    }

    @Override
    public void selectionChanged(IAction action, ISelection selection) {
        //No-op
    }

    @Override
    public void dispose() {
        dialog = null;
        window = null;
    }

    @Override
    public void init(IWorkbenchWindow window) {
        this.window = window;
    }
}
