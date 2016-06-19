package cn.nbcc.ex29.ch09;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

public class GlassWindow extends Composite implements IStatusChangeListener,PaintListener{

	private static final Color COLOR_DEFAULT = Display.getDefault().getSystemColor(SWT.COLOR_GRAY);
	private static final Color COLOR_RUNNING = Display.getDefault().getSystemColor(SWT.COLOR_YELLOW);
	private static final Image image = ImageDescriptor.createFromFile(GlassWindow.class, "asserts/pic01.jpg").createImage();

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public GlassWindow(Composite parent, int style) {
		super(parent, style);
		this.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 3));
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	@Override
	public void onStatusChange(MicrowaveOven oven) {
		switch (oven.getStatus()) {
		case RUNNING:
			setBackground(COLOR_RUNNING);
			break;
		case FINISHED:
			this.addPaintListener(this);
			setBackground(COLOR_DEFAULT);
			break;
		default:
			this.removePaintListener(this);
			setBackground(COLOR_DEFAULT);
			break;
		}
		redraw();
	}

	/**
	 * 监听绘制操作
	 */
	@Override
	public void paintControl(PaintEvent e) {
		GC gc = e.gc;
		//获取图片的宽度和高度
		int pWidth = image.getBounds().width;
		int pHight = image.getBounds().height;
		//获取容器的宽度和高度
		int cWidth = GlassWindow.this.getBounds().width;
		int cHight = GlassWindow.this.getBounds().height;
		//在容器中间绘制图片
		gc.drawImage(image, (cWidth-pWidth)/2, (cHight-pHight)/2);
	}

}
