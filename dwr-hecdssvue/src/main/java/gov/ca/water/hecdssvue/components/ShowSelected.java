package gov.ca.water.hecdssvue.components;

import com.google.common.flogger.FluentLogger;
import gov.ca.water.hecdssvue.DssPluginCore;
import gov.ca.water.hecdssvue.views.DSSCatalogView;
import gov.ca.water.hecdssvue.views.DSSMonthlyView;
import gov.ca.water.hecdssvue.views.DSSPlotView;
import gov.ca.water.hecdssvue.views.DSSTableView;
import gov.ca.water.wrims.gui.ide.debugger.exception.WPPException;
import hec.io.DataContainer;
import java.util.Iterator;
import java.util.Vector;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

public class ShowSelected {
	private static final FluentLogger logger = FluentLogger.forEnclosingClass();

	public static void showSelected(){
	
		if (DssPluginCore.selectedCheckBox.size()==0){
			try {
				final IWorkbench workbench=PlatformUI.getWorkbench();
				workbench.getDisplay().asyncExec(new Runnable(){
					public void run(){
						try {
							DSSCatalogView catalogView = (DSSCatalogView) workbench.getActiveWorkbenchWindow()
									.getActivePage().findView(DSSCatalogView.ID);
							if (catalogView == null) {
								logger.atFiner().log("Catalog view not found");
								return;
							}
							Iterator iterator = ((IStructuredSelection) catalogView.getViewer().getSelection())
									.iterator();
							Vector<DataContainer> dataVector = new Vector();
							Vector<DataContainer> dataVector_path = new Vector();
							while(iterator.hasNext()){
								String[] parts = (String[]) iterator.next();
								// 	read 1 file
								//	DataContainer data = catalogView.getData(catalogView.getPathname(parts));
								//	if (data == null) {
								//		continue;
								//	}
								//	dataVector.add(data);
								// read multiple files
								dataVector_path = catalogView.getData(parts);
								if (dataVector_path == null) {
									continue;
								}
								dataVector.addAll(dataVector_path);
							}

							DSSPlotView dpv = (DSSPlotView) workbench.getActiveWorkbenchWindow()
									.getActivePage().findView(DSSPlotView.ID);
							dpv.showSelected(dataVector);
					
							DSSTableView dtv = (DSSTableView) workbench.getActiveWorkbenchWindow()
									.getActivePage().findView(DSSTableView.ID);
							dtv.showSelected(dataVector);
			
							DSSMonthlyView mv = (DSSMonthlyView) workbench.getActiveWorkbenchWindow()
									.getActivePage().findView(DSSMonthlyView.ID);
							mv.showSelected(dataVector);
						} catch (Exception e) {
							WPPException.handleException(e);
						}
					}
				});
			} catch (Exception e) {
				logger.atWarning().withCause(e).log("Error displaying DSS data");
				WPPException.handleException(e);
			}
		}else{
			new RetrieveCheckBoxTsData();
		}
	}
}
