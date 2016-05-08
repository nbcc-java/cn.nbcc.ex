package cn.nbcc.ex13.ch02;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Task02 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your name:");
		String name ;
		while (scan.hasNextLine()&&(name=scan.nextLine())!=null) {
			System.out.println(name);
			System.out.println("Enter your next name:");
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		System.out.println(sdf.format(new Date()));
	}

}
