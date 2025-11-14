package gov.ca.water.hecdssvue.actions;

import gov.ca.water.hecdssvue.DssPluginCore;
import gov.ca.water.hecdssvue.components.ClearAllCheckBox;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class ReportButtonAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b=(JButton)e.getSource();
		String bn=b.getName();
		
		if (bn.equalsIgnoreCase("btnpClear") || bn.equalsIgnoreCase("btnpClear_SJR") || bn.equalsIgnoreCase("btnpClear_shortage")){
			DssPluginCore.selectedCheckBox=new ArrayList<String>();
			new ClearAllCheckBox();
		}
	}
}
