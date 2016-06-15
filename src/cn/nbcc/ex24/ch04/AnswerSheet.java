package cn.nbcc.ex24.ch04;

import java.util.ArrayList;
/**
 * 情况表包含授课标题，班级名称，授课发布时间，以及若干个问题回答情况
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