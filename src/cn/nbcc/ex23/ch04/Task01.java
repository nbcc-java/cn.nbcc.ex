package cn.nbcc.ex23.ch04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import cn.nbcc.ex23.ch04.Task01.Student;

public class Task01 {
	
	static class Student{
		private String name;

		Student(String name){
			this.name = name;
		}

		public String getName() {
			return name;
		}
		@Override
		public boolean equals(Object obj) {
			if(obj==this)
				return true;
			if(obj.getClass()!=this.getClass())
				return false;
			Student other = (Student)obj;
			return name.equals(other.getName());
		}
		@Override
		public int hashCode() {
			return name.hashCode();
		}
	}

	public static void main(String[] args) {
		ArrayList<Student> sList = new ArrayList<>();
		Student names[] = { 
				new Student("张三"),
				new Student("李四"),
				new Student("王五"),
				new Student("赵六")
		};
		sList.addAll(Arrays.asList(names));
		
		for (Iterator<Student> it = sList.iterator(); it.hasNext();) {
			Student s = (Student) it.next();
			System.out.println(s.getName());
		}
		System.out.println("-------------");
		Student s2 = new Student("赵六");
		if (!sList.contains(s2)) {
			sList.add(s2);
		}
		for (Student s : sList) {
			System.out.println(s.getName());
		}
	}
}
