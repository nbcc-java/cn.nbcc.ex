package cn.nbcc.ex10.ch02;

import java.util.Scanner;

public class Task01 {
	
	public static void  printAsk(int n) {
		if (n==1) {
			System.out.println("*");
		}else{
			printAsk(n-1);
			for (int i = 0; i < n; i++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int n ;
		Scanner s = new Scanner(System.in);
		while((n=s.nextInt())>0)
			printAsk(n);
	}

}
