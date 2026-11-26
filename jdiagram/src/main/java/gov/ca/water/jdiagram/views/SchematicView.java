package gov.ca.water.jdiagram.views;

import gov.ca.water.jdiagram.core.SchematicContext;
import gov.ca.water.jdiagram.host.WrimsSchematicPanelBase;
import gov.ca.water.jdiagram.swing.PlatformHarness;
import gov.ca.water.jdiagram.swing.views.SchematicPanel;

public class SchematicView extends SchematicBase {
	
	public static final String ID = SchematicView.class.getCanonicalName();

	@Override
	protected SchematicPanel createSchematic(SchematicContext context, PlatformHarness harness) {
		return new SchematicPanel(new WrimsSchematicPanelBase(context), harness);
	}

	@Override
	protected boolean providesOverview() {
		return true;
	}
	
}
