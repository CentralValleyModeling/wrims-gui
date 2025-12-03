package gov.ca.water.jdiagram;

import gov.ca.water.jdiagram.views.SchematicEditorViewA;
import gov.ca.water.jdiagram.views.SchematicEditorViewB;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class SchematicEditorPerspectiveFactory implements IPerspectiveFactory {

	@Override
	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(false);
		layout.setFixed(true);
		layout.addView(SchematicEditorViewA.ID, IPageLayout.LEFT, 0.5f, editorArea);
		layout.addView(SchematicEditorViewB.ID, IPageLayout.RIGHT, 0.5f, editorArea);
	}

}
