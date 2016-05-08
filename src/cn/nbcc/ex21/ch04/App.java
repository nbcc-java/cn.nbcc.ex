package cn.nbcc.ex21.ch04;

import cn.nbcc.ex21.ch04.Student.Grade;



public class App {

	public static void main(String[] args) {
		Student s = new Student("153030108", "张三");
//		s.setGradingStrategy(new RegularGradingStrategy());
		s.setGradingStrategy(new HornorsGradingStrategy());
		
		s.setGradingStrategy(new BasicGradeStrategy() {
			@Override
			public int getGradePointsFor(Grade grade) {
				return 1;
			}
		});
//		s.setGradingStrategy(new EliteGradingStrategy());
		s.addGrade(Grade.C);//1
		s.addGrade(Grade.D);//1
		System.out.println("平均成绩"+s.getGPA());
	}

}
