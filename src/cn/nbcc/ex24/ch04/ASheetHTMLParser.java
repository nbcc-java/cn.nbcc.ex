package cn.nbcc.ex24.ch04;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ASheetHTMLParser {
	
	String html;
	private Document doc;
	
	public ASheetHTMLParser(String html) {
		this.html = html;
		doc = Jsoup.parse(html);
	}
	public ASheetHTMLParser(File file,String charsetName) {
		try {
			doc = Jsoup.parse(file, charsetName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String[] getSheetColumnNames() {
		Elements  tds = doc.select("td > table   th ");
		ArrayList<String> columnNames = new ArrayList<>();
		for (Element element : tds) {
			if (!element.text().isEmpty()) {
				columnNames.add(element.text());
			}
		}
		String cNames[] = new String[columnNames.size()];
		return columnNames.toArray(cNames);
	}
	
	/**
	 * 解析学生回答情况
	 */
	public void parseSheetAnswer() {
		Elements  elements = doc.select("td > table   tr ");
		Context context = Context.getInstance();
		Map<Student, String> answerMap = null ;
		Question q=null;
		Student s ;
		for (Element element : elements) {
			//取出tr节点
			if (element.select("th").size()==0 && element.children().size()>4)
			{
				
				//数据节点
				//添加学号
				String id = element.child(0).text();
				//添加姓名
				String name = element.child(1).text();
				s = Context.getInstance().getStudent(new Student(id,name));
				
				if (element.child(2).hasAttr("rowspan")) {
					//if is another new question put questionMap
					if (answerMap!=null&&q!=null) {
						q.setAnswerMap(answerMap);
						context.putQuestion(q.getTitle(), q);
					}
					
					q = new Question(
							element.child(2).text(), 
							element.child(3).text(), 
							Integer.parseInt(element.child(4).text()));
					answerMap = new HashMap<>();
					answerMap.put(s, element.child(5).text());
					s.addScore(Double.parseDouble(element.child(6).text()));
					s.setLogin(element.child(7).text());
					
				}else{  
					answerMap.put(s, element.child(2).text());
					s.addScore(Double.parseDouble(element.child(3).text()));
					s.setLogin(element.child(4).text());
				}
				
			}
		}
		//add last question and put question Map
		if (answerMap!=null&&q!=null) {
			q.setAnswerMap(answerMap);
			context.putQuestion(q.getTitle(), q);
		}
		
	}
	
	

}
