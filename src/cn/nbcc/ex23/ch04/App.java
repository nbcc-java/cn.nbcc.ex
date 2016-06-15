package cn.nbcc.ex23.ch04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class App {
	static class Student {
		String name;

		public Student(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this) {
				return true;
			}
			if (obj.getClass() != this.getClass()) {
				return false;
			}
			Student other = (Student) obj;

			return this.getName().equals(other.getName());
		}

		@Override
		public int hashCode() {
			return getName().hashCode();
		}
	}

	public static void main(String[] args) {
		List<Student> stuList = Arrays.asList(new Student("张三"), new Student("李四"),new Student("王五"), new Student("赵六")  );

		for (Iterator iterator = stuList.iterator(); iterator.hasNext();) {
			Student student = (Student) iterator.next();
			System.out.println(student.getName());
		}
		Student s[] = new Student[stuList.size()];
		stuList.toArray(s);
		
		for (Student student : s) {
			System.out.println(student.getName());
		}
		
		Student s = new Student("赵六");
		if (!stuList.contains(s)) {
			stuList.add(s);
		}
//
//		System.out.println("------------------");
//		for (Student student : stuList) {
//			System.out.println(student.getName());
//		}
	}

}
