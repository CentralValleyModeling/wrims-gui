package gov.ca.water.jdiagram.views;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.mindfusion.diagramming.DiagramItem;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.views.properties.IPropertySource;

/**
 * JFace selection wrapping a single {@link DiagramItem}, adaptable to {@link IPropertySource} for the Properties view.
 * Formerly nested in SchematicBase.
 */
public final class DiagramItemSelection implements IStructuredSelection, IAdaptable {
	private final DiagramItem item;

	public DiagramItemSelection(DiagramItem item) {
		this.item = item;
	}

	public DiagramItem getItem() {
		return item;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T getAdapter(Class<T> adapter) {
		if (adapter == IPropertySource.class) {
			return (T) new DiagramItemPropertySource(item);
		}
		return null;
	}

	@Override
	public Object getFirstElement() {
		return new DiagramItemPropertySource(item);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Iterator iterator() {
		return Collections.singleton(getFirstElement()).iterator();
	}

	@Override
	public int size() {
		return 1;
	}

	@Override
	public Object[] toArray() {
		return new Object[] { getFirstElement() };
	}

	@Override
	@SuppressWarnings("rawtypes")
	public List toList() {
		return Collections.singletonList(getFirstElement());
	}
}
