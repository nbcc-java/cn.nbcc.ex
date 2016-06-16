package cn.nbcc.ex29.ch09;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class DisplayPanel extends Composite {

	private Label msgLabel;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public DisplayPanel(Composite parent, int style) {
		super(parent, style);
		this.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		FillLayout fillLayout = new FillLayout(SWT.HORIZONTAL);
		fillLayout.marginHeight = 10;
		fillLayout.marginWidth = 5;
		this.setLayout(fillLayout);
		
		msgLabel = new Label(this, SWT.NONE);
		msgLabel.setAlignment(SWT.CENTER);
		msgLabel.setText("\u6B22\u8FCE\u4F7F\u7528\u5FAE\u6CE2\u7089");
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
