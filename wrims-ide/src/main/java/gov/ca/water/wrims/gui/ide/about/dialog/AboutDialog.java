package gov.ca.water.wrims.gui.ide.about.dialog;


import java.time.ZonedDateTime;

import com.google.common.flogger.FluentLogger;
import gov.ca.water.wrims.gui.ide.about.util.AboutInfoLoader;
import gov.ca.water.wrims.gui.ide.about.util.ImageLoader;
import gov.ca.water.wrims.gui.ide.about.util.LinkListener;
import gov.ca.water.wrims.gui.ide.about.util.VersionInfo;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.resource.FontDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.about.InstallationDialog;
import org.eclipse.ui.themes.IThemeManager;

public final class AboutDialog extends Dialog {
	private static final FluentLogger LOGGER = FluentLogger.forEnclosingClass();
	private static final String WRIMS_ENGINE_VERSION = "Engine Version: ";
	private static final String WRIMS_GUI_VERSION = "GUI Version: ";
	private static final int CURRENT_YEAR = ZonedDateTime.now().getYear();
	private static final String COPYRIGHT = String.format("© %d California Department of Water Resources", CURRENT_YEAR);
	private static final int WIDTH = 880;
	private static final int HEIGHT = 580;
	private static final int TERMS_AND_CONDITIONS_BUTTON_ID = IDialogConstants.CLIENT_ID + 120;

	private final String wrimsEngineVersion;
	private final String buildDate;
	private final String wrimsGuiVersion;
	private final Image image;
	private final String aboutText;
	private final VersionInfo versionInfo;
	private final boolean darkTheme = isDarkTheme();

	private final ResourceManager resourceManager;

	public AboutDialog(Shell parentShell) {
		super(parentShell);
		resourceManager = new LocalResourceManager(JFaceResources.getResources());

		versionInfo = VersionInfo.getInstance();
		wrimsEngineVersion = versionInfo.getEngineVersion();
		wrimsGuiVersion = versionInfo.getVersion();
		buildDate = versionInfo.getBuildDate();
		ImageLoader imageLoader = ImageLoader.getInstance(versionInfo.getImagePlugin(), resourceManager);
		image = imageLoader.getImage();
		AboutInfoLoader aboutLoader = AboutInfoLoader.getInstance();
		aboutText = aboutLoader.getAboutText();
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("About " + versionInfo.getApplicationName());
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
	}

	// Helper method to create and track fonts
	private Font createFont(int size, int style) {
		String font = JFaceResources.getDialogFont().getFontData()[0].getName();
		FontDescriptor fontDesc = FontDescriptor.createFrom(font, size, style);
		return resourceManager.create(fontDesc);
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
		GridData imageColumnData = new GridData(SWT.LEFT, SWT.CENTER, true, true);
		imageColumnData.widthHint = WIDTH / 2;
		imageColumn.setLayoutData(imageColumnData);

		GridLayout layout = new GridLayout(1, false);
		imageColumn.setLayout(layout);

		try {
			Label imageLabel = new Label(imageColumn, SWT.FILL);
			imageLabel.setImage(image);
			imageLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, true));
		} catch (IllegalArgumentException e) {
			LOGGER.atWarning().withCause(e).log("Error creating image label");
		}
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
		Text buildLabel = new Text(infoColumn, SWT.READ_ONLY);
		buildLabel.setForeground(buildLabel.getDisplay().getSystemColor(getColor()));
		buildLabel.setBackground(buildLabel.getParent().getBackground());
		String buildText = "Build Date: " + buildDate;
		buildLabel.setText(buildText);
		buildLabel.setSize(WIDTH / 2, 20);
		buildLabel.setFont(createFont(12, SWT.BOLD));
		GridData buildGD = new GridData(SWT.LEFT, SWT.CENTER, true, true);
		buildLabel.setLayoutData(buildGD);

		// Version
		Text versionLabel = new Text(infoColumn,SWT.READ_ONLY);
		versionLabel.setBackground(versionLabel.getParent().getBackground());
		versionLabel.setForeground(versionLabel.getDisplay().getSystemColor(getColor()));
		String versionText = WRIMS_GUI_VERSION + wrimsGuiVersion;
		versionLabel.setText(versionText);
		versionLabel.setSize(WIDTH / 2, 20);
		versionLabel.setFont(createFont(12, SWT.BOLD));
		GridData versionGD = new GridData(SWT.LEFT, SWT.CENTER, true, true);
		versionGD.verticalIndent = 10;
		versionLabel.setLayoutData(versionGD);

		// Engine version
		Text engineLabel = new Text(infoColumn, SWT.READ_ONLY);
		engineLabel.setBackground(engineLabel.getParent().getBackground());
		engineLabel.setForeground(engineLabel.getDisplay().getSystemColor(getColor()));
		String engineText = WRIMS_ENGINE_VERSION + wrimsEngineVersion;
		engineLabel.setText(engineText);
		engineLabel.setFont(createFont(12, SWT.BOLD));
		engineLabel.setSize(WIDTH / 2, 20);
		GridData engineGD = new GridData(SWT.LEFT, SWT.CENTER, true, true);
		engineGD.verticalIndent = 10;
		engineLabel.setLayoutData(engineGD);

		// Copyright
		Text copyrightLabel = new Text(infoColumn, SWT.READ_ONLY);
		copyrightLabel.setForeground(copyrightLabel.getDisplay().getSystemColor(getColor()));
		copyrightLabel.setBackground(copyrightLabel.getParent().getBackground());
		copyrightLabel.setText(COPYRIGHT);
		copyrightLabel.setFont(createFont(10, SWT.NORMAL));
		copyrightLabel.setSize(WIDTH / 2, 20);
		GridData copyrightGD = new GridData(SWT.LEFT, SWT.CENTER, true, true);
		copyrightGD.verticalIndent = 20;
		copyrightLabel.setLayoutData(copyrightGD);
		createSystemInfoPanel(infoColumn);
	}

	private void createSystemInfoPanel(Composite parent) {
		// Create a group for system information with a border
		Group systemGroup = new Group(parent, SWT.NONE);
		systemGroup.setText("System Information");
		systemGroup.setFont(createFont(10, SWT.BOLD));
		GridData gd = new GridData(SWT.LEFT, SWT.CENTER, false, false);
		gd.widthHint = 200;
		gd.verticalIndent = 20;
		systemGroup.setLayoutData(gd);

		GridLayout groupLayout = new GridLayout(1, false);
		systemGroup.setLayout(groupLayout);

		// Java version
		String javaVersion = System.getProperty("java.version");
		Text javaLabel = new Text(systemGroup, SWT.READ_ONLY);
		javaLabel.setForeground(javaLabel.getDisplay().getSystemColor(getColor()));
		javaLabel.setBackground(javaLabel.getParent().getBackground());
		String versionText = "Java Version: " + javaVersion;
		javaLabel.setText(versionText);
		javaLabel.setFont(createFont(10, SWT.NORMAL));
		javaLabel.setSize(WIDTH / 2, 20);
		javaLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

		// Operating system
		String osName = System.getProperty("os.name");
		String osVersion = System.getProperty("os.version");
		Text osLabel = new Text(systemGroup, SWT.READ_ONLY);
		osLabel.setForeground(osLabel.getDisplay().getSystemColor(getColor()));
		osLabel.setBackground(osLabel.getParent().getBackground());
		String osText = "OS: " + osName + " " + osVersion;
		osLabel.setText(osText);
		osLabel.setSize(WIDTH / 2, 20);
		osLabel.setFont(createFont(10, SWT.NORMAL));
		osLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

		// Architecture
		String osArch = System.getProperty("os.arch");
		Text archLabel = new Text(systemGroup, SWT.READ_ONLY);
		archLabel.setForeground(archLabel.getDisplay().getSystemColor(getColor()));
		archLabel.setBackground(archLabel.getParent().getBackground());
		String archText = "Architecture: " + osArch;
		archLabel.setText(archText);
		archLabel.setSize(WIDTH / 2, 20);
		archLabel.setFont(createFont(10, SWT.NORMAL));
		archLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

		// Memory info
		Runtime runtime = Runtime.getRuntime();
		long maxMemory = runtime.maxMemory() / (1024 * 1024);
		Text memoryLabel = new Text(systemGroup, SWT.READ_ONLY);
		memoryLabel.setForeground(memoryLabel.getDisplay().getSystemColor(getColor()));
		memoryLabel.setBackground(memoryLabel.getParent().getBackground());
		String memoryText = String.format("Memory: %d MB max", maxMemory);
		memoryLabel.setText(memoryText);
		memoryLabel.setFont(createFont(10, SWT.NORMAL));
		memoryLabel.setSize(WIDTH / 2, 20);
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

		Group customGroup = new Group(textColumn, SWT.NONE);
		customGroup.setFont(createFont(10, SWT.BOLD));
		customGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		GridLayout customLayout = new GridLayout(1, false);
		customLayout.marginWidth = 10;
		customLayout.marginHeight = 10;
		customGroup.setLayout(customLayout);

		ScrolledComposite scrolledComposite = new ScrolledComposite(customGroup, SWT.V_SCROLL);
		GridData scrollData = new GridData(SWT.FILL, SWT.FILL, true, true);
		scrollData.heightHint = 150;
		scrolledComposite.setLayoutData(scrollData);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);

		// Create a container for the Link widget
		Composite contentComposite = new Composite(scrolledComposite, SWT.NONE);
		GridLayout contentLayout = new GridLayout(1, false);
		contentLayout.marginWidth = 0;
		contentLayout.marginHeight = 0;
		contentComposite.setLayout(contentLayout);

		Link textWidget = new Link(contentComposite, SWT.MULTI | SWT.WRAP | SWT.READ_ONLY);
		textWidget.setText(aboutText);
		textWidget.setFont(createFont(12, SWT.NORMAL));
		textWidget.addSelectionListener(new LinkListener(getShell()));
		textWidget.setForeground(textWidget.getDisplay().getSystemColor(getColor()));

		GridData linkData = new GridData(SWT.FILL, SWT.TOP, true, false);
		textWidget.setLayoutData(linkData);

		scrolledComposite.setContent(contentComposite);

		// Add a resize listener to update the minimum size when the scrolled composite resizes
		scrolledComposite.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
			int width = scrolledComposite.getClientArea().width;
			if (width > 0) {
				Point size = contentComposite.computeSize(width, SWT.DEFAULT);
				scrolledComposite.setMinSize(size);
				contentComposite.setSize(size);
			}
			}
		});

		// Initial size calculation
		scrolledComposite.getDisplay().asyncExec(() -> {
			int width = scrolledComposite.getClientArea().width;
			if (width > 0) {
				Point size = contentComposite.computeSize(width, SWT.DEFAULT);
				scrolledComposite.setMinSize(size);
				contentComposite.setSize(size);
			}
		});
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.DETAILS_ID, "Installation Details", false)
			.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Uses internal Eclipse dialog API that could change or be removed in the future
				InstallationDialog installationDialog = new InstallationDialog(getShell(), null);
				installationDialog.open();
			}
		});
		createButton(parent, TERMS_AND_CONDITIONS_BUTTON_ID, "Terms and Conditions", false)
			.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					TermsDialog termsDialog = new TermsDialog(getShell());
					termsDialog.open();
				}
			});
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
	}

	private boolean isDarkTheme() {
		boolean isDarkTheme = false;
		try {
			IThemeManager themeManager = PlatformUI.getWorkbench().getThemeManager();
			String activeTheme = themeManager.getCurrentTheme().getId();
			isDarkTheme = activeTheme != null && activeTheme.contains("dark");
		} catch (Exception e) {
			LOGGER.atFiner().withCause(e).log("Error checking UI theme.");
		}
		return isDarkTheme;
	}

	private int getColor() {
		return darkTheme ? SWT.COLOR_WHITE : SWT.COLOR_BLACK;
	}

	@Override
	protected Point getInitialSize() {
		return new Point(WIDTH, HEIGHT);
	}

	@Override
	public boolean close() {
		if (resourceManager != null) {
			resourceManager.dispose();
		}
		return super.close();
	}
}
