package gov.ca.water.wrims.gui.ide.perspective;

import gov.ca.water.wrims.gui.ide.perspective.version.VersionView;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public final class VersionPerspectiveFactory implements IPerspectiveFactory
{
	private static final String PROJECT_EXPLORER_ID = "org.eclipse.ui.navigator.ProjectExplorer";
	private static final String CONSOLE_VIEW_ID = "org.eclipse.ui.console.ConsoleView";
	private static final String OUTLINE_ID = "org.eclipse.ui.views.ContentOutline";

	@Override
	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(false);
		layout.setFixed(false);
		// Left side - Project Explorer and Outline
		IFolderLayout leftFolder = layout.createFolder("left", IPageLayout.LEFT, 0.3f, editorArea);
		leftFolder.addView(PROJECT_EXPLORER_ID);
		leftFolder.addView(OUTLINE_ID);

		// Center - Version View
		layout.addView(VersionView.ID, IPageLayout.TOP, 0.7f, editorArea);

		// Bottom - Console
		IFolderLayout bottomFolder = layout.createFolder("bottom", IPageLayout.BOTTOM, 0.7f, editorArea);
		bottomFolder.addView(CONSOLE_VIEW_ID);

		// Add perspective shortcuts for easy navigation
		layout.addPerspectiveShortcut("gov.ca.water.jdiagram.perspective"); // Schematic perspective
		layout.addPerspectiveShortcut("org.eclipse.jdt.ui.JavaPerspective"); // Java perspective

		// Add view shortcuts
		layout.addShowViewShortcut(VersionView.ID);
		layout.addShowViewShortcut(PROJECT_EXPLORER_ID);
		layout.addShowViewShortcut(CONSOLE_VIEW_ID);
		layout.addShowViewShortcut(OUTLINE_ID);
	}
}
