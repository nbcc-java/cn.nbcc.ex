package cn.nbcc.ex08.ch02;

import java.util.Scanner;

public class Task03 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		while (n > 0) {
			for (int line = 1; line <= n; line++) {
				for (int star = 0; star < line; star++) {
					System.out.print('*');
				}
				System.out.println();
			}
			n = s.nextInt();
		}
	}

}
