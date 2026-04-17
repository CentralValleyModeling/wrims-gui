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
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
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
	private final String buildDate;
	private final String wrimsGuiVersion;
	private final Image image;
	private final Font fontBold10pt = new Font(null, FONT, 10, SWT.BOLD);
	private final Font fontBold12pt = new Font(null, FONT, 12, SWT.BOLD);
	private final Font fontBold14pt = new Font(null, FONT, 14, SWT.BOLD);
	private final Font font10pt = new Font(null, FONT, 10, SWT.NORMAL);

	public AboutDialog(Shell parentShell)
	{
		super(parentShell);
		VersionInfo versionInfo = VersionInfo.getInstance();
		wrimsEngineVersion = versionInfo.getEngineVersion();
		wrimsGuiVersion = versionInfo.getVersion();
		buildDate = versionInfo.getBuildDate();
		ImageLoader loader = ImageLoader.getInstance();
		image = loader.getImage();
	}

	@Override
	protected void configureShell(Shell shell)
	{
		super.configureShell(shell);
		VersionInfo versionInfo = VersionInfo.getInstance();
		shell.setText("About " + versionInfo.getApplicationName());
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
	}

	@Override
	protected Control createDialogArea(Composite parent)
	{
		Composite container = (Composite) super.createDialogArea(parent);

		if(image != null) {
			Rectangle imageBounds = image.getBounds();

			// Remove margins to use full image space
			GridLayout layout = new GridLayout(1, false);
			layout.marginWidth = 10;
			container.setLayout(layout);

			container.setBackgroundImage(image);

			// Set container to exact image size
			GridData containerData = new GridData(SWT.FILL, SWT.FILL, true, true);
			containerData.widthHint = imageBounds.width;
			containerData.heightHint = imageBounds.height;
			container.setLayoutData(containerData);
		} else {
			GridLayout layout = new GridLayout(1, false);
			layout.marginWidth = 20;
			container.setLayout(layout);
		}

		Label spacer = new Label(container, SWT.NONE);
		GridData gd = new GridData(SWT.FILL, SWT.CENTER, false, false);
		gd.verticalIndent = 90;
		spacer.setLayoutData(gd);

		// Build date
		Label buildLabel = new Label(container, SWT.NONE);
		buildLabel.setText("Build Date: " + buildDate);
		buildLabel.setFont(fontBold10pt);
		buildLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

		// Version
		Label versionLabel = new Label(container, SWT.NONE);
		versionLabel.setText(WRIMS_GUI_VERSION + wrimsGuiVersion);
		versionLabel.setFont(fontBold10pt);
		versionLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

		// Engine version
		Label engineLabel = new Label(container, SWT.NONE);
		engineLabel.setText(WRIMS_ENGINE_VERSION + wrimsEngineVersion);
		engineLabel.setFont(fontBold10pt);
		engineLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

		// Copyright
		Label copyrightLabel = new Label(container, SWT.NONE);
		copyrightLabel.setText(COPYRIGHT);
		copyrightLabel.setFont(font10pt);
		copyrightLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		createSystemInfoPanel(container);

		return container;
	}

	private void createSystemInfoPanel(Composite parent)
	{
		// Create a group for system information with a border
		Group systemGroup = new Group(parent, SWT.NONE);
		systemGroup.setText("System Information");
		systemGroup.setFont(fontBold10pt);
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, false);
		systemGroup.setLayoutData(gd);

		GridLayout groupLayout = new GridLayout(1, false);
		groupLayout.marginWidth = 10;
		groupLayout.marginHeight = 5;
		systemGroup.setLayout(groupLayout);

		// Java version
		String javaVersion = System.getProperty("java.version");
		Label javaLabel = new Label(systemGroup, SWT.NONE);
		javaLabel.setText("Java Version: " + javaVersion);
		javaLabel.setFont(font10pt);
		javaLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

		// Operating system
		String osName = System.getProperty("os.name");
		String osVersion = System.getProperty("os.version");
		Label osLabel = new Label(systemGroup, SWT.NONE);
		osLabel.setText("OS: " + osName + " " + osVersion);
		osLabel.setFont(font10pt);
		osLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

		// Architecture
		String osArch = System.getProperty("os.arch");
		Label archLabel = new Label(systemGroup, SWT.NONE);
		archLabel.setText("Architecture: " + osArch);
		archLabel.setFont(font10pt);
		archLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

		// Memory info
		Runtime runtime = Runtime.getRuntime();
		long maxMemory = runtime.maxMemory() / (1024 * 1024);
		Label memoryLabel = new Label(systemGroup, SWT.NONE);
		memoryLabel.setText(String.format("Memory: %d MB max", maxMemory));
		memoryLabel.setFont(font10pt);
		memoryLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent)
	{
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.DETAILS_ID, "Terms and Conditions", false).addSelectionListener(new Listener());
	}

	private class Listener implements SelectionListener
	{
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

	@Override
	public boolean close()
	{
		if (font10pt != null) {
			font10pt.dispose();
		}
		if (fontBold10pt != null) {
			fontBold10pt.dispose();
		}
		if (fontBold12pt != null) {
			fontBold12pt.dispose();
		}
		if (fontBold14pt != null) {
			fontBold14pt.dispose();
		}

		return super.close();
	}

	@Override
	protected Point getInitialSize() {
		if (image != null) {
			Rectangle imageBounds = image.getBounds();
			// Add some padding for the button bar and margins
			int width = imageBounds.width + 12; // Add margin padding
			int height = imageBounds.height + 90; // Add space for button bar
			return new Point(width, height);
		}
		return super.getInitialSize();
	}
}
