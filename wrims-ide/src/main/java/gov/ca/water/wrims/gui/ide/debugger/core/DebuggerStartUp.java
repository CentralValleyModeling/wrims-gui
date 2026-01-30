package gov.ca.water.wrims.gui.ide.debugger.core;

import gov.ca.water.wrims.gui.ide.calsimhydro.DefaultCalSimHydro;
import gov.ca.water.wrims.gui.ide.debugger.exception.WPPException;
import gov.ca.water.wrims.gui.ide.debugger.listener.WelcomeViewListener;
import gov.ca.water.wrims.gui.ide.debugger.menuitem.EnableMenus;
import gov.ca.water.wrims.gui.ide.tools.DataProcess;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IPerspectiveListener;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.internal.Workbench;

public class DebuggerStartUp implements IStartup {

	@Override
	public void earlyStartup() {
		SettingPref.load();
		SettingPref.loadCBCDefault();
		SettingPref.loadCBCSetting();
		enableRunMenu();
		initialStudyData();
		DataProcess.initialVariableValueAlt();
		addPerspectiveChangeListener();
		new WelcomeViewListener().addWelcomeViewListener();
	}

	public void enableRunMenu(){
		HashMap<String, Boolean> enableMenuMap=new HashMap<String, Boolean>();
		enableMenuMap.put(DebugCorePlugin.ID_WPP_TERMINATEMENU, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_PAUSEMENU, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_SUSPENDMENU, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_RESUMEMENU, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_RESIMMENU, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_NEXTCYCLE, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_NEXTTIMESTEP, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_CONDITIONALBREAKPOINT, true);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_CLEARCONDITIONALBREAKPOINT, true);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_SAVETODVFILE, false);
		enableMenuMap.put(DebugCorePlugin.ID_WPP_SAVETOSVFILE, false);
		new EnableMenus(enableMenuMap);
		/*
		HandlePauseResumeButton.procPauseResumeToolbarItem(0);
		HashMap<String, Boolean> enableButtonMap=new HashMap<String, Boolean>();
		enableButtonMap.put(DebugCorePlugin.ID_WPP_NEXTCYCLEBUTTON, false);
		enableButtonMap.put(DebugCorePlugin.ID_WPP_NEXTTIMESTEPBUTTON, false);
		new EnableButtons(enableButtonMap);
		*/
		showSolverStatus();
	}
	
	public void initialStudyData(){
		Map<String, String>[] studiesData = DebugCorePlugin.studiesData;
		for (int i=0; i<4; i++){
			studiesData[i]=new HashMap<String, String>();
		}
	}
		
	public void showSolverStatus(){
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				String log="";
				if (!DebugCorePlugin.log.equalsIgnoreCase("NONE")){
					log=DebugCorePlugin.log;
				}
				String status=DebugCorePlugin.solver+"  "+log;
				
				IWorkbenchPage page = Workbench.getInstance().getActiveWorkbenchWindow().getActivePage();
				IViewPart console = page.findView( IConsoleConstants.ID_CONSOLE_VIEW ); 
				if (console != null){
					try {
						console=page.showView(IConsoleConstants.ID_CONSOLE_VIEW);
						console.getViewSite().getActionBars().getStatusLineManager().setMessage(status);
					} catch (PartInitException e) {
						WPPException.handleException(e);
					}
				}
			}
		});
	}
	
	public void addPerspectiveChangeListener(){
		Display.getDefault().syncExec(new Runnable() {

			@Override
			public void run() {
				Workbench.getInstance().getActiveWorkbenchWindow().addPerspectiveListener(new IPerspectiveListener() {

					@Override
					public void perspectiveActivated(IWorkbenchPage page,
							IPerspectiveDescriptor perspective) {
						String label=perspective.getLabel();
						if (label.equalsIgnoreCase("IDE")){
							showSolverStatus();
						}
					}

					@Override
					public void perspectiveChanged(IWorkbenchPage page,
							IPerspectiveDescriptor perspective, String changeId) {
						String label=perspective.getLabel();
						if (label.equalsIgnoreCase("CalSimHydro")){
							DefaultCalSimHydro dch = new DefaultCalSimHydro();
							dch.load();
						}
					}
				});
			}
			
		});
		
	}	
}
