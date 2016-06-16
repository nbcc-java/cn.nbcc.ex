package cn.nbcc.ex29.ch09;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class KeyboardPanel extends Composite {

	Button buttons[] = new Button[10];
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public KeyboardPanel(Composite parent, int style) {
		super(parent, style);
		GridData gd = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
		gd.widthHint = 146;
		this.setLayoutData(gd);
		this.setLayout(new GridLayout(3, false));
		
		for (int i = 0; i < buttons.length; i++) {
			Button btn = new Button(this, SWT.NONE);
			btn.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
			btn.setBounds(0, 0, 80, 27);
			btn.setText(i+"");
		}
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
