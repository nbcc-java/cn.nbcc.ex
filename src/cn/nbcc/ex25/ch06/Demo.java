package cn.nbcc.ex25.ch06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Demo {

	public static void main(String[] args) throws IOException {
		File file = new File("z:\\names.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line = null;
		FileAnalyzer fileAnalyzer = null; 
		while ((line = bufferedReader.readLine())!=null) {
			String id = fileAnalyzer.getId(line);
			String name = fileAnalyzer.getName(line);
			fileAnalyzer.createNewFile("z:\\", id+name+".rar");
		}
	}

}
