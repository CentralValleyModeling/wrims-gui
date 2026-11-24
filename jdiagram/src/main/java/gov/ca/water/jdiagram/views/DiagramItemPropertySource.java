package gov.ca.water.jdiagram.views;

import java.util.Map;

import com.mindfusion.diagramming.DiagramItem;
import gov.ca.water.jdiagram.swing.behavior.DiagramItemProperties;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;

/**
 * Eclipse Properties view adapter over jdiagram-swing's {@link DiagramItemProperties} (label, incoming, outgoing).
 * Formerly nested in SchematicBase.
 */
public class DiagramItemPropertySource implements IPropertySource {
	private final Map<String, String> properties;

	public DiagramItemPropertySource(DiagramItem item) {
		this.properties = new DiagramItemProperties(item).asMap();
	}

	@Override
	public Object getEditableValue() {
		return null;
	}

	@Override
	public IPropertyDescriptor[] getPropertyDescriptors() {
		return properties.keySet().stream()
				.map(id -> new PropertyDescriptor(id, id))
				.toArray(IPropertyDescriptor[]::new);
	}

	@Override
	public Object getPropertyValue(Object id) {
		String value = properties.get(id);
		return value == null ? "" : value;
	}

	@Override
	public boolean isPropertySet(Object id) {
		return DiagramItemProperties.LABEL.equals(id);
	}

	@Override
	public void resetPropertyValue(Object id) {
		// read-only
	}

	@Override
	public void setPropertyValue(Object id, Object value) {
		// read-only
	}
}
