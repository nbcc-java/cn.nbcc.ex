package cn.nbcc.ex24.ch04;

import java.util.ArrayList;
/**
 * ���������ڿα��⣬�༶���ƣ��ڿη���ʱ�䣬�Լ����ɸ�����ش����
 * @author Administrator
 *
 */
public class AnswerSheet{
	ArrayList<Question> qList = new ArrayList<>();
	String sessionTitle;
	String klass;
	String publishDateTime;
	public AnswerSheet(String sessionTitle, String klass,
			String publishDateTime) {
		super();
		this.sessionTitle = sessionTitle;
		this.klass = klass;
		this.publishDateTime = publishDateTime;
	}
	
}