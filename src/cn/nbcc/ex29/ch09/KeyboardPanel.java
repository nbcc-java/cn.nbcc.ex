package cn.nbcc.ex29.ch09;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class KeyboardPanel extends Composite implements IStatusChangeListener{

	Button buttons[] = new Button[10];
	private MicrowaveOven oven;
	protected String addedDigit;//记录用户按下的数字键
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
			buttons[i]=btn;
			buttons[i].addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					//第一次按下数字键
					if (oven.getStatus()==MicrowaveOvenStatus.UNSETTING||
							oven.getStatus()==MicrowaveOvenStatus.FINISHED||
							oven.getStatus()==MicrowaveOvenStatus.CANCEL) {
						oven.setStatus(MicrowaveOvenStatus.SETTING);
					}
					addedDigit = ((Button)e.getSource()).getText();
					oven.fireStatusChange();
				}
			});
		}
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	@Override
	public void onStatusChange(MicrowaveOven oven) {
		this.oven = oven;
		switch (oven.getStatus()) {
		case SETTING:
			oven.checkValid(addedDigit);
			break;
		case RUNNING:
			enableKeyboard(false);
			break;
		default:
			enableKeyboard(true);
			break;
		}
	}

	/**
	 * 启用和禁用键盘区所有数字键
	 * @param enabled
	 */
	private void enableKeyboard(boolean enabled) {
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].setEnabled(enabled);
		}
	}

}
