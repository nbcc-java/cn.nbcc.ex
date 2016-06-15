package cn.nbcc.ex24.ch04;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


//每套题有 题目， 分值，标准答案，回答情况
public class Question {

	String title; // 题目标题
	int score; // 设定分值
	String stdAnswer; // 标准答案
	Map<Student, String> answerMap = new HashMap<>(); // 回答情况

	public Question(String title, String stdAnswer, int score) {
		super();
		this.title = title;
		this.score = score;
		this.stdAnswer = stdAnswer;
	}
	

	public void setAnswerMap(Map<Student, String> answerMap) {
		this.answerMap = answerMap;
	}

	@Override
	public String toString() {
		return String.format("title=%s,score=%d,answer=%s", title, score,
				stdAnswer);
	}

	public String getQuessionAnswerList() {
		StringBuilder sb = new StringBuilder();
		sb.append(toString() + "\n");
		for (Map.Entry<Student, String> entry : answerMap.entrySet()) {
			Student s = (Student)entry.getKey();
			sb.append(s.id + "\t" + s.name + "\t" + entry.getValue() + "\n");
		}
		return sb.toString();
	}


	public String getTitle() {
		return title;
	}

}
