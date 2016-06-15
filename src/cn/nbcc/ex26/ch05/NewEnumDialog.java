package cn.nbcc.ex26.ch05;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.wb.swt.SWTResourceManager;

public class NewEnumDialog extends TitleAreaDialog {
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public NewEnumDialog(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setTitleImage(SWTResourceManager.getImage(NewEnumDialog.class, "/images/exp_deployplug_wiz.png"));
		setMessage("\u521B\u5EFA\u65B0\u7684\u679A\u4E3E\u7C7B\u578B");
		setTitle("\u679A\u4E3E\u7C7B\u578B");
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(4, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText("\u6E90\u6587\u4EF6\u5939(&D)");
		
		text = new Text(container, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Button btnNewButton = new Button(container, SWT.NONE);
		GridData gd_btnNewButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnNewButton.widthHint = 83;
		btnNewButton.setLayoutData(gd_btnNewButton);
		btnNewButton.setText("\u6D4F\u89C8(&O)...");
		
		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		lblNewLabel_1.setText("\u5305(K):");
		
		text_1 = new Text(container, SWT.BORDER);
		text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblNewLabel_2 = new Label(container, SWT.NONE);
		lblNewLabel_2.setText("(\u7F3A\u7701\u503C)");
		
		Button btnNewButton_1 = new Button(container, SWT.NONE);
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnNewButton_1.setText("\u6D4F\u89C8(&W)...");
		
		Button btny = new Button(container, SWT.CHECK);
		btny.setText("\u5916\u5C42\u7C7B\u578B(&Y):");
		
		text_2 = new Text(container, SWT.BORDER);
		text_2.setEnabled(false);
		text_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Button btnw = new Button(container, SWT.NONE);
		btnw.setEnabled(false);
		btnw.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnw.setText("\u6D4F\u89C8(W)...");
		
		Label lblNewLabel_3 = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		lblNewLabel_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
		lblNewLabel_3.setText("New Label");
		
		Label lblm = new Label(container, SWT.NONE);
		lblm.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblm.setText("\u540D\u79F0(&M):");
		
		text_3 = new Text(container, SWT.BORDER);
		text_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		new Label(container, SWT.NONE);
		
		Label label = new Label(container, SWT.NONE);
		label.setText("\u4FEE\u9970\u7B26:");
		
		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayout(new RowLayout(SWT.HORIZONTAL));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		
		Button btnRadioButton = new Button(composite, SWT.RADIO);
		btnRadioButton.setSelection(true);
		btnRadioButton.setText("\u516C\u7528(P)");
		
		Button btnRadioButton_1 = new Button(composite, SWT.RADIO);
		btnRadioButton_1.setText("\u7F3A\u7701(&U)");
		
		Button btnRadioButton_2 = new Button(composite, SWT.RADIO);
		btnRadioButton_2.setEnabled(false);
		btnRadioButton_2.setText("\u79C1\u6709(V)");
		
		Button btnRadioButton_3 = new Button(composite, SWT.RADIO);
		btnRadioButton_3.setEnabled(false);
		btnRadioButton_3.setText("\u53D7\u4FDD\u62A4(T)");
		new Label(container, SWT.NONE);
		
		Label lblNewLabel_4 = new Label(container, SWT.NONE);
		lblNewLabel_4.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_4.setText("\u63A5\u53E3(T):");
		
		text_4 = new Text(container, SWT.BORDER);
		text_4.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 2));
		
		Button btnNewButton_2 = new Button(container, SWT.NONE);
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnNewButton_2.setText("\u6DFB\u52A0");
		new Label(container, SWT.NONE);
		
		Button btnNewButton_3 = new Button(container, SWT.NONE);
		btnNewButton_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnNewButton_3.setText("\u5220\u9664");
		
		Label lblNewLabel_5 = new Label(container, SWT.NONE);
		lblNewLabel_5.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		lblNewLabel_5.setText("\u8981\u6DFB\u52A0\u6CE8\u91CA\u5417\uFF1F\uFF08\u5728\u6B64\u5904\u914D\u7F6E\u6A21\u677F\u548C\u7F3A\u7701\u503C\uFF09");
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Button button = new Button(container, SWT.CHECK);
		button.setText("\u751F\u6210\u6CE8\u91CA");
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);

		return area;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(465, 448);
	}

}
