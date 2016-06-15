package cn.nbcc.ex26.ch05;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.jface.action.Action;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;

public class GuessGame extends ApplicationWindow {
	private Action action;
	private Action action_1;
	private Text text;
	private Text text_1;

	/**
	 * Create the application window.
	 */
	public GuessGame() {
		super(null);
		createActions();
		addToolBar(SWT.FLAT | SWT.WRAP);
		addMenuBar();
		addStatusLine();
	}

	/**
	 * Create contents of the application window.
	 * @param parent
	 */
	@Override
	protected Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(3, false));
		{
			Label lblNewLabel = new Label(container, SWT.NONE);
			lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			lblNewLabel.setText("\u8F93\u5165\u65B0\u4EF7\u683C:");
		}
		{
			text = new Text(container, SWT.BORDER);
			text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		}
		{
			Button button = new Button(container, SWT.NONE);
			GridData gd_button = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
			gd_button.widthHint = 67;
			button.setLayoutData(gd_button);
			button.setText("\u786E\u5B9A");
		}
		{
			text_1 = new Text(container, SWT.BORDER);
			text_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		}

		return container;
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
		{
			action = new Action("\u65B0\u6E38\u620F") {
			};
			action.setAccelerator(SWT.CTRL | 'N');
			action.setImageDescriptor(ResourceManager.getImageDescriptor(GuessGame.class, "/images/etool16/newjworkingSet_wiz.gif"));
		}
		{
			action_1 = new Action("\u53C2\u6570\u914D\u7F6E") {
			};
			action_1.setAccelerator(SWT.CTRL | SWT.SHIFT | 'C');
			action_1.setImageDescriptor(ResourceManager.getImageDescriptor(GuessGame.class, "/images/etool16/segment_edit.gif"));
		}
	}

	/**
	 * Create the menu manager.
	 * @return the menu manager
	 */
	@Override
	protected MenuManager createMenuManager() {
		MenuManager menuManager = new MenuManager("menu");
		{
			MenuManager menuManager_1 = new MenuManager("\u64CD\u4F5C");
			menuManager.add(menuManager_1);
			menuManager_1.add(action);
			menuManager_1.add(action_1);
		}
		return menuManager;
	}

	/**
	 * Create the toolbar manager.
	 * @return the toolbar manager
	 */
	@Override
	protected ToolBarManager createToolBarManager(int style) {
		ToolBarManager toolBarManager = new ToolBarManager(style);
		toolBarManager.add(action);
		toolBarManager.add(action_1);
		return toolBarManager;
	}

	/**
	 * Create the status line manager.
	 * @return the status line manager
	 */
	@Override
	protected StatusLineManager createStatusLineManager() {
		StatusLineManager statusLineManager = new StatusLineManager();
		return statusLineManager;
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			GuessGame window = new GuessGame();
			window.setBlockOnOpen(true);
			window.open();
			Display.getCurrent().dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Configure the shell.
	 * @param newShell
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("New Application");
	}

	/**
	 * Return the initial size of the window.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(224, 300);
	}

}
