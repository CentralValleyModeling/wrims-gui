package gov.ca.water.jdiagram.dialog;

import gov.ca.water.hecdssvue.DssPluginCore;
import gov.ca.water.jdiagram.views.SchematicBase;
import gov.ca.water.wrims.gui.ide.debugger.core.DebugCorePlugin;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class DecimalDialog extends Dialog {
	
	private static String DECIMAL_PLACES = "decimalPlaces";
	private SchematicBase schematic;

	public DecimalDialog(Shell parent, SchematicBase schematic) {
		super(parent, SWT.MIN);
		this.schematic = schematic;
		setText("Set Decimal Places");
	}
	
	public void openDialog(){
		Shell shell=new Shell(getParent(), getStyle());
		shell.setText(getText());
		createContents(shell);
		shell.setSize(325, 120);
		shell.setLocation(450, 300);
		//shell.pack();
		shell.open();
	}
	
	protected void createContents(final Shell shell) {
		GridLayout layout=new GridLayout();
		layout.numColumns = 14;
		layout.makeColumnsEqualWidth = true;
		layout.marginWidth=20;
		layout.marginHeight=20;
		shell.setLayout(layout);
		
		GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.horizontalSpan=8;
		Label label = new Label(shell, SWT.NULL);
		label.setText("Decimal Places:");
		label.setLayoutData(gd);
		
		final Text decimalText = new Text(shell, SWT.BORDER);
		decimalText.setText(String.valueOf(DssPluginCore._preferences.getInt(DECIMAL_PLACES, 0)));
		GridData gd1 = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		gd1.horizontalSpan=6;
		decimalText.setLayoutData(gd1);
		
		Button ok = new Button(shell, SWT.PUSH);
		GridData gd2 = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd2.horizontalSpan=6;
		ok.setLayoutData(gd2);
		ok.setText("OK");
		ok.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
				final int numberDecimals = Integer.parseInt(decimalText.getText());
				DssPluginCore._preferences.putInt(DECIMAL_PLACES, numberDecimals);
				if (!DebugCorePlugin.isDebugging){
					schematic.refreshValues(0, false);					
				}else{
					if (DebugCorePlugin.target !=null){
						schematic.refreshValues(1, false);
					}
				}
				if (DssPluginCore.mtp !=null){
					DssPluginCore.mtp.setDecimalPlaces(numberDecimals);
				}
				shell.close();
			}
		});
		
		Button cancel = new Button(shell, SWT.PUSH);
		cancel.setLayoutData(gd2);
		cancel.setText("Cancel");
		cancel.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event){
				shell.close();
			}
		});
		
		shell.setDefaultButton(ok);
		shell.pack();
	}

}
