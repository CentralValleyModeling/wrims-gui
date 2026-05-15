package gov.ca.water.wrims.gui.ide.about.handler;

import gov.ca.water.wrims.gui.ide.about.dialog.AboutDialog;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

public final class AboutHandler extends AbstractHandler
{
	private AboutDialog dialog;

	@Override
	public Object execute(ExecutionEvent event)
	{
		int returnCode = SWT.ERROR;
		Shell shell = HandlerUtil.getActiveShell(event);
		if (shell != null) {
			dialog = new AboutDialog(shell);
			returnCode = dialog.open();
		}
		return returnCode;
	}

	@Override
	public void dispose() {
		if (dialog != null) {
			dialog.close();
		}
	}
}