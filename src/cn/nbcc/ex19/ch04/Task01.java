package cn.nbcc.ex19.ch04;
public class Task01 {
	static class Person{
		String name;
		Person(String name){
			this.name = name;
		}
		public void speak(){}
		public void eat(){}
	}
	static class American extends Person{
		public American(String name) {
			super(name);
		}
		@Override
		public void speak() {
			System.out.println(name+"speak american english!");
		}
		@Override
		public void eat() {
			System.out.println(name+"eat food using forks and knivies");
		}
	}
	static class Chinese extends Person{
		public Chinese(String name){
			super(name);
		}
		@Override
		public void speak() {
			System.out.println(name+"˵����!");
		}
		@Override
		public void eat() {
			System.out.println(name+"�ÿ��ӳԶ���");
		}
	}
	
	public static void main(String[] args) {
		American a = new American("Michael");
		Chinese c = new Chinese("����");
		a.speak();
		a.eat();
		c.speak();
		c.eat();
	}
}
