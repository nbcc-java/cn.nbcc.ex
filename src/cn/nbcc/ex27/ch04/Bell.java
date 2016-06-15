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
		System.out.println("������~~~");
		notifyAllListeners();
	}

	/**
	 * �������м������б�֪ͨ���еļ����ˣ������ü����˵���Ӧ�¼�
	 */
	private void notifyAllListeners() {
		
		for (BellListener bellListener : listenerList) {
			bellListener.onBellRang();
		}
		
	}

}
