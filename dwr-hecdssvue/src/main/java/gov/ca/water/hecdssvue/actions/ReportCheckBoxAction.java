package gov.ca.water.hecdssvue.actions;

import gov.ca.water.hecdssvue.DssPluginCore;
import gov.ca.water.hecdssvue.components.RetrieveCheckBoxTsData;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

public class ReportCheckBoxAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JCheckBox c=(JCheckBox)e.getSource();
		String cn=c.getName();
		
		if (c.isSelected()){
			if (!DssPluginCore.selectedCheckBox.contains(cn)){
				DssPluginCore.selectedCheckBox.add(cn);
			}
		}else{
			if (DssPluginCore.selectedCheckBox.contains(cn)){
				DssPluginCore.selectedCheckBox.remove(cn);
			}
		}
		
		new RetrieveCheckBoxTsData();
	}
}
