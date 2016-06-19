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
		//ÿ��1�����TimerTask����
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				//����ʱ1��
				tick();
				//�첽������ʾ��Ϣ
				Display.getDefault().asyncExec(new Runnable() {
					@Override
					public void run() {
						oven.setTimeString(String.format("%02d", minute)+":"+String.format("%02d", second));
						//�����ʱ��ɣ����޸�΢��¯״̬
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
	 * �жϼ�ʱ���Ƿ����
	 * @return
	 */
	protected boolean isDone() {
		return minute==0 && second==0?true:false;
	}


	/**
	 * �δ�1�룬����1��
	 */
	protected void tick() {
		second = (second-1+60)%60;
		if (second==59) {
			minute = minute-1;
		}
	}


	/**
	 * ֹͣ��ʱ��
	 */
	public void stop() {
		timer.cancel();
	}
	

}
