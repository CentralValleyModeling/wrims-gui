package gov.ca.water.hecdssvue.views;

import gov.ca.water.hecdssvue.panel.OpsPanel;
import hec.io.DataContainer;

import java.util.Vector;

import org.eclipse.swt.widgets.Composite;

/**
 * Displays a plot in a view based on selection on DSS Catalog View
 * 
 * @author psandhu
 * 
 */
public class DSSOpsView extends AbstractDSSView {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "views.gov.ca.water.hecdssvue.DSSOpsView";
	private OpsPanel options;

	/**
	 * The constructor.
	 */
	public DSSOpsView() {
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	/**
	 * Show plot for selected 
	 */
	public void showSelected(Vector<DataContainer> dataVector) {

	}
	
	public void createPartControl(Composite parent){
		super.createPartControl(parent);
		options = new OpsPanel();
		contentPane.add(options);
	}
	
	public OpsPanel getOpsPanel(){
		return options;
	}
}