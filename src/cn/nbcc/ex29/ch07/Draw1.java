package cn.nbcc.ex29.ch07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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
import org.eclipse.swt.widgets.DirectoryDialog;
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

public class Draw1 {

	protected Shell shell;
	private Button curSelect=null;							//��ǰѡ��
	protected Point dPoint;									//��ʼ��
	protected Point uPoint;									//������
	protected boolean isDrawing;							//��ǰ�Ƿ��ǻ���״̬
	private ArrayList<Graphic> graphics = new ArrayList<>();//����ͼ��
	private Button lineItem;								//��ť��
	private Button circleItem;								//��ťԲ
	private Button btnSave;
	private Button btnLoad;
	Graphic newGraphic = null;
	private Button btnNewButton;
	
	static abstract  class Graphic implements Serializable{
		private static final long serialVersionUID = 9204332956094332605L;
		int x1,y1,x2,y2; //��ʼ������λ��
		int r,g,b; //��ɫֵ
		abstract void draw(GC gc );//�����ͼ����
		public void setEndPoint(Point uPoint) {
			this.x2 = uPoint.x;
			this.y2 = uPoint.y;
		}
	}
	static class Line extends Graphic{
		private static final long serialVersionUID = 9204332956094332605L;

		public Line(Point dPoint, Point uPoint) {
			this.x1 = dPoint.x;
			this.y1 = dPoint.y;
			this.x2 = uPoint.x;
			this.y2 = uPoint.y;
		}

		void draw(GC gc) {
			gc.setBackground(new Color(Display.getDefault(),r, g, b));// Ϊ Graphics2D ���������� Paint ���ԡ�
			gc.drawLine(x1, y1, x2, y2);// ��ֱ��
		}
	}
	static class Circle extends Graphic{

		private static final long serialVersionUID = 9204332956094332605L;

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
			Draw1 window = new Draw1();
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
		shell.setText("��ͼ");
		shell.setLayout(new GridLayout(4, false));
		
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
//					if (!graphics.contains(newGraphic)) {
//						graphics.add(newGraphic);
//					}
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
				
				//����ͼ���б�����ÿ��ͼ��
				for (Graphic g : graphics) {
					g.draw(gImage);
				}
				gImage.setBackground(canvas.getBackground());
				String title=String.format("��ǰ�� %02d��ͼ��!", graphics.size());
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
		
		canvas.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		
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
		btnSave.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		btnSave.setText("Save");
		btnSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				try {
					saveToFile(graphics);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnLoad = new Button(shell, SWT.NONE);
		btnLoad.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				readFromFile();
				canvas.redraw();
			}
		});
		btnLoad.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		btnLoad.setText("Load");
		
		btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				graphics.clear();
				canvas.redraw();
			}
		});
		btnNewButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		btnNewButton.setText("Clear");
		new Label(shell, SWT.NONE);

	}
	
	/**
	 * TODO:����ɴ��ļ��ж�ȡ����
	 */

	protected void readFromFile() {
		String path = new FileDialog(shell,SWT.OPEN).open();
		if (path!=null) {
			File file = new File(path);
			if (file.exists()) {
				try {
					FileInputStream fileInputStream = new FileInputStream(file);
					ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
					graphics = (ArrayList<Draw1.Graphic>)objectInputStream.readObject();
				} catch (ClassNotFoundException
						| IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * TODO:��ͼ�α��浽�ļ���
	 * @param graphics
	 * @throws IOException 
	 */
	protected void saveToFile(ArrayList<Graphic> graphics) throws IOException {
		
		String path = new FileDialog(shell,SWT.SAVE).open();
		if (path!=null) {
			File file = new File(path);
			if (!file.exists()) 
				file.createNewFile();
			else{
				boolean isConfirm = MessageDialog.openConfirm(shell, "��Ϣ", "Ҫ����Դ������?");
				if (!isConfirm) 
					return ;
			}
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(graphics);
			MessageDialog.openInformation(shell, "��Ϣ", "����ɹ�");
			objectOutputStream.close();
			fileOutputStream.close();
		}
		
		
	}
}
