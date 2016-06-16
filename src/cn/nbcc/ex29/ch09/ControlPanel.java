package cn.nbcc.ex29.ch09;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class ControlPanel extends Composite {

	private Button btnStart;
	private Button btnClear;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public ControlPanel(Composite parent, int style) {
		super(parent, style);

		this.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		this.setLayout(new GridLayout(2, false));
		
		btnStart = new Button(this, SWT.NONE);
		btnStart.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		btnStart.setBounds(0, 0, 80, 27);
		btnStart.setText("Start");
		
		btnClear = new Button(this, SWT.NONE);
		btnClear.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		btnClear.setBounds(0, 0, 80, 27);
		btnClear.setText("Clear");
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
