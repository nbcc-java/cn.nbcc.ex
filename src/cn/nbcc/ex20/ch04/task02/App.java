package cn.nbcc.ex20.ch04.task02;

public class App {

	public static void main(String[] args) {
		CourseSession cs = new CourseSession("160001", "Java�������");
		cs.enroll(new Student("001","����"));
		cs.enroll(new Student("002","����"));
		cs.enroll(new Student("003","����"));
		cs.enroll(new Student("004","����"));
		Exam ex = new Exam(cs,new Room("9#207",5), "15�����A");
		System.out.println(ex.getSeatSheet());

	}

}
