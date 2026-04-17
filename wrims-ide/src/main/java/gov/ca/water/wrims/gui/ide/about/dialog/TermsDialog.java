package gov.ca.water.wrims.gui.ide.about.dialog;

import gov.ca.water.wrims.gui.ide.about.util.TermsAndConditionsInfo;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public final class TermsDialog extends Dialog {
	private final String terms;

	public TermsDialog(Shell parentShell) {
		super(parentShell);
		TermsAndConditionsInfo loader = TermsAndConditionsInfo.getInstance();
		this.terms = loader.getTermsAndConditions();
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("WRIMS Terms and Conditions");
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);

		Text text = new Text(container, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
		text.setText(terms);

		return container;
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
	}
}
