package cn.nbcc.ex24.ch04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTask {
	

	public static void main(String[] args) {
		
		String html =	"<td rowspan=\"46\">第1题</td>"+
                    	"<td rowspan=\"46\">C</td>"+
                    	"<td rowspan=\"46\">1</td>"+
						"<td rowspan=\"46\">第2题</td>"+
				    	"<td rowspan=\"46\">D</td>"+
				    	"<td rowspan=\"46\">2</td>";
		
		Pattern pattern = Pattern.compile("rowspan=\"\\d{1,}\">([^<]*)</td>");
		Matcher matcher = pattern.matcher(html);
		String t=null;
		int s = 0;
		String a = null;
		int i = 0;
		Question q =null;
		ArrayList<Question> qList = new ArrayList<>();
		while (matcher.find()) {
			switch (i%3) {
			case 0:
				t = matcher.group(1);
				break;
			case 1:
				a = matcher.group(1);
				break;
			case 2:
				s = Integer.parseInt(matcher.group(1));
				break;
			default:
				break;
			}
			i++;
			if (i%3==0&&i!=0) {
				q = new Question(t, a, s);
				qList.add(q);
			}
		}
		System.out.println(Arrays.toString(qList.toArray()));
	}

}
