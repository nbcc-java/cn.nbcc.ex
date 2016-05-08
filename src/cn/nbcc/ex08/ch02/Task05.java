package cn.nbcc.ex08.ch02;

import java.util.Scanner;

public class Task05 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		while (n > 0) {
			for (int line = 1; line <= n; line++) {
				for (int space = 0; space < n-line; space++) {
					System.out.print(' ');
				}
				for (int star = 1; star <=2*line-1; star++) {
					System.out.print('*');
				}
				System.out.println();
			}
			n = s.nextInt();
		}
	}

}
