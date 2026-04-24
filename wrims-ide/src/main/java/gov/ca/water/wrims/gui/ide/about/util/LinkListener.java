package gov.ca.water.wrims.gui.ide.about.util;

import java.net.MalformedURLException;
import java.net.URI;

import com.google.common.flogger.FluentLogger;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.internal.about.AboutUtils;

public class LinkListener implements SelectionListener {
	private static final FluentLogger LOGGER = FluentLogger.forEnclosingClass();
	private final Shell shell;

	public LinkListener(Shell shell)
	{
		this.shell = shell;
	}

	@Override
	public void widgetSelected(SelectionEvent e)
	{
		try
		{
			AboutUtils.openBrowser(shell, URI.create(e.text).toURL());
		}
		catch(MalformedURLException ex)
		{
			LOGGER.atSevere().withCause(ex).log("Error opening URL: %s", e.text);
		}
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		// NO OP
	}
}