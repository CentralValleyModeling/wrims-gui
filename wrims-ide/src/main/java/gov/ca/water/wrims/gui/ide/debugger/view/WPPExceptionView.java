package gov.ca.water.wrims.gui.ide.debugger.view;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;

public class WPPExceptionView extends ViewPart implements ISelectionListener{
	private static final Logger LOGGER = Logger.getLogger(WPPExceptionView.class.getName());
	private List list;
	
	public WPPExceptionView(){
		super();
	}
	
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createPartControl(Composite parent) {
		list=new List(parent,1);
	}

	public void addException(Exception e) {
		LOGGER.log(Level.WARNING, "Exception caught", e);
		Throwable current = e;
		boolean first = true;

		while (current != null) {
			String message = current.getMessage();
			String prefix = first ? "" : "\tCaused by:";

			if (message != null) {
				list.add(prefix + message);
			} else {
				list.add(prefix + "Unknown exception: " + current.getClass().getName());
			}

			first = false;
			current = current.getCause();
		}
	}

	@Override
	public void setFocus() {
		// TODO: DWR Review Change
		//This was causing runtime exceptions on load.
		//Tracking under github issue: https://github.com/CentralValleyModeling/wrims/issues/154
		//getSite().getPart().setFocus();
		try
		{
			list.setFocus();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
