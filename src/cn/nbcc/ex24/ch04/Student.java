package cn.nbcc.ex24.ch04;

public class Student implements Comparable<Student>{
	String id;
	String name;
	double scores=0.0;
	String login;
	public Student(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public void addScore(double score) {
		scores += score;
		
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}
	public double getScores() {
		// TODO Auto-generated method stub
		return scores;
	}
	@Override
	public int compareTo(Student o) {
		return this.id.compareTo(o.id);
	}
	
	@Override
	public String toString() {
		return String.format("[id=%s,name=%s,score=%.1f]%n", id,name,scores);
	}
}