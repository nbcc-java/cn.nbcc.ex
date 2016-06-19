package cn.nbcc.ex29.ch09;

import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.swt.widgets.Display;

public class CookTimer {
	private int minute;
	private int second;
	private Timer timer;
	private MicrowaveOven oven;
	
	public CookTimer(String tStr, MicrowaveOven oven) {
		String tokens[] = tStr.split(":");
		minute = Integer.parseInt(tokens[0]);
		second = Integer.parseInt(tokens[1]);
		this.oven = oven;
	}
	

	public void start() {
		timer = new Timer();
		//每隔1秒调用TimerTask任务
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				//倒计时1秒
				tick();
				//异步更新显示信息
				Display.getDefault().asyncExec(new Runnable() {
					@Override
					public void run() {
						oven.setTimeString(String.format("%02d", minute)+":"+String.format("%02d", second));
						//如果计时完成，则修改微波炉状态
						if (isDone()) {
							stop();
							oven.setStatus(MicrowaveOvenStatus.FINISHED);
						}
						oven.fireStatusChange();
					}
				});
			}
		}, 0,1000);
	}

	/**
	 * 判断计时器是否完成
	 * @return
	 */
	protected boolean isDone() {
		return minute==0 && second==0?true:false;
	}


	/**
	 * 滴答1秒，减少1秒
	 */
	protected void tick() {
		second = (second-1+60)%60;
		if (second==59) {
			minute = minute-1;
		}
	}


	/**
	 * 停止计时器
	 */
	public void stop() {
		timer.cancel();
	}
	

}
