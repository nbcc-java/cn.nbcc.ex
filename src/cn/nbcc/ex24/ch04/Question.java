package cn.nbcc.ex24.ch04;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


//ÿ������ ��Ŀ�� ��ֵ����׼�𰸣��ش����
public class Question {

	String title; // ��Ŀ����
	int score; // �趨��ֵ
	String stdAnswer; // ��׼��
	Map<Student, String> answerMap = new HashMap<>(); // �ش����

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
