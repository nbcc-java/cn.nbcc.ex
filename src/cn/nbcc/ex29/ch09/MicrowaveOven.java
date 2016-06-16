package cn.nbcc.ex29.ch09;

import java.util.ArrayList;

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
	private GlassWindow glassWindow;
	private DisplayPanel displayPanel;
	private KeyboardPanel keyboardPanel;
	private ControlPanel controlPanel;
	

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
		
		
		glassWindow = new GlassWindow(shell, SWT.BORDER);
		displayPanel = new DisplayPanel(shell, SWT.BORDER);
		keyboardPanel = new KeyboardPanel(shell, SWT.BORDER);
		controlPanel = new ControlPanel(shell, SWT.BORDER);

	}

}
