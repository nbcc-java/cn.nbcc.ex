/**
 * 所属包：cn.nbcc.chap06.snippets
 * 文件名：Rename.java
 * 创建者：郑哲
 * 创建时间：2016年5月22日 下午5:15:54
 */
package cn.nbcc.chap06.snippets;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rename {

	public static void main(String[] args) {
//		System.out.println("请输入您要重命名的学生信息:");
//		Scanner sc = new Scanner(System.in);
//		String input = sc.nextLine();
		String input = "172.19.100.53_133030244 张俊康.zip";
		rename(input);
//		sc.close();
	}

	private static void rename(String input) {
//		String test = "张俊康";
//		System.out.println(Pattern.matches("[^\\s|\\.]*", test));
		Pattern p = Pattern.compile("(\\d{9})(\\s+)([^\\s|\\.]*)(.rar|.zip)");
		Matcher m = p.matcher(input);
		while (m.find()) {
			System.out.println(m.group(1)+m.group(3)+m.group(4));
		}

	}
}

