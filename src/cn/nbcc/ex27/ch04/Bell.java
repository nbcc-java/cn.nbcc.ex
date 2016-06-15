package cn.nbcc.ex27.ch04;

import java.util.ArrayList;

public class Bell {
	
	private ArrayList<BellListener> listenerList = new ArrayList<>();
	
	public void addBellListener(BellListener bellListener) {
		if (!listenerList.contains(bellListener)) {
			listenerList.add(bellListener);
		}
	}
	
	public void removeBellListener(BellListener bellListener) {
		if (listenerList.contains(bellListener)) {
			listenerList.remove(bellListener);
		}
	}
	
	public void ring() {
		System.out.println("叮铃铃~~~");
		notifyAllListeners();
	}

	/**
	 * 遍历所有监听者列表，通知所有的监听人，并调用监听人的响应事件
	 */
	private void notifyAllListeners() {
		
		for (BellListener bellListener : listenerList) {
			bellListener.onBellRang();
		}
		
	}

}
