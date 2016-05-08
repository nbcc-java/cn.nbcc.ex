package cn.nbcc.ex20.ch04.task02;

public class App {

	public static void main(String[] args) {
		CourseSession cs = new CourseSession("160001", "Java程序设计");
		cs.enroll(new Student("001","张三"));
		cs.enroll(new Student("002","李四"));
		cs.enroll(new Student("003","王五"));
		cs.enroll(new Student("004","赵六"));
		Exam ex = new Exam(cs,new Room("9#207",5), "15计算机A");
		System.out.println(ex.getSeatSheet());

	}

}
