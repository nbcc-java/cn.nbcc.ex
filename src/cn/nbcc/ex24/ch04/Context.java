package cn.nbcc.ex24.ch04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Context {
	
	Map<String,Student> _stuMap ;
	Map<String,Question> _qMap;
	
	static Context _instance;
	
	private Context() {
		_stuMap = new HashMap<String, Student>();
		_qMap = new HashMap<>();
	}
	
	public static  Context getInstance(){
		if (_instance==null) {
			_instance = new Context();
		}
		return _instance;
	}
	
	/**
	 * @param id
	 * @return null if not found ,return student if find id by specified;
	 */
	public Student getStudentById(String id){
		if (_stuMap.containsKey(id)) {
			return _stuMap.get(id);
		}
		return null;
	}
	
	/**
	 * add student if not found 
	 * @param s
	 * @return
	 */
	public Student getStudent(Student s) {
		if (getStudentById(s.getId())==null) {
			_stuMap.put(s.getId(), s);
		}
		return getStudentById(s.getId());
	}
	
	public boolean putQuestion(String title, Question q) {
		if (!_qMap.containsKey(title)) {
			_qMap.put(title, q);
			return true;
		}
		return false;
	}

	public int getQuestionSize() {
		return _qMap.size();
	}

	public void reset() {
		_instance = new Context();
	}

}
