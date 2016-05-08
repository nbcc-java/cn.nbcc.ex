package cn.nbcc.ex20.ch04.task02;
import java.util.ArrayList;
import java.util.List;
public class CourseSession {
	private String id;
	private String courseName;
	private ArrayList<Student> students = new ArrayList<Student>();
	public CourseSession(String id, String courseName){
		super();
		this.id = id;
		this.courseName = courseName;
	}
	public void enroll(Student s) {
		students.add(s);
	}
	public User getStudent(int index) {
		return students.get(index);
	}
	public List<Student> getAllStudent() {
		return students;
	}
	public String getCourseName() {
		return courseName;
	}
	public String getCourseId() {
		return id;
	}
	public int getNumOfStudent() {
		return students.size();
	}
	public Student getStudentAt(int index) {
		return students.get(index);
	}
}
