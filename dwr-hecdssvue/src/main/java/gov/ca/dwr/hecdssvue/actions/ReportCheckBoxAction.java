package gov.ca.dwr.hecdssvue.actions;

import gov.ca.dwr.hecdssvue.DssPluginCore;
import gov.ca.dwr.hecdssvue.components.DataOps;
import gov.ca.dwr.hecdssvue.components.RetrieveCheckBoxTsData;
import gov.ca.dwr.hecdssvue.views.DSSMonthlyView;
import gov.ca.dwr.hecdssvue.views.DSSPlotView;
import gov.ca.dwr.hecdssvue.views.DSSTableView;
import hec.heclib.dss.CondensedReference;
import hec.heclib.dss.HecDss;
import hec.hecmath.HecMath;
import hec.hecmath.HecMathException;
import hec.hecmath.TimeSeriesMath;
import hec.io.DataContainer;
import hec.io.TimeSeriesContainer;

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
