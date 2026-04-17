package gov.ca.water.wrims.gui.ide.about.dialog;


import java.time.ZonedDateTime;

import gov.ca.water.wrims.gui.ide.about.util.ImageLoader;
import gov.ca.water.wrims.gui.ide.about.util.VersionInfo;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class AboutDialog extends Dialog {
	private static final String WRIMS_ENGINE_VERSION = "Engine Version: ";
	private static final String WRIMS_GUI_VERSION = "GUI Version: ";
	private static final int CURRENT_YEAR = ZonedDateTime.now().getYear();
	private static final String COPYRIGHT = String.format("© %d California Department of Water Resources", CURRENT_YEAR);
	private static final String FONT = "Arial";

	private final String wrimsEngineVersion;
	private final String applicationName;
	private final String buildDate;
	private final String wrimsGuiVersion;
	private final Image image;

	public AboutDialog(Shell parentShell) {
		super(parentShell);
		VersionInfo versionInfo = VersionInfo.getInstance();
		wrimsEngineVersion = versionInfo.getEngineVersion();
		wrimsGuiVersion = versionInfo.getVersion();
		applicationName = versionInfo.getApplicationName();
		buildDate = versionInfo.getBuildDate();
		ImageLoader loader = ImageLoader.getInstance();
		image = loader.getImage();
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		VersionInfo versionInfo = VersionInfo.getInstance();
		shell.setText("About " + versionInfo.getApplicationName());
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		GridLayout layout = new GridLayout(1, false);
		layout.marginHeight = 20;
		layout.marginWidth = 20;
		container.setLayout(layout);

		if (image != null) {
			container.setBackgroundImage(image);
		}

		// Application name
		Label appNameLabel = new Label(container, SWT.NONE);
		appNameLabel.setText(applicationName);
		appNameLabel.setFont(new Font(null, FONT, 24, SWT.BOLD));
		appNameLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));

		// Version
		Label versionLabel = new Label(container, SWT.NONE);
		versionLabel.setText(WRIMS_GUI_VERSION + wrimsGuiVersion);
		versionLabel.setFont(new Font(null, FONT, 16, SWT.BOLD));
		versionLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));

		// Build date
		Label buildLabel = new Label(container, SWT.NONE);
		buildLabel.setText("Build Date: " + buildDate);
		buildLabel.setFont(new Font(null, FONT, 14, SWT.BOLD));
		buildLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));

		// Engine version
		Label engineLabel = new Label(container, SWT.NONE);
		engineLabel.setText(WRIMS_ENGINE_VERSION + wrimsEngineVersion);
		engineLabel.setFont(new Font(null, FONT, 16, SWT.BOLD));
		engineLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));

		// Copyright
		Label copyrightLabel = new Label(container, SWT.NONE);
		copyrightLabel.setText(COPYRIGHT);
		copyrightLabel.setFont(new Font(null, FONT, 14, SWT.BOLD));
		copyrightLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));
		createSystemInfoPanel(container);

		return container;
	}

	private void createSystemInfoPanel(Composite parent) {
		// Create a group for system information with a border
		Group systemGroup = new Group(parent, SWT.NONE);
		systemGroup.setText("System Information");
		systemGroup.setFont(new Font(null, FONT, 12, SWT.BOLD));
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, false);
		gd.verticalIndent = 20;
		systemGroup.setLayoutData(gd);

		GridLayout groupLayout = new GridLayout(1, false);
		groupLayout.marginWidth = 10;
		groupLayout.marginHeight = 10;
		systemGroup.setLayout(groupLayout);

		// Java version
		String javaVersion = System.getProperty("java.version");
		Label javaLabel = new Label(systemGroup, SWT.NONE);
		javaLabel.setText("Java Version: " + javaVersion);
		javaLabel.setFont(new Font(null, FONT, 10, SWT.NORMAL));
		javaLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));

		// Operating system
		String osName = System.getProperty("os.name");
		String osVersion = System.getProperty("os.version");
		Label osLabel = new Label(systemGroup, SWT.NONE);
		osLabel.setText("OS: " + osName + " " + osVersion);
		osLabel.setFont(new Font(null, FONT, 10, SWT.NORMAL));
		osLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));

		// Architecture
		String osArch = System.getProperty("os.arch");
		Label archLabel = new Label(systemGroup, SWT.NONE);
		archLabel.setText("Architecture: " + osArch);
		archLabel.setFont(new Font(null, FONT, 10, SWT.NORMAL));
		archLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));

		// Memory info
		Runtime runtime = Runtime.getRuntime();
		long maxMemory = runtime.maxMemory() / (1024 * 1024);
		Label memoryLabel = new Label(systemGroup, SWT.NONE);
		memoryLabel.setText(String.format("Memory: %d MB max", maxMemory));
		memoryLabel.setFont(new Font(null, FONT, 10, SWT.NORMAL));
		memoryLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.DETAILS_ID, "Terms and Conditions", false).addSelectionListener(new Listener());
	}

	private class Listener implements SelectionListener {

		@Override
		public void widgetSelected(SelectionEvent e)
		{
			TermsDialog termsDialog = new TermsDialog(getShell());
			termsDialog.open();
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e)
		{
			// NO OP
		}
	}
}
