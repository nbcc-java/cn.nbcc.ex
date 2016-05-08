package cn.nbcc.ex20.ch04.task02;
import java.util.ArrayList;
import java.util.List;
public  class Student extends User {
	private List<Integer> charges = new ArrayList<Integer>();
	
	public void addCharge(int charge) {
		charges.add(new Integer(charge));
	}
	public int totalCharges() {
		int total=0;
		for (Integer charge : charges) {
			total+=charge.intValue();
		}
		return total;
	}
	
	public enum Grade{
		A(4),
		B(3),
		C(2),
		D(1),
		F(0);
		private int points;
		private Grade(int points) {
			this.points = points;
		}
		public int getPoints() {
			return points;
		}
	};
	
	private ArrayList<Grade> grades = new ArrayList<Grade>();
	
	
	
	public Student(String id,String name) {
		//name="test"
		super(id,name);
	}
	public void addGrade(Grade grade ) {
		grades.add(grade);
	}
	public double getGPA() {
		if (grades.isEmpty()) 
			return 0.0;
		double total = 0.0;
		for (Grade grade : grades) {
			total = gradePointsFor( grade);
		}
		return total/grades.size();
	}
	
	private double gradePointsFor(Grade grade) {
		if (Grade.A==grade) return 4;
		if (Grade.B==grade) return 3;
		if (Grade.C==grade) return 2;
		if (Grade.D==grade) return 1;
		return 0;
	}
	public void login(){
		super.login();
		System.out.println("切换到学生视图");
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student other = (Student) obj;
			return this.id.equals(other.id);
		}
		return super.equals(obj);
	}
}
