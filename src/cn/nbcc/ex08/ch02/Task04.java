package cn.nbcc.ex08.ch02;

import java.util.Scanner;

public class Task04 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n;
//		int n = s.nextInt();
//		while (n > 0) {
//			for (int line = 1; line <= n; line++) {
//				for (int star = n-line; star >= 0; star--) {
//					System.out.print('*');
//				}
//				System.out.println();
//			}
//			n = s.nextInt();
//		}
		
		
		while ((n=s.nextInt())>0) {
			for (int line = 1; line <= n; line++) {
				for (int star = n-line; star >= 0; star--) {
					System.out.print('*');
				}
				System.out.println();
			}
		}
	}

}
