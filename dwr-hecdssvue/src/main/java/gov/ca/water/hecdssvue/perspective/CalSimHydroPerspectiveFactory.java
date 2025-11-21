package gov.ca.water.hecdssvue.perspective;

import gov.ca.water.hecdssvue.views.DSSCatalogView;
import gov.ca.water.hecdssvue.views.DSSFileView;
import gov.ca.water.hecdssvue.views.DSSMonthlyView;
import gov.ca.water.hecdssvue.views.DSSOpsView;
import gov.ca.water.hecdssvue.views.DSSPlotView;
import gov.ca.water.hecdssvue.views.DSSTableView;
import gov.ca.water.hecdssvue.views.DTSView;
import gov.ca.water.hecdssvue.views.WaterYearView;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import gov.ca.water.wrims.gui.ide.debugger.core.DebugCorePlugin;

public class CalSimHydroPerspectiveFactory implements IPerspectiveFactory {

	private String projectExplorerID="org.eclipse.ui.navigator.ProjectExplorer";
	private String outlineID="org.eclipse.ui.views.ContentOutline";
		
	@Override
	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(false);
		layout.setFixed(true);
		IFolderLayout lf = layout.createFolder("left", IPageLayout.LEFT, 0.2f, editorArea);
		lf.addView(projectExplorerID);
		lf.addView(DebugCorePlugin.ID_WPP_FILEINCEXPLORE_VIEW);
		IFolderLayout lbf = layout.createFolder("leftbottom", IPageLayout.BOTTOM, 0.6f, "left");
		lbf.addView(outlineID);
		IFolderLayout bf = layout.createFolder("bottom", IPageLayout.BOTTOM, 0.7f, editorArea);
		bf.addView(DSSFileView.ID);
		bf.addView(DSSCatalogView.ID);
		bf.addView(DTSView.ID);
		IFolderLayout rf = layout.createFolder("right", IPageLayout.RIGHT, 0.75f, editorArea);
		rf.addView(DebugCorePlugin.ID_WPP_CALSIMHYDRO_VIEW); 
		rf.addView(DSSTableView.ID);
		IFolderLayout tf = layout.createFolder("top", IPageLayout.TOP, 0.7f, editorArea);
		tf.addView(DSSMonthlyView.ID);
		tf.addView(DSSPlotView.ID);
		IFolderLayout mf = layout.createFolder("middle", IPageLayout.BOTTOM, 0.7f, "top");
		mf.addView(DSSOpsView.ID);
		mf.addView(WaterYearView.ID);
	}

}
