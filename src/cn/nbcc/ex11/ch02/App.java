package cn.nbcc.ex11.ch02;

public class App {

	public static void main(String[] args) {
		
		TrafficLamp lamp = new TrafficLamp();
		System.out.println(lamp.toString());
		
		lamp.nextLamp();
		System.out.println(lamp.toString());
		
		lamp.nextLamp();
		System.out.println(lamp.toString());
		
		lamp.nextLamp();
		System.out.println(lamp.toString());

	}

}
