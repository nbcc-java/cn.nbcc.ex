/**
 * ��������cn.nbcc.chap06.snippets
 * �ļ�����Rename.java
 * �����ߣ�֣��
 * ����ʱ�䣺2016��5��22�� ����5:15:54
 */
package cn.nbcc.chap06.snippets;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rename {

	public static void main(String[] args) {
//		System.out.println("��������Ҫ��������ѧ����Ϣ:");
//		Scanner sc = new Scanner(System.in);
//		String input = sc.nextLine();
		String input = "172.19.100.53_133030244 �ſ���.zip";
		rename(input);
//		sc.close();
	}

	private static void rename(String input) {
//		String test = "�ſ���";
//		System.out.println(Pattern.matches("[^\\s|\\.]*", test));
		Pattern p = Pattern.compile("(\\d{9})(\\s+)([^\\s|\\.]*)(.rar|.zip)");
		Matcher m = p.matcher(input);
		while (m.find()) {
			System.out.println(m.group(1)+m.group(3)+m.group(4));
		}

	}
}

