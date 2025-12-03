package gov.ca.water.wrims.gui.ide.debugger.commanditem;

import gov.ca.water.wrims.gui.ide.debugger.core.DebugCorePlugin;
import gov.ca.water.wrims.gui.ide.debugger.dialog.WPPCycleWreslDialog;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

public class CycleWresl extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection ssel = (IStructuredSelection) selection;
		    Object firstEle = ssel.getFirstElement();
		    IFile ifile = (IFile) Platform.getAdapterManager().getAdapter(firstEle,
		    		IFile.class);
		    if (ifile == null) {
		    	DebugCorePlugin.cycleWreslMainFilePath = "";
		    }else{
		    	DebugCorePlugin.cycleWreslMainFilePath = ifile.getRawLocation().toOSString();
		    	
		    	final IWorkbench workbench=PlatformUI.getWorkbench();
				workbench.getDisplay().asyncExec(new Runnable(){
					public void run(){
						Shell shell=workbench.getActiveWorkbenchWindow().getShell();
						WPPCycleWreslDialog dialog= new WPPCycleWreslDialog(shell);
						dialog.openDialog();
					}
				});
		    }
		}else{
			DebugCorePlugin.cycleWreslMainFilePath = "";
		}
		
		return null;
	}
}
