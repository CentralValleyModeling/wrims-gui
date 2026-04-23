package gov.ca.water.wrims.gui.ide.about.dialog;


import java.net.MalformedURLException;
import java.net.URI;
import java.time.ZonedDateTime;

import com.google.common.flogger.FluentLogger;
import gov.ca.water.wrims.gui.ide.about.util.AboutInfoLoader;
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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.internal.about.AboutUtils;
import org.eclipse.ui.internal.about.InstallationDialog;

public class AboutDialog extends Dialog {
	private static final FluentLogger LOGGER = FluentLogger.forEnclosingClass();
	private static final String WRIMS_ENGINE_VERSION = "Engine Version: ";
	private static final String WRIMS_GUI_VERSION = "GUI Version: ";
	private static final int CURRENT_YEAR = ZonedDateTime.now().getYear();
	private static final String COPYRIGHT = String.format("© %d California Department of Water Resources", CURRENT_YEAR);
	private static final String FONT = "Arial";
	private static final int WIDTH = 880;
	private static final int HEIGHT = 580;

	private final String wrimsEngineVersion;
	private final String buildDate;
	private final String wrimsGuiVersion;
	private final Image image;
	private final String aboutText;
	private final Font fontBold10pt = new Font(null, FONT, 10, SWT.BOLD);
	private final Font fontBold12pt = new Font(null, FONT, 12, SWT.BOLD);
	private final Font fontBold14pt = new Font(null, FONT, 14, SWT.BOLD);
	private final Font font10pt = new Font(null, FONT, 10, SWT.NORMAL);
	private final Font font12pt = new Font(null, FONT, 12, SWT.NORMAL);

	public AboutDialog(Shell parentShell) {
		super(parentShell);
		VersionInfo versionInfo = VersionInfo.getInstance();
		wrimsEngineVersion = versionInfo.getEngineVersion();
		wrimsGuiVersion = versionInfo.getVersion();
		buildDate = versionInfo.getBuildDate();
		ImageLoader loader = ImageLoader.getInstance();
		image = loader.getImage();
		AboutInfoLoader aboutLoader = AboutInfoLoader.getInstance();
		aboutText = aboutLoader.getAboutText();
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		VersionInfo versionInfo = VersionInfo.getInstance();
		shell.setText("About " + versionInfo.getApplicationName());
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);

		// Remove margins to use full image space
		GridLayout layout = new GridLayout(2, false);
		container.setLayout(layout);

		createImageColumn(container);

		createInfoColumn(container);

		createTextColumn(container);

		return container;
	}

	private void createImageColumn(Composite container) {
		Composite imageColumn = new Composite(container, SWT.NONE);
		GridData imageColumnData = new GridData(SWT.LEFT, SWT.CENTER, false, true);
		imageColumnData.widthHint = WIDTH / 2;
		imageColumn.setLayoutData(imageColumnData);

		GridLayout layout = new GridLayout(1, false);
		imageColumn.setLayout(layout);

		Label imageLabel = new Label(imageColumn, SWT.NONE);
		imageLabel.setImage(image);
		imageLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true));
	}

	private void createInfoColumn(Composite container) {
		Composite infoColumn = new Composite(container, SWT.NONE);

		GridData infoColumnData = new GridData(SWT.LEFT, SWT.CENTER, true, true);
		infoColumnData.widthHint = WIDTH / 2;
		infoColumn.setLayoutData(infoColumnData);

		GridLayout layout = new GridLayout(1, false);
		layout.marginLeft = 20;
		infoColumn.setLayout(layout);

		// Build date
		Label buildLabel = new Label(infoColumn, SWT.NONE);
		String buildText = "Build Date: " + buildDate;
		buildLabel.setText(buildText);
		buildLabel.addPaintListener(e -> {
			e.gc.setFont(fontBold12pt);
			e.gc.setForeground(e.display.getSystemColor(SWT.COLOR_BLACK));
			e.gc.drawText(buildText, e.x + 1, e.y + 1, true);

			e.gc.setForeground(e.display.getSystemColor(SWT.COLOR_WHITE));
			e.gc.drawText(buildText, e.x, e.y, true);
		});
		buildLabel.setFont(fontBold12pt);
		GridData buildGD = new GridData(SWT.LEFT, SWT.CENTER, true, true);
		buildLabel.setLayoutData(buildGD);

		// Version
		Label versionLabel = new Label(infoColumn, SWT.NONE);
		String versionText = WRIMS_GUI_VERSION + wrimsGuiVersion;
		versionLabel.setText(versionText);
		versionLabel.setFont(fontBold12pt);
		versionLabel.addPaintListener(e -> {
			e.gc.setFont(fontBold12pt);
			e.gc.setForeground(e.display.getSystemColor(SWT.COLOR_BLACK));
			e.gc.drawText(versionText, e.x + 1, e.y + 1, true);

			e.gc.setForeground(e.display.getSystemColor(SWT.COLOR_WHITE));
			e.gc.drawText(versionText, e.x, e.y, true);
		});
		GridData versionGD = new GridData(SWT.LEFT, SWT.CENTER, true, true);
		versionGD.verticalIndent = 10;
		versionLabel.setLayoutData(versionGD);

		// Engine version
		Label engineLabel = new Label(infoColumn, SWT.NONE);
		String engineText = WRIMS_ENGINE_VERSION + wrimsEngineVersion;
		engineLabel.setText(engineText);
		engineLabel.setFont(fontBold12pt);
		engineLabel.addPaintListener(e -> {
			e.gc.setFont(fontBold12pt);
			e.gc.setForeground(e.display.getSystemColor(SWT.COLOR_BLACK));
			e.gc.drawText(engineText, e.x + 1, e.y + 1, true);

			e.gc.setForeground(e.display.getSystemColor(SWT.COLOR_WHITE));
			e.gc.drawText(engineText, e.x, e.y, true);
		});
		GridData engineGD = new GridData(SWT.LEFT, SWT.CENTER, true, true);
		engineGD.verticalIndent = 10;
		engineLabel.setLayoutData(engineGD);

		// Copyright
		Label copyrightLabel = new Label(infoColumn, SWT.NONE);
		copyrightLabel.setText(COPYRIGHT);
		copyrightLabel.setFont(font10pt);
		copyrightLabel.addPaintListener(e -> {
			e.gc.setFont(font10pt);
			e.gc.setForeground(e.display.getSystemColor(SWT.COLOR_BLACK));
			e.gc.drawText(COPYRIGHT, e.x + 1, e.y + 1, true);

			e.gc.setForeground(e.display.getSystemColor(SWT.COLOR_WHITE));
			e.gc.drawText(COPYRIGHT, e.x, e.y, true);
		});
		GridData copyrightGD = new GridData(SWT.LEFT, SWT.CENTER, true, true);
		copyrightGD.verticalIndent = 20;
		copyrightLabel.setLayoutData(copyrightGD);
		createSystemInfoPanel(infoColumn);
	}

	private void createSystemInfoPanel(Composite parent) {
		// Create a group for system information with a border
		Group systemGroup = new Group(parent, SWT.NONE);
		systemGroup.setText("System Information");
		systemGroup.setFont(fontBold10pt);
		GridData gd = new GridData(SWT.LEFT, SWT.CENTER, false, false);
		gd.widthHint = 200;
		gd.verticalIndent = 20;
		systemGroup.setLayoutData(gd);

		GridLayout groupLayout = new GridLayout(1, false);
		systemGroup.setLayout(groupLayout);

		// Java version
		String javaVersion = System.getProperty("java.version");
		Label javaLabel = new Label(systemGroup, SWT.NONE);
		String versionText = "Java Version: " + javaVersion;
		javaLabel.setText(versionText);
		javaLabel.setFont(font10pt);
		javaLabel.addPaintListener(e -> {
			e.gc.setFont(font10pt);
			e.gc.setForeground(e.display.getSystemColor(SWT.COLOR_BLACK));
			e.gc.drawText(versionText, e.x + 1, e.y + 1, true);

			e.gc.setForeground(e.display.getSystemColor(SWT.COLOR_WHITE));
			e.gc.drawText(versionText, e.x, e.y, true);
		});
		javaLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

		// Operating system
		String osName = System.getProperty("os.name");
		String osVersion = System.getProperty("os.version");
		Label osLabel = new Label(systemGroup, SWT.NONE);
		String osText = "OS: " + osName + " " + osVersion;
		osLabel.setText(osText);
		osLabel.setFont(font10pt);
		osLabel.addPaintListener(e -> {
			e.gc.setFont(font10pt);
			e.gc.setForeground(e.display.getSystemColor(SWT.COLOR_BLACK));
			e.gc.drawText(osText, e.x + 1, e.y + 1, true);

			e.gc.setForeground(e.display.getSystemColor(SWT.COLOR_WHITE));
			e.gc.drawText(osText, e.x, e.y, true);
		});
		osLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

		// Architecture
		String osArch = System.getProperty("os.arch");
		Label archLabel = new Label(systemGroup, SWT.NONE);
		String archText = "Architecture: " + osArch;
		archLabel.setText(archText);
		archLabel.setFont(font10pt);
		archLabel.addPaintListener(e -> {
			e.gc.setFont(font10pt);
			e.gc.setForeground(e.display.getSystemColor(SWT.COLOR_BLACK));
			e.gc.drawText(archText, e.x + 1, e.y + 1, true);

			e.gc.setForeground(e.display.getSystemColor(SWT.COLOR_WHITE));
			e.gc.drawText(archText, e.x, e.y, true);
		});
		archLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

		// Memory info
		Runtime runtime = Runtime.getRuntime();
		long maxMemory = runtime.maxMemory() / (1024 * 1024);
		Label memoryLabel = new Label(systemGroup, SWT.NONE);
		String memoryText = String.format("Memory: %d MB max", maxMemory);
		memoryLabel.setText(memoryText);
		memoryLabel.setFont(font10pt);
		memoryLabel.addPaintListener(e -> {
			e.gc.setFont(font10pt);
			e.gc.setForeground(e.display.getSystemColor(SWT.COLOR_BLACK));
			e.gc.drawText(memoryText, e.x + 1, e.y + 1, true);

			e.gc.setForeground(e.display.getSystemColor(SWT.COLOR_WHITE));
			e.gc.drawText(memoryText, e.x, e.y, true);
		});
		memoryLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
	}

	private void createTextColumn(Composite parent) {
		Composite textColumn = new Composite(parent, SWT.NONE);
		GridData textColumnData = new GridData(SWT.FILL, SWT.FILL, true, true);
		textColumnData.widthHint = WIDTH - 10;
		textColumnData.horizontalSpan = 2;
		textColumn.setLayoutData(textColumnData);

		GridLayout layout = new GridLayout(1, false);
		layout.marginWidth = 10;
		layout.marginHeight = 0;
		textColumn.setLayout(layout);

		// Custom text group
		Group customGroup = new Group(textColumn, SWT.NONE);
		customGroup.setFont(fontBold10pt);
		customGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		GridLayout customLayout = new GridLayout(1, false);
		customLayout.marginWidth = 10;
		customLayout.marginHeight = 10;
		customGroup.setLayout(customLayout);

		// Get custom text from gradle.properties or use default

		Link textWidget = new Link(customGroup, SWT.MULTI | SWT.WRAP | SWT.READ_ONLY);
		textWidget.setText(aboutText);
		textWidget.setFont(font12pt);
		textWidget.addSelectionListener(new LinkListener());
		textWidget.setForeground(textWidget.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		GridData textData = new GridData(SWT.FILL, SWT.FILL, true, true);
		textData.heightHint = 150;
		textWidget.setLayoutData(textData);
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.DETAILS_ID, "Installation Details", false).addSelectionListener(new InstallListener());
		createButton(parent, IDialogConstants.DETAILS_ID, "Terms and Conditions", false).addSelectionListener(new Listener());
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
	}

	private class Listener implements SelectionListener {
		@Override
		public void widgetSelected(SelectionEvent e) {
			TermsDialog termsDialog = new TermsDialog(getShell());
			termsDialog.open();
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			// NO OP
		}
	}

	private class LinkListener implements SelectionListener
	{
		@Override
		public void widgetSelected(SelectionEvent e)
		{
			try
			{
				AboutUtils.openBrowser(getShell(), URI.create(e.text).toURL());
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

	private class InstallListener implements SelectionListener {
		@Override
		public void widgetSelected(SelectionEvent e) {
			InstallationDialog installationDialog = new InstallationDialog(getShell(), null);
			installationDialog.open();
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			// NO OP
		}
	}

	@Override
	public boolean close() {
		font10pt.dispose();
		font12pt.dispose();
		fontBold10pt.dispose();
		fontBold12pt.dispose();
		fontBold14pt.dispose();
		return super.close();
	}

	@Override
	protected Point getInitialSize() {
		return new Point(WIDTH, HEIGHT);
	}
}
