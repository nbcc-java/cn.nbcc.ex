package cn.nbcc.ex29.ch09;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

public class GlassWindow extends Composite implements IStatusChangeListener{

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

	@Override
	public void onStatusChange(MicrowaveOven oven) {
		if (oven.getStatus()==MicrowaveOvenStatus.RUNNING) {
			setBackground(Display.getDefault().getSystemColor(SWT.COLOR_YELLOW));
		}else
			setBackground(Display.getDefault().getSystemColor(SWT.COLOR_GRAY));
	}

}
