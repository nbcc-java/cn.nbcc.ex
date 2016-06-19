package cn.nbcc.ex29.ch09;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class ControlPanel extends Composite implements IStatusChangeListener{

	private Button btnStart;
	private Button btnClear;
	private MicrowaveOven oven;
	protected CookTimer cookTimer;

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
		btnStart.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//���������߳�
				cookTimer = new CookTimer(oven.getTimeString(),oven);
				cookTimer.start();
				oven.setStatus(MicrowaveOvenStatus.RUNNING);
				oven.fireStatusChange();
			}
		});
		btnStart.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		btnStart.setBounds(0, 0, 80, 27);
		btnStart.setText("Start");
		
		btnClear = new Button(this, SWT.NONE);
		btnClear.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		btnClear.setBounds(0, 0, 80, 27);
		btnClear.setText("Clear");
		btnClear.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (btnClear.getText().equals("Clear")) {
					oven.clear();
					btnStart.setEnabled(false);
				}else {
					boolean isConfirm = MessageDialog.openConfirm(oven.shell, "ȷ��", "���Ҫȡ��������?");
					if (isConfirm) {
						//ֹͣ�����߳�
						cookTimer.stop();
						oven.setStatus(MicrowaveOvenStatus.CANCEL);
						oven.fireStatusChange();
					}
				}
			}
		});
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
			btnClear.setEnabled(true);
			break;
		case RUNNING:
			btnStart.setEnabled(false);
			btnClear.setText("Stop");
			break;

		default:
			btnStart.setEnabled(false);
			btnClear.setEnabled(false);
			btnClear.setText("Clear");
			break;
		}
	}

	/**
	 * �����û�ָ����״̬�����ÿ�ʼ��ť�Ƿ�����
	 * @param isValid
	 */
	public void setStartButtonEnabled(boolean isValid) {
		btnStart.setEnabled(isValid);
	}

}
