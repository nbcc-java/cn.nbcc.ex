package cn.nbcc.ex16.ch04;

import cn.nbcc.ex16.ch04.Student.Grade;


public class App {

	public static void main(String[] args) {
		Student s = new Student("153030108", "dlz");
		s.login();
		s.addGrade(Grade.A);
		s.addGrade(Grade.B);
		System.out.println("平均成绩"+s.getGPA());
		Teacher t=new Teacher("001","王老师");
		t.login();
	}

}
