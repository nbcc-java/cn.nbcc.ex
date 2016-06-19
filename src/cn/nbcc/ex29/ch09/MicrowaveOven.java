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
	 * �ڴ򿪳���֮ǰ����������ؼ�֮��ִ�г�ʼ������
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
	 * ֪ͨ�����ˣ�״̬�����仯�������ü����˵���Ӧ����
	 */
	public void fireStatusChange() {
		for (IStatusChangeListener listener : listeners) {
			listener.onStatusChange(this);
		}
		
	}

	/**
	 * ����΢��¯״̬
	 * @param unsetting
	 */
	public void setStatus(MicrowaveOvenStatus newStatus) {
		this.status = newStatus;
	}

	/**
	 * ע�����
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
	 * ����΢��¯״̬
	 * @return
	 */
	public MicrowaveOvenStatus getStatus() {
		return status;
	}

	/**
	 * �����û��������ּ�����趨ʱ���Ƿ���Ч
	 * @param addedDigit
	 */
	public void checkValid(String addedDigit) {
		boolean isValid = displayPanel.isValid(addedDigit);
		controlPanel.setStartButtonEnabled(isValid);
	}

	/**
	 * ֪ͨ��ʾ��壬����ʱ��
	 */
	public void clear() {
		displayPanel.clear();
	}

	/**
	 * ��ȡ�û��趨��ʱ���ַ���
	 * @return
	 */
	public String getTimeString() {
		return displayPanel.getTimeString();
	}

	/**
	 * ������ʾ����ʱ����Ϣ
	 * @param string
	 */
	public void setTimeString(String timeString) {
		displayPanel.setTimeString(timeString);
	}

}
