package gov.ca.water.wrims.gui.ide.perspective.version;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.time.ZonedDateTime;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.eclipse.swt.widgets.Composite;

public final class VersionView extends VersionBase
{
	public static final String ID = VersionView.class.getCanonicalName();
	private static final String WRIMS_ENGINE_VERSION = "WRIMS Engine Version: ";
	private static final String WRIMS_GUI_VERSION = "WRIMS GUI Version: ";
	private static final int CURRENT_YEAR = ZonedDateTime.now().getYear();
	private static final String COPYRIGHT = String.format("© %d California Department of Water Resources", CURRENT_YEAR);
	private static final String FONT = "Arial";

	private final String wrimsEngineVersion;
	private final String applicationName;
	private final String buildDate;
	private final String wrimsGuiVersion;

	public VersionView(){
		super();
		VersionInfo versionInfo = VersionInfo.getInstance();
		wrimsEngineVersion = versionInfo.getEngineVersion();
		wrimsGuiVersion = versionInfo.getVersion();
		applicationName = versionInfo.getApplicationName();
		buildDate = versionInfo.getBuildDate();
	}

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);

		// Create the version display panel
		createVersionPanel();
	}

	private void createVersionPanel() {
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

		// Create title label
		JLabel titleLabel = new JLabel(applicationName, SwingConstants.CENTER);
		titleLabel.setFont(new Font(FONT, Font.BOLD, 24));
		titleLabel.setForeground(new Color(0, 102, 153));

		// Create version info panel
		JPanel versionInfoPanel = new JPanel();
		versionInfoPanel.setLayout(new BoxLayout(versionInfoPanel, BoxLayout.Y_AXIS));
		versionInfoPanel.setBackground(Color.WHITE);

		// Version number
		JLabel versionLabelGUI = new JLabel(WRIMS_GUI_VERSION + wrimsGuiVersion, SwingConstants.CENTER);
		versionLabelGUI.setFont(new Font(FONT, Font.PLAIN, 16));
		versionLabelGUI.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Version number
		JLabel versionLabel = new JLabel(WRIMS_ENGINE_VERSION + wrimsEngineVersion, SwingConstants.CENTER);
		versionLabel.setFont(new Font(FONT, Font.PLAIN, 16));
		versionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Build date
		JLabel buildDateLabel = new JLabel("Build Date: " + buildDate, SwingConstants.CENTER);
		buildDateLabel.setFont(new Font(FONT, Font.PLAIN, 12));
		buildDateLabel.setForeground(Color.GRAY);
		buildDateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Copyright
		JLabel copyrightLabel = new JLabel(COPYRIGHT, SwingConstants.CENTER);
		copyrightLabel.setFont(new Font(FONT, Font.PLAIN, 12));
		copyrightLabel.setForeground(Color.GRAY);
		copyrightLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		// System information
		JPanel systemInfoPanel = createSystemInfoPanel();

		// Add components to version info panel
		versionInfoPanel.add(versionLabelGUI);
		versionInfoPanel.add(Box.createVerticalStrut(10));
		versionInfoPanel.add(versionLabel);
		versionInfoPanel.add(Box.createVerticalStrut(20));
		versionInfoPanel.add(buildDateLabel);
		versionInfoPanel.add(Box.createVerticalStrut(20));
		versionInfoPanel.add(systemInfoPanel);
		versionInfoPanel.add(Box.createVerticalStrut(20));
		versionInfoPanel.add(copyrightLabel);

		// Add to main panel
		mainPanel.add(titleLabel, BorderLayout.NORTH);
		mainPanel.add(versionInfoPanel, BorderLayout.CENTER);

		// Add to content pane
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		getContentPane().repaint();
	}

	private JPanel createSystemInfoPanel() {
		JPanel systemPanel = new JPanel();
		systemPanel.setLayout(new BoxLayout(systemPanel, BoxLayout.Y_AXIS));
		systemPanel.setBackground(Color.WHITE);
		systemPanel.setBorder(BorderFactory.createTitledBorder("System Information"));

		// Java version
		String javaVersion = System.getProperty("java.version");
		JLabel javaLabel = new JLabel("Java Version: " + javaVersion);
		javaLabel.setFont(new Font(FONT, Font.PLAIN, 12));

		// Operating system
		String osName = System.getProperty("os.name");
		String osVersion = System.getProperty("os.version");
		JLabel osLabel = new JLabel("OS: " + osName + " " + osVersion);
		osLabel.setFont(new Font(FONT, Font.PLAIN, 12));

		// Architecture
		String osArch = System.getProperty("os.arch");
		JLabel archLabel = new JLabel("Architecture: " + osArch);
		archLabel.setFont(new Font(FONT, Font.PLAIN, 12));

		// Memory info
		Runtime runtime = Runtime.getRuntime();
		long maxMemory = runtime.maxMemory() / (1024 * 1024);
		long totalMemory = runtime.totalMemory() / (1024 * 1024);
		long freeMemory = runtime.freeMemory() / (1024 * 1024);
		JLabel memoryLabel = new JLabel(String.format("Memory: %d MB used, %d MB total, %d MB max",
				(totalMemory - freeMemory), totalMemory, maxMemory));
		memoryLabel.setFont(new Font(FONT, Font.PLAIN, 12));

		systemPanel.add(javaLabel);
		systemPanel.add(osLabel);
		systemPanel.add(archLabel);
		systemPanel.add(memoryLabel);

		return systemPanel;
	}
}
