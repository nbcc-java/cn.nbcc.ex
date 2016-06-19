package cn.nbcc.ex29.ch09;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class DisplayPanel extends Composite implements IStatusChangeListener{

	private Label msgLabel;
	private String message;
	private static final String WELCOME_MESSAGE = "欢迎使用微波炉程序";
	private static final String CANCEL_MESSAGE = "操作已成功取消";
	private static final String FINISHED_MESSAGE = "烹煮完成，请取出";
	private static final String DEFAULT_TIME_MESSAGE = "00:00";
	private String timeString = DEFAULT_TIME_MESSAGE;			//当前显示时间字符串
	

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public DisplayPanel(Composite parent, int style) {
		super(parent, style);
		this.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		FillLayout fillLayout = new FillLayout(SWT.HORIZONTAL);
		fillLayout.marginHeight = 10;
		fillLayout.marginWidth = 5;
		this.setLayout(fillLayout);
		
		msgLabel = new Label(this, SWT.NONE);
		msgLabel.setAlignment(SWT.CENTER);
//		msgLabel.setText("\u6B22\u8FCE\u4F7F\u7528\u5FAE\u6CE2\u7089");
		msgLabel.setText(WELCOME_MESSAGE);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	@Override
	public void onStatusChange(MicrowaveOven oven) {
		switch (oven.getStatus()) {
		case UNSETTING:
			message = WELCOME_MESSAGE;
			break;
		case SETTING:
		case RUNNING:
			message = timeString;
			break;
		case CANCEL:
			message = CANCEL_MESSAGE;
			timeString = DEFAULT_TIME_MESSAGE;
			break;
		case FINISHED:
			message = FINISHED_MESSAGE;
			break;
		default:
			break;
		}
		msgLabel.setText(message);
	}

	/**
	 * 根据用户按下的数字键，检查用户设定时间是否有效
	 * @param addedDigit
	 * @return
	 */
	public boolean isValid(String addedDigit) {
		addDigit(addedDigit);//追加新数字，更新timeString
		String tokens[]= timeString.split(":");
		int m = Integer.parseInt(tokens[0]);
		int s = Integer.parseInt(tokens[1]);
		
		return m>=0&&m<60 &&s>=0&&s<60;
	}

	/**
	 * 追加新数字，更新timeString
	 * @param addedDigit
	 */
	private void addDigit(String addedDigit) {
		String tokens[] = timeString.split(":");
		StringBuilder sb = new StringBuilder();
		timeString = sb.append(tokens[0]).append(tokens[1]).append(addedDigit).insert(3, ":").substring(1);
	}

	/**
	 * 重置时间
	 */
	public void clear() {
		timeString = DEFAULT_TIME_MESSAGE;
		setTimeString(timeString);
	}

	/**
	 * 根据用户指定时间设置timeString，并显示在标签中
	 * @param tStr
	 */
	public void setTimeString(String tStr) {
		this.timeString = tStr;
		msgLabel.setText(timeString);
	}

	/**
	 * 获取时间字符串
	 * @return
	 */
	public String getTimeString() {
		return timeString;
	}

}
