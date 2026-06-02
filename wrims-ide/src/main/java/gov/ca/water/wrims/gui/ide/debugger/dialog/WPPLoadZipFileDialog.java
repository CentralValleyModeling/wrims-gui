package gov.ca.water.wrims.gui.ide.debugger.dialog;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import gov.ca.water.wrims.gui.ide.debugger.exception.WPPException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;


public class WPPLoadZipFileDialog extends Dialog {
	private static final long MAX_EXTRACTED_SIZE = 20L * 1024L * 1024L * 1024L; // 20GB
	private static final int MAX_ENTRIES = 10000;
	private static final long MAX_ENTRY_SIZE = 1024L * 1024 * 1024L; // 1GB per entry

	private long totalExtractedSize = 0;
	private int entryCount = 0;

	private Text fileText;
	private	String fileName = "";
	private static final int BUFFER_SIZE = 4096;
	private File headDir;
	private boolean projectExist;
	
	public WPPLoadZipFileDialog(Shell parentShell) {
		super(parentShell, SWT.MIN|SWT.RESIZE);
		setText("Load Zip File");
	}

	public void openDialog() {
		Shell shell=new Shell(getParent(), getStyle());
		shell.setText(getText());
		createContents(shell);
		shell.setSize(600, 200);
		shell.setLocation(450, 300);
		shell.open();
	}

	protected void createContents(final Shell shell) {
		FillLayout fl = new FillLayout(SWT.VERTICAL);
		shell.setLayout(fl);
		fl.marginWidth = 10;
		fl.marginHeight = 15;
		
		Label label1 = new Label(shell, SWT.NONE);
		label1.setText("Please select a zip file to load:");
		
		Composite fileSelection = new Composite(shell, SWT.NONE);
		GridLayout layout = new GridLayout(15, true);
		fileSelection.setLayout(layout);
		fileText = new Text(fileSelection, SWT.SINGLE | SWT.BORDER);
		GridData gd1 = new GridData(GridData.FILL_HORIZONTAL);
		gd1.horizontalSpan = 12;
		fileText.setLayoutData(gd1);
		fileText.setText(fileName);
		
		Button browserButton = new Button(fileSelection, SWT.PUSH);
		browserButton.setText("Browser");
		GridData gd2 = new GridData(GridData.FILL_HORIZONTAL);
		gd2.horizontalSpan = 3;
		browserButton.setLayoutData(gd2);
		browserButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				final IWorkbench workbench=PlatformUI.getWorkbench();
				workbench.getDisplay().asyncExec(() -> {
					Shell shell1 = workbench.getActiveWorkbenchWindow().getShell();
					FileDialog dlg = new FileDialog(shell1, SWT.OPEN);
					dlg.setFilterNames("Zip Files (*.zip)", "All Files (*.*)");
					dlg.setFilterExtensions("*.zip", "*.*");
					dlg.setFileName(fileText.getText());
					String file = dlg.open();
					if (file != null) {
						fileText.setText(file);
					}
				});
			}
		});
	
		Composite okCancel = new Composite(shell, SWT.NONE);
		okCancel.setLayout(layout);
		Button ok = new Button(okCancel, SWT.PUSH);
		ok.setText("OK");
		GridData gd3 = new GridData(GridData.FILL_HORIZONTAL);
		gd3.horizontalSpan = 2;
		ok.setLayoutData(gd3);
		ok.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent event){
				okPressed(shell);
			}
		});
		
		Button cancel = new Button(okCancel, SWT.PUSH);
		cancel.setText("Cancel");
		GridData gd4 = new GridData(GridData.FILL_HORIZONTAL);
		gd4.horizontalSpan = 2;
		cancel.setLayoutData(gd4);
		cancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event)
			{
				shell.close();
			}
		});
		
		shell.setDefaultButton(ok);
	}
	
	public void okPressed(Shell shell) {
		fileName=fileText.getText();
		if (unzipFile()) {
			loadStudy();
		} else {
			showUnzipFailed();
		}
		shell.close();
	}
	
	public boolean unzipFile() {
		File zipFile = new File(fileName);
		if (zipFile.exists()) {
			try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFile))) {
				ZipEntry entry = zipIn.getNextEntry();
				String headPath = zipFile.getPath().replaceFirst("[.][^.]+$", "");
				headDir = new File(headPath);
				if (!headDir.exists()) {
					headDir.mkdir();
				}

				while (entry != null) {
					File destFile = new File(headDir, entry.getName());
					// Validate to avoid zip slip attacks
					if (!isValidZipPath(entry, destFile)) {
						throw new SecurityException("Invalid zip entry, outside extraction path:" + entry.getName());
					}
					String filePath = destFile.getAbsolutePath();
					if (!entry.isDirectory()) {
						// Ensure parent directories exist
						File parentDir = destFile.getParentFile();
						if (!parentDir.exists()) {
							parentDir.mkdirs();
						}
						if (destFile.getCanonicalPath().startsWith(headDir.getCanonicalPath())) {
							extractFile(zipIn, filePath);
						} else {
							throw new SecurityException("Invalid zip entry, outside extraction path:" + entry.getName());
						}
					} else {
						destFile.mkdirs();
					}
					zipIn.closeEntry();
					entry = zipIn.getNextEntry();
				}
				return true;
			} catch (Exception e) {
				WPPException.handleException(e);
				return false;
			}
		} else {
			return false;
		}
	}

	private boolean isValidZipPath(ZipEntry entry, File destFile) throws IOException {
		boolean isValid = true;
		String entryName = entry.getName();
		String extractionDirCanonicalPath = headDir.getCanonicalPath();

		if(entryName.trim().isEmpty()) {
			isValid = false;
		}

		if(entryName.startsWith("/")) {
			isValid = false;
		}

		if(entryName.contains("..")) {
			isValid = false;
		}

		String destCanonicalPath = destFile.getCanonicalPath();
		if (!destCanonicalPath.startsWith(extractionDirCanonicalPath + File.separator) &&
				!destCanonicalPath.equals(extractionDirCanonicalPath)) {
			isValid = false;
		}

		return isValid;
	}
	
	private void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
		entryCount++;
		if (entryCount > MAX_ENTRIES) {
			throw new IOException("Too many entries in the zip file: " + filePath);
		}

		try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))) {
			byte[] bytesIn = new byte[BUFFER_SIZE];
			int read = 0;
			long entrySize = 0;
			while((read = zipIn.read(bytesIn)) != -1) {
				entrySize += read;
				totalExtractedSize += read;

				if (entrySize > MAX_ENTRY_SIZE) {
					throw new IOException("Entry size exceeds the maximum allowed size of " + MAX_ENTRY_SIZE + " bytes: " + filePath);
				}

				if (totalExtractedSize > MAX_EXTRACTED_SIZE) {
					throw new IOException("Total extracted size exceeds the maximum allowed size of " + MAX_EXTRACTED_SIZE + " bytes");
				}

				bos.write(bytesIn, 0, read);
			}
		}
	}
	
	public void loadStudy() {
		projectExist=false;
		
		walk(headDir);

		if (!projectExist) {
			showProjectNotFound();
		}
	}
		
	public void walk(File file) {
		if (projectExist) return;
		
		File[] list = file.listFiles();
        if (list == null) {
        	return;
        }

        for ( File f : list ) {
            if ( f.isDirectory() ) {
                walk(f);
            }
            else {
                if (f.getName().equalsIgnoreCase(".project")) {
                	IProjectDescription description;
					try {
						description = ResourcesPlugin
								   .getWorkspace().loadProjectDescription(new Path(f.getAbsolutePath()));
						IProject project = ResourcesPlugin.getWorkspace()
	                			   .getRoot().getProject(description.getName());
	                			project.create(description, null);
	                			project.open(null);
	                	projectExist = true;
	                	return;
					} catch (CoreException e) {
						WPPException.handleException(e);
					}
                }
            }
        }
	}
	
	public void showProjectNotFound() {
		final IWorkbench workbench=PlatformUI.getWorkbench();
		workbench.getDisplay().asyncExec(() -> {
			Shell shell = workbench.getActiveWorkbenchWindow().getShell();
			MessageBox messageBox = new MessageBox(shell, SWT.ICON_WARNING);
			messageBox.setText("Warning");
			messageBox.setMessage("Project/study is not found in the zip file.");
			messageBox.open();
		});
	}
	
	public void showUnzipFailed() {
		final IWorkbench workbench=PlatformUI.getWorkbench();
		workbench.getDisplay().asyncExec(() -> {
			Shell shell = workbench.getActiveWorkbenchWindow().getShell();
			MessageBox messageBox = new MessageBox(shell, SWT.ICON_ERROR);
			messageBox.setText("Error");
			messageBox.setMessage("File unzip failed");
			messageBox.open();
		});
	}
}
