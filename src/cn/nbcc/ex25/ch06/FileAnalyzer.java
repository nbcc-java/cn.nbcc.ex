package cn.nbcc.ex25.ch06;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileAnalyzer {
	public static String getId(String originName) {
		String id=null;
		Pattern pattern = Pattern.compile("\\d{9}");
		Matcher matcher = pattern.matcher(originName);
		if (matcher.find()) {
			id=matcher.group();
		}
		return id;
	}
	
	public static String getName(String originName) {
		
		String name="";
		Pattern pattern = Pattern.compile("[\\u4E00-\\u9FA5\\uF900-\\uFA2D]+"); //∆•≈‰÷–Œƒ
		Matcher matcher = pattern.matcher(originName);
		while (matcher.find()) {
			name+=matcher.group();
		}
		return name.isEmpty()?null:name;
	}
	
	public static void createNewFile(String path,String fileName) throws IOException {
		File folder = new File(path);
		if (!folder.exists()) {
			folder.mkdirs();
		}
		File file = new File(path+File.separator+fileName);
		if(file.createNewFile())
			System.out.println("create file under path:"+file.getAbsolutePath());
	}
}
