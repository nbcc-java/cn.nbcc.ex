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
		static final String A_MESSAGE="���ַǳ�����";
		static final String B_MESSAGE="���ַǳ���";
		static final String C_MESSAGE="���ֻ�����Ŷ";
		static final String D_MESSAGE="��������";
		static final String F_MESSAGE="��Ҫ������";
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
		System.out.printf("ѧ��%s��ѧ�ڱ���%s%n",s.getName(),new ReportCard().getMesssage(s.getGrade(0)));
	}
}
