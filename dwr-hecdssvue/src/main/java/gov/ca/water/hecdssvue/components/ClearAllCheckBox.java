package gov.ca.water.hecdssvue.components;

import gov.ca.water.hecdssvue.views.DeliveryShortagesView;
import gov.ca.water.hecdssvue.views.SanJoaquinRiverView;
import gov.ca.water.hecdssvue.views.StorageFlowsView;
import gov.ca.water.hecdssvue.views.WaterManagementActionsView;

import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import wrims.gui.ide.debugger.exception.WPPException;

public class ClearAllCheckBox {

	public ClearAllCheckBox(){
		try {
			final IWorkbench workbench=PlatformUI.getWorkbench();
			workbench.getDisplay().asyncExec(new Runnable(){
				public void run(){
					IWorkbenchPage workBenchPage = workbench.getActiveWorkbenchWindow().getActivePage();
					StorageFlowsView storageFlowsView = (StorageFlowsView) workBenchPage.findView(StorageFlowsView.ID);
					if (storageFlowsView != null) storageFlowsView.clearAll();
					SanJoaquinRiverView sanJoaquinRiverView = (SanJoaquinRiverView)workBenchPage.findView(SanJoaquinRiverView.ID);
					if (sanJoaquinRiverView != null) sanJoaquinRiverView.clearAll();
					WaterManagementActionsView waterManagementActionsView = (WaterManagementActionsView)workBenchPage.findView(WaterManagementActionsView.ID);
					if (waterManagementActionsView !=null) waterManagementActionsView.clearAll();
					DeliveryShortagesView deliveryShortagesView = (DeliveryShortagesView)workBenchPage.findView(DeliveryShortagesView.ID);
					if (deliveryShortagesView !=null) deliveryShortagesView.clearAll();
				}
			});
		} catch (Exception e) {
			WPPException.handleException(e);
		}
	}
}
