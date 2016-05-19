package cn.nbcc.ex23.ch04;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;

import cn.nbcc.ex23.ch04.Task02.Student.Grade;



public class Task02 {
	static class Student{
		ArrayList<Grade> grades = new ArrayList<>();
		private String name;
		
		static enum Grade{
			A(4),B(3),C(2),D(1),F(0);
			private int point;
			private Grade(int point){
				this.point = point;
			}
		}

		public Student(String name) {
			this.name = name;
		}

		public void addGrade(Grade grade) {
			grades.add(grade);
		}
		public Grade getGrade(int index) {
			return grades.get(index);
		}

		public String getName() {
			return name;
		}
	}
	static class ReportCard{
		static final String A_MESSAGE="表现非常完美";
		static final String B_MESSAGE="表现非常好";
		static final String C_MESSAGE="表现还不错哦";
		static final String D_MESSAGE="继续加油";
		static final String F_MESSAGE="需要再试试";
		private Map<Student.Grade, String> messages = null;
		
		public ReportCard() {
			loadMessage();
		}
		private void loadMessage() {
			messages = new EnumMap<Student.Grade,String>(Student.Grade.class);
			messages.put(Student.Grade.A, A_MESSAGE);
			messages.put(Student.Grade.B, B_MESSAGE);
			messages.put(Student.Grade.C, C_MESSAGE);
			messages.put(Student.Grade.D, D_MESSAGE);
			messages.put(Student.Grade.F, F_MESSAGE);
		}
		public String getMesssage(Student.Grade grade) {
			return messages.get(grade);
		}
		
	}
	public static void main(String[] args) {
		Student s = new Student("zhangsan");
		s.addGrade(Grade.A);
		System.out.printf("学生%s本学期表现%s%n",s.getName(),new ReportCard().getMesssage(s.getGrade(0)));
	}
}
