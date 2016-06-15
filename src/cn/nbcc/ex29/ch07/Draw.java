package cn.nbcc.ex29.ch07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.util.ArrayList;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.internal.forms.widgets.IFocusSelectable;

public class Draw {

	protected Shell shell;
	private Button curSelect=null;							//当前选择
	protected Point dPoint;									//起始点
	protected Point uPoint;									//结束点
	protected boolean isDrawing;							//当前是否是绘制状态
	private ArrayList<Graphic> graphics = new ArrayList<>();//所有图形
	private Button lineItem;								//按钮线
	private Button circleItem;								//按钮圆
	private Button btnSave;
	private Button btnLoad;
	Graphic newGraphic = null;
	
	static abstract  class Graphic implements Serializable{
		private static final long serialVersionUID = 1L;
		int x1,y1,x2,y2; //起始，结束位置
		int r,g,b; //颜色值
		abstract void draw(GC gc );//定义绘图函数
		public void setEndPoint(Point uPoint) {
			this.x2 = uPoint.x;
			this.y2 = uPoint.y;
		}
	}
	static class Line extends Graphic{
		public Line(Point dPoint, Point uPoint) {
			this.x1 = dPoint.x;
			this.y1 = dPoint.y;
			this.x2 = uPoint.x;
			this.y2 = uPoint.y;
		}

		void draw(GC gc) {
			gc.setBackground(new Color(Display.getDefault(),r, g, b));// 为 Graphics2D 上下文设置 Paint 属性。
			gc.drawLine(x1, y1, x2, y2);// 画直线
		}
	}
	static class Circle extends Graphic{

		public Circle(Point dPoint, Point uPoint) {
			this.x1 = dPoint.x;
			this.y1 = dPoint.y;
			this.x2 = uPoint.x;
			this.y2 = uPoint.y;
		}

		@Override
		void draw(GC gc) {
			gc.setBackground(new Color(Display.getDefault(),r,g,b));
			gc.drawOval(Math.min(x1, x2),Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
		}
	}
	

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Draw window = new Draw();
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
		shell.setSize(493, 300);
		shell.setText("绘图");
		shell.setLayout(new GridLayout(2, false));
		
		final Canvas canvas = new Canvas(shell, SWT.BORDER|SWT.DOUBLE_BUFFERED|SWT.NO_BACKGROUND);
		canvas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if (curSelect!=null) {
					dPoint = new Point(e.x, e.y);
					isDrawing = true;
					if (curSelect==lineItem) {
						newGraphic = new Line(dPoint,dPoint);
					}else {
						newGraphic = new Circle(dPoint,dPoint);
					}
					graphics.add(newGraphic);
					System.out.println("Mouse Down:"+e);
				}
			}
			@Override
			public void mouseUp(MouseEvent e) {
				if (curSelect!=null) {
					uPoint = new Point(e.x, e.y);
					newGraphic.setEndPoint(uPoint);
					if (!graphics.contains(newGraphic)) {
						graphics.add(newGraphic);
					}
					isDrawing = false;
					System.out.println("Mouse Up:"+e);
				}
			}
		});
		canvas.addMouseMoveListener(new MouseMoveListener() {
			@Override
			public void mouseMove(MouseEvent e) {
				if (isDrawing) {
					newGraphic.setEndPoint(new Point(e.x,e.y));
					canvas.redraw();
				}
			}
		});
		canvas.addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent e) {
				
				Image bufferScreen = new Image(null,shell.getClientArea());
				GC gImage = new GC(bufferScreen);
				gImage.setBackground(canvas.getBackground());
				gImage.fillRectangle(canvas.getClientArea());
				
				//遍历图形列表，绘制每个图形
				for (Graphic g : graphics) {
					g.draw(gImage);
				}
				gImage.setBackground(canvas.getBackground());
				String title=String.format("当前有 %02d个图形!", graphics.size());
				gImage.drawText(title, 10, 10);
				e.gc.drawImage(bufferScreen, 0, 0);
				System.out.println(title);
				if(!bufferScreen.isDisposed())
				{
					bufferScreen.dispose();
					bufferScreen=null;
				}
				if(!gImage.isDisposed())
				{
					gImage.dispose();
					gImage=null;
				}
			}
		});
		
		canvas.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 3));
		
		Composite composite = new Composite(shell, SWT.NONE);
		GridData gd_composite = new GridData(SWT.LEFT, SWT.FILL, false, true, 1, 1);
		gd_composite.widthHint = 57;
		composite.setLayoutData(gd_composite);
		RowLayout rl_composite = new RowLayout(SWT.VERTICAL);
		rl_composite.fill = true;
		composite.setLayout(rl_composite);
		
		lineItem = new Button(composite, SWT.TOGGLE);
		lineItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (curSelect!=lineItem) {
					curSelect = lineItem;
				}else
					curSelect=null;
				System.out.println("Cur Select:"+curSelect);
			}
		});
		lineItem.setText("Line");
		circleItem = new Button(composite, SWT.TOGGLE);
		circleItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (curSelect!=circleItem) {
					curSelect = circleItem;
				}else
					curSelect=null;
				System.out.println("Cur Select:"+curSelect);
			}
		});
		circleItem.setText("Circle");
		
		btnSave = new Button(shell, SWT.NONE);
		btnSave.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnSave.setText("Save");
		btnSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				saveToFile(graphics);
			}
		});
		
		btnLoad = new Button(shell, SWT.NONE);
		btnLoad.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				readFromFile();
			}
		});
		btnLoad.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnLoad.setText("Load");

	}
	
	/**
	 * TODO:请完成从文件中读取对象
	 */

	@SuppressWarnings("unchecked")
	protected void readFromFile() {
		String filePath = new FileDialog(shell,SWT.OPEN).open();
		try(FileInputStream fileInputStream =new FileInputStream(filePath);
			ObjectInputStream objectInputStream =new ObjectInputStream(fileInputStream)) {
			ArrayList<Draw.Graphic> readObject = (ArrayList<Draw.Graphic>)objectInputStream.readObject();
			graphics = readObject;
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * TODO:将图形保存到文件中
	 * @param graphics
	 */
	protected void saveToFile(ArrayList<Graphic> graphics) {
		String filePath = new FileDialog(shell, SWT.SAVE).open();
		ObjectOutputStream objectOutputStream=null;
		FileOutputStream fileOutputStream=null;
		try {
			fileOutputStream = new FileOutputStream(filePath);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(graphics);
			MessageDialog.openInformation(shell, "消息", "文件保存成功！");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if (objectOutputStream!=null) {
					objectOutputStream.close();
				}
				if (fileOutputStream!=null) {
					fileOutputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
}
