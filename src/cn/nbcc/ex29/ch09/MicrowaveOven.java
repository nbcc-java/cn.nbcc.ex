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
import org.jsoup.select.Evaluator.IsEmpty;

public class MicrowaveOven {

	protected Shell shell;
	private GlassWindow glassWindow;
	private DisplayPanel displayPanel;
	private KeyboardPanel keyboardPanel;
	private ControlPanel controlPanel;
	private ArrayList<IStatusChangeListener> listeners = new ArrayList<>();
	private MicrowaveOvenStatus status;
	

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
		init();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * 在打开程序之前，创建界面控件之后，执行初始化工作
	 */
	private void init() {
		addStatusChangeListener(glassWindow);
		addStatusChangeListener(keyboardPanel);
		addStatusChangeListener(displayPanel);
		addStatusChangeListener(controlPanel);
		
		
		setStatus(MicrowaveOvenStatus.UNSETTING);
		fireStatusChange();
		
	}

	/**
	 * 通知监听人，状态发生变化，并调用监听人的相应方法
	 */
	public void fireStatusChange() {
		for (IStatusChangeListener listener : listeners) {
			listener.onStatusChange(this);
		}
		
	}

	/**
	 * 设置微波炉状态
	 * @param unsetting
	 */
	public void setStatus(MicrowaveOvenStatus newStatus) {
		this.status = newStatus;
	}

	/**
	 * 注册监听
	 * @param listener
	 */
	private void addStatusChangeListener(IStatusChangeListener listener) {
		if (!listeners.contains(listener)) {
			listeners.add(listener);
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

	/**
	 * 返回微波炉状态
	 * @return
	 */
	public MicrowaveOvenStatus getStatus() {
		return status;
	}

	/**
	 * 根据用户按下数字键检查设定时间是否有效
	 * @param addedDigit
	 */
	public void checkValid(String addedDigit) {
		boolean isValid = displayPanel.isValid(addedDigit);
		controlPanel.setStartButtonEnabled(isValid);
	}

	/**
	 * 通知显示面板，重置时间
	 */
	public void clear() {
		displayPanel.clear();
	}

	/**
	 * 获取用户设定的时间字符串
	 * @return
	 */
	public String getTimeString() {
		return displayPanel.getTimeString();
	}

	/**
	 * 更新显示面板的时间信息
	 * @param string
	 */
	public void setTimeString(String timeString) {
		displayPanel.setTimeString(timeString);
	}

}
