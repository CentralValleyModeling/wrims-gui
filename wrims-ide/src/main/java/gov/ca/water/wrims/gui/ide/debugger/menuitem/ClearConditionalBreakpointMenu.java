package gov.ca.water.wrims.gui.ide.debugger.menuitem;

import gov.ca.water.wrims.gui.ide.debugger.core.DebugCorePlugin;
import gov.ca.water.wrims.gui.ide.debugger.exception.WPPException;
import org.eclipse.debug.core.DebugException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

public class ClearConditionalBreakpointMenu implements IWorkbenchWindowActionDelegate {
	public ClearConditionalBreakpointMenu(){

	}

	@Override
	public void run(IAction action) {
		DebugCorePlugin.conditionalBreakpoint="";
		clearConditionalBreakpoint();
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(IWorkbenchWindow window) {
		// TODO Auto-generated method stub
		
	}
	
	public void clearConditionalBreakpoint(){
		if (DebugCorePlugin.isDebugging){
			try {
				DebugCorePlugin.target.sendRequest("conditional_breakpoint:");
			} catch (DebugException e) {
				WPPException.handleException(e);
			}
		}
	}
}
