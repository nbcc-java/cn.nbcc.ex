package cn.nbcc.ex19.ch04;

public class Task02 {
	
	static class Point{
		int x,y;
		Point(int x,int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return String.format("[x=%d,y=%d]", x,y);
		}
	}
	static class Circle extends Point{
		private int r;

		Circle(int x,int y,int r){
			super(x,y);
			this.r = r;
		}
		public double getPerimeter() {
			return Math.PI*2*r;
		}
		public double getArea(){
			return Math.PI*r*r;
		}
		@Override
		public String toString() {
			return String.format("%s,r=%d,area=%.2f,peri=%.2f", super.toString(),r,getArea(),getPerimeter());
		}
	}
	static class Cylinder extends Circle{
		int height;
		Cylinder(Circle circle,int height){
			super(circle.x,circle.y,circle.r);
			this.height=height;
		}
		public double getVolumn() {
			return getArea()*height;
		}
		@Override
		public String toString() {
			return String.format("%s h=%d vol=%.2f", super.toString(),height,getVolumn());
		}
	}

	public static void main(String[] args) {
		Point a = new Point(10, 20);
		Circle b = new Circle(0, 0, 1);
		Cylinder c = new Cylinder(new Circle(0,0,1), 10);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}

}
