package cn.nbcc.ex11.ch02;

public class TrafficLamp {
	
	String color = "RED";
	
	public void nextLamp() {
		
		if (color=="RED") {
			color = "GREEN";
		}else if(color=="GREEN"){
			color = "YELLOW";
		}else {
			color = "RED";
		}

	}
	@Override
	public String toString() {
		return color;
	}
}
