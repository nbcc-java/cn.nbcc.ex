package cn.nbcc.ex27.ch04;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class TimeApp {

	protected Shell shell;
	private Text text;
	private Label lblPassword;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TimeApp window = new TimeApp();
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
		shell.setSize(450, 134);
		shell.setText("SWT Application");
		shell.setLayout(new FormLayout());
		
		Label lblName = new Label(shell, SWT.NONE);
		FormData fd_lblName = new FormData();
		fd_lblName.top = new FormAttachment(0, 10);
		fd_lblName.left = new FormAttachment(0, 50);
		lblName.setLayoutData(fd_lblName);
		lblName.setText("name:");
		
		text = new Text(shell, SWT.BORDER);
		FormData fd_text = new FormData();
		fd_text.right = new FormAttachment(100, -10);
		fd_text.left = new FormAttachment(lblName, 6);
		fd_text.top = new FormAttachment(0, 10);
		text.setLayoutData(fd_text);
		
		lblPassword = new Label(shell, SWT.NONE);
		FormData fd_lblPassword = new FormData();
		fd_lblPassword.right = new FormAttachment(lblName, 0, SWT.RIGHT);
		fd_lblPassword.top = new FormAttachment(text, 10);
		lblPassword.setLayoutData(fd_lblPassword);
		lblPassword.setText("password:");
		
		text_1 = new Text(shell, SWT.BORDER);
		FormData fd_text_1 = new FormData();
		fd_text_1.left = new FormAttachment(text, 0,SWT.LEFT);
		fd_text_1.top = new FormAttachment(text, 7);
		fd_text_1.right = new FormAttachment(100, -10);
		text_1.setLayoutData(fd_text_1);

	}
}
