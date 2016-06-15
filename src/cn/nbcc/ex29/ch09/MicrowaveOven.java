package cn.nbcc.ex29.ch09;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;

public class MicrowaveOven {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MicrowaveOven window = new MicrowaveOven();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(587, 300);
		shell.setText("SWT Application");
		shell.setLayout(new GridLayout(2, false));
		
		Composite glassWindow = new Composite(shell, SWT.BORDER);
		glassWindow.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 3));
		
		Composite displayPanel = new Composite(shell, SWT.BORDER);
		displayPanel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		FillLayout fl_displayPanel = new FillLayout(SWT.HORIZONTAL);
		fl_displayPanel.marginHeight = 10;
		fl_displayPanel.marginWidth = 5;
		displayPanel.setLayout(fl_displayPanel);
		
		Label msgLabel = new Label(displayPanel, SWT.NONE);
		msgLabel.setAlignment(SWT.CENTER);
		msgLabel.setText("\u6B22\u8FCE\u4F7F\u7528\u5FAE\u6CE2\u7089");
		
		Composite keyboardPanel = new Composite(shell, SWT.BORDER);
		GridData gd_keyboardPanel = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 1);
		gd_keyboardPanel.widthHint = 146;
		keyboardPanel.setLayoutData(gd_keyboardPanel);
		keyboardPanel.setLayout(new GridLayout(3, false));
		
		Button btnNewButton = new Button(keyboardPanel, SWT.NONE);
		btnNewButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		btnNewButton.setBounds(0, 0, 80, 27);
		btnNewButton.setText("1");
		
		Button button = new Button(keyboardPanel, SWT.NONE);
		button.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		button.setText("1");
		
		Button button_1 = new Button(keyboardPanel, SWT.NONE);
		button_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		button_1.setText("1");
		
		Button button_2 = new Button(keyboardPanel, SWT.NONE);
		button_2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		button_2.setText("1");
		
		Button button_3 = new Button(keyboardPanel, SWT.NONE);
		button_3.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		button_3.setText("1");
		
		Button button_4 = new Button(keyboardPanel, SWT.NONE);
		button_4.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		button_4.setText("1");
		
		Button button_5 = new Button(keyboardPanel, SWT.NONE);
		button_5.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		button_5.setText("1");
		
		Button button_6 = new Button(keyboardPanel, SWT.NONE);
		button_6.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		button_6.setText("1");
		
		Button button_7 = new Button(keyboardPanel, SWT.NONE);
		button_7.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		button_7.setText("1");
		
		Button button_8 = new Button(keyboardPanel, SWT.NONE);
		button_8.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		button_8.setText("1");
		new Label(keyboardPanel, SWT.NONE);
		new Label(keyboardPanel, SWT.NONE);
		
		Composite controlPanel = new Composite(shell, SWT.BORDER);
		controlPanel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		controlPanel.setLayout(new GridLayout(2, false));
		
		Button btnStart = new Button(controlPanel, SWT.NONE);
		btnStart.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		btnStart.setBounds(0, 0, 80, 27);
		btnStart.setText("Start");
		
		Button btnNewButton_1 = new Button(controlPanel, SWT.NONE);
		btnNewButton_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		btnNewButton_1.setBounds(0, 0, 80, 27);
		btnNewButton_1.setText("Clear");

	}

}
