package gov.ca.dwr.wresl.xtext.editor.ui.watch;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import wrimsv2_plugin.debugger.core.DebugCorePlugin;
import wrimsv2_plugin.debugger.exception.WPPException;
import wrimsv2_plugin.debugger.view.UpdateView;
import wrimsv2_plugin.debugger.view.WPPWatchView;
import wrimsv2_plugin.tools.ProcWatchItem;
import wrimsv2_plugin.tools.ShowDuplicatedWatch;

public class AddWatch extends org.eclipse.core.commands.AbstractHandler {
	
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final String hoverText=DebugCorePlugin.hoverText;
		if (!hoverText.equals("")){
			String varGoalNameLowerCase=hoverText.toLowerCase();
			if (DebugCorePlugin.watchItems.contains(varGoalNameLowerCase)){
				new ShowDuplicatedWatch(varGoalNameLowerCase);
			}else{
				DebugCorePlugin.watchItems.add(varGoalNameLowerCase);
				ProcWatchItem.saveWatchItems(DebugCorePlugin.watchItems);
				if (DebugCorePlugin.target!=null && DebugCorePlugin.target.isSuspended()){
					UpdateView.updateWatchView(DebugCorePlugin.target);
				}else{
					final IWorkbench workbench=PlatformUI.getWorkbench();
					workbench.getDisplay().asyncExec(new Runnable(){
						public void run(){
							WPPWatchView watchView;
							try {
								watchView = (WPPWatchView) workbench.getActiveWorkbenchWindow().getActivePage().showView(DebugCorePlugin.ID_WPP_WATCH_VIEW);
								watchView.addWatched(hoverText);
							} catch (PartInitException e) {
								WPPException.handleException(e);
							}
						}
					});
				}
			}
		}
		return null;
	}

}
