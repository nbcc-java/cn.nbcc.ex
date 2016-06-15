package cn.nbcc.ex11.ch02;

import java.util.Timer;
import java.util.TimerTask;

public abstract class TrafficLamp2 {
	
	abstract TrafficLamp2 nextLamp();
	
	public final static TrafficLamp2 RED = new TrafficLamp2() {
		@Override
		TrafficLamp2 nextLamp() {
			return GREEN;
		}
	};
	public final static TrafficLamp2 GREEN = new TrafficLamp2() {
		@Override
		TrafficLamp2 nextLamp() {
			return YELLOW;
		}
	};
	public final static TrafficLamp2 YELLOW = new TrafficLamp2() {
		@Override
		TrafficLamp2 nextLamp() {
			return RED;
		}
	};
	
	@Override
	public String toString() {
		if (this==RED) {
			return "RED";
		}
		if (this==YELLOW) {
			return "YELLOW";
		}
		if(this==GREEN){
			return "GREEN";
		}
		return super.toString();
	}
	
	static class MyTask extends TimerTask{
		
		TrafficLamp2 curLamp = TrafficLamp2.RED;
		
		@Override
		public void run() {
			curLamp = curLamp.nextLamp();
			System.out.println(curLamp.toString());
		}
	}
	public static void main(String[] args) {
		Timer timer = new Timer();
		TimerTask task = new MyTask();
		timer.schedule(task, 0,1000);
	}

}
