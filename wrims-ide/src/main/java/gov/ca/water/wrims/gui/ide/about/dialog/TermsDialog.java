package gov.ca.water.wrims.gui.ide.about.dialog;

import gov.ca.water.wrims.gui.ide.about.util.LinkListener;
import gov.ca.water.wrims.gui.ide.about.util.TermsAndConditionsLoader;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;

public final class TermsDialog extends Dialog {
	private static final int WIDTH = 500;
	private static final int HEIGHT = 400;
	private final String terms;

	public TermsDialog(Shell parentShell) {
		super(parentShell);
		TermsAndConditionsLoader loader = TermsAndConditionsLoader.getInstance();
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
		container.setLayout(new GridLayout(1, false));

		ScrolledComposite scrolledComposite = new ScrolledComposite(container, SWT.V_SCROLL);
		GridData scrollData = new GridData(SWT.FILL, SWT.FILL, true, true);
		scrollData.heightHint = HEIGHT;
		scrollData.widthHint = WIDTH;
		scrolledComposite.setLayoutData(scrollData);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);

		// Create a container for the Link widget
		Composite contentComposite = new Composite(scrolledComposite, SWT.NONE);
		GridLayout contentLayout = new GridLayout(1, false);
		contentLayout.marginWidth = 10;
		contentLayout.marginHeight = 10;
		contentComposite.setLayout(contentLayout);

		Link text = new Link(contentComposite, SWT.MULTI | SWT.WRAP);
		text.setText(terms);
		text.addSelectionListener(new LinkListener(getShell()));

		GridData linkData = new GridData(SWT.FILL, SWT.TOP, true, false);
		text.setLayoutData(linkData);

		// Set the container as the content of the ScrolledComposite
		scrolledComposite.setContent(contentComposite);

		// Add a resize listener to update the minimum size when the scrolled composite resizes
		scrolledComposite.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				if (!scrolledComposite.isDisposed() && !contentComposite.isDisposed()) {
					updateScrolledCompositeSize(scrolledComposite, contentComposite);
				}
			}
		});

		// Initial size calculation
		scrolledComposite.getDisplay().asyncExec(() -> {
			if (!scrolledComposite.isDisposed() && !contentComposite.isDisposed()) {
				updateScrolledCompositeSize(scrolledComposite, contentComposite);
			}
		});

		return container;
	}

	private void updateScrolledCompositeSize(ScrolledComposite scrolledComposite, Composite contentComposite) {
		int availableWidth = scrolledComposite.getClientArea().width;
		if(availableWidth > 0) {
			// Calculate the preferred size for the content
			Point contentSize = contentComposite.computeSize(availableWidth, SWT.DEFAULT);

			// Set the minimum size for scrolling
			scrolledComposite.setMinSize(contentSize);

			// Force the content to use the available width
			contentComposite.setSize(availableWidth, contentSize.y);
		}
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
	}

	@Override
	protected Point getInitialSize() {
		return new Point(WIDTH, HEIGHT);
	}
}
