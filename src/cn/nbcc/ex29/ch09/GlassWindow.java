package cn.nbcc.ex29.ch09;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

public class GlassWindow extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public GlassWindow(Composite parent, int style) {
		super(parent, style);
		this.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 3));
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
