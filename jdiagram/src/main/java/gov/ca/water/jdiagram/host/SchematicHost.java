package gov.ca.water.jdiagram.host;

import gov.ca.water.jdiagram.core.SchematicContext;

public final class SchematicHost {
	private static final WrimsSchematicDataSource DATA_SOURCE = new WrimsSchematicDataSource();
	private static final SchematicContext CONTEXT = new SchematicContext(DATA_SOURCE);

	private SchematicHost() {
		throw new AssertionError("Utility class");
	}

	public static WrimsSchematicDataSource dataSource() {
		return DATA_SOURCE;
	}

	public static SchematicContext context() {
		return CONTEXT;
	}
}
