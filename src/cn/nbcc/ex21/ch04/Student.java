package cn.nbcc.ex21.ch04;


import java.util.ArrayList;

public class Student extends User {
	enum Grade {
		A(4), B(3), C(2), D(1);
		int point;
		private Grade(int point) {
			this.point = point;
		}

		public int getPoint() {
			return this.point;
		}
	}

	String id;
	String name;
	GradingStrategy gradingStrategy;
	
	
	private ArrayList<Grade> grades = new ArrayList<>();

	public Student(String id, String name) {
		super(id, name);
	}

	/**
	 * 设置学生的计分策略
	 * @param gradingStrategy
	 */
	public void setGradingStrategy(GradingStrategy gradingStrategy) {
		this.gradingStrategy = gradingStrategy;
	}
	
	public void addGrade(Grade grade) {
		grades.add(grade);

	}

	public double getGPA() {
		if (grades.isEmpty())
			return 0.0;// 避免0/0的情况
		double total = 0.0;
		for (Grade grade : grades) {
			total += gradingStrategy.getGradePointsFor(grade);
		}
		return total / grades.size();
	}

//	private double gradePointFor(Grade grade) {
//		return grade.getPoint();
//	}
	public void login() {
		super.login();
		System.out.println("切换到学生视图");
	}
}
