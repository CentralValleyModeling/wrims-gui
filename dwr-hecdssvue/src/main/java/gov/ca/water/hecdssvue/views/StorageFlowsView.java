package gov.ca.water.hecdssvue.views;

import gov.ca.water.hecdssvue.DssPluginCore;
import gov.ca.water.hecdssvue.actions.ReportButtonAction;
import gov.ca.water.hecdssvue.actions.ReportCheckBoxAction;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.eclipse.swt.widgets.Composite;

public class StorageFlowsView extends AbstractCalSimView{

	public static String ID="views.gov.ca.water.hecdssvue.StorageFlowsView";
	private Component[] components=new Component[0];
	
	public StorageFlowsView(){
	
	}

	
	public void createPartControl(Composite parent){
		super.createPartControl(parent);
		JPanel panel = (JPanel)DssPluginCore.swix.find("presets");
		contentPane.add(new JScrollPane(panel));
		components = panel.getComponents();
		for (int i = 0; i < components.length; i++) {
			if (components[i] instanceof JCheckBox) {
				JCheckBox c = (JCheckBox) components[i];
				c.addActionListener(new ReportCheckBoxAction());
			}else if (components[i] instanceof JButton){
				JButton b = (JButton) components[i];
				b.addActionListener(new ReportButtonAction());
			}
		}
	}

	public void clearAll(){
		for (int i = 0; i < components.length; i++) {
			if (components[i] instanceof JCheckBox) {
				JCheckBox c = (JCheckBox) components[i];
				c.setSelected(false);
			}
		}
	}
}
