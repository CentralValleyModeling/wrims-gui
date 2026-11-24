package gov.ca.water.jdiagram.views;

import gov.ca.water.jdiagram.core.SchematicContext;
import gov.ca.water.jdiagram.core.SchematicPanelBase;
import gov.ca.water.jdiagram.swing.PlatformHarness;
import gov.ca.water.jdiagram.swing.views.SchematicEditor;
import gov.ca.water.jdiagram.swing.views.SchematicPanel;

public class SchematicEditorViewB extends SchematicBase {

	public static final String ID = SchematicEditorViewB.class.getCanonicalName();

	@Override
	protected SchematicPanel createSchematic(SchematicContext context, PlatformHarness harness) {
		return new SchematicEditor(new SchematicPanelBase(context), harness);
	}
	
}
