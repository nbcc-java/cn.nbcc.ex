package cn.nbcc.ex10.ch02;

import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class Task02 {
	
//	public static void  printAsk(int n,int size) {
//		if(n>0){
//			String star = StringUtils.repeat('*', 2*n-1);
//			String line = StringUtils.leftPad(star, (int)((size-star.length())/2.0+star.length()));
//			System.out.println(line);
//			printAsk(n-1,size);
//		}
//	}
	
	
	public static void  printAsk(int n,int size) {
		if(n>0){
			printAsk(n-1,size);
			for (int space = (size-2*n+1)/2; space >0; space--) {
				System.out.print(" ");
			}
			for (int i = 0; i < 2*n-1; i++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		int n ;
		Scanner s = new Scanner(System.in);
		while((n=s.nextInt())>0)
			printAsk(n,2*n-1);
	}

}
