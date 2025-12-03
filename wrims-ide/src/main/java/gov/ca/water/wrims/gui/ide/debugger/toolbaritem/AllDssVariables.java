package gov.ca.water.wrims.gui.ide.debugger.toolbaritem;

import gov.ca.water.wrims.gui.ide.debugger.core.DebugCorePlugin;
import gov.ca.water.wrims.gui.ide.debugger.exception.WPPException;
import gov.ca.water.wrims.gui.ide.debugger.view.WPPAllVariableView;
import gov.ca.water.wrims.gui.ide.tools.DataProcess;
import java.lang.reflect.InvocationTargetException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionDelegate;

public class AllDssVariables extends ActionDelegate implements IViewActionDelegate{

	@Override
	public void init(IViewPart view) {
		// TODO Auto-generated method stub
		
	}

	public void run(IAction action) {
		if (DebugCorePlugin.target!=null && DebugCorePlugin.target.isSuspended()) getAllDssVariables();
	}
	
	public void getAllDssVariables(){
		final IWorkbench workbench=PlatformUI.getWorkbench();
		workbench.getDisplay().asyncExec(new Runnable(){
			public void run(){
				Shell shell=workbench.getActiveWorkbenchWindow().getShell();
				ProgressMonitorDialog dialog = new ProgressMonitorDialog(shell);  
				try {
					dialog.run(true,false, new IRunnableWithProgress() {
						@Override
						public void run(final IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
							String goal="";
							monitor.beginTask("Retrieve data from DSS files", 100);
							
							final IWorkbench workbench=PlatformUI.getWorkbench();
							workbench.getDisplay().asyncExec(new Runnable(){
								public void run(){
									DebugCorePlugin.allVariableProperty=DataProcess.retrieveAllVariableProperty();
									WPPAllVariableView allVariableView = (WPPAllVariableView) workbench.getActiveWorkbenchWindow().getActivePage().findView(DebugCorePlugin.ID_WPP_ALLVARIABLE_VIEW);
									allVariableView.showDssAlt();
									monitor.done();
								}
							});
						}
					});
				} catch (InvocationTargetException e) {
					WPPException.handleException(e);
				} catch (InterruptedException e) {
					WPPException.handleException(e);
				}
			}
		});
	}
}
