package cn.nbcc.ex09.ch02;

import java.util.Scanner;

public class GuessGame {

	public static void main(String[] args) {
		
		System.out.println("Please input your guess price(1-100):");
		Scanner s = new Scanner(System.in);
		int guessPrice;
		int randomPrice = (int)(Math.random()*100+1);
		String msg = "";
		boolean isEnd = false;
		while ((guessPrice=s.nextInt())>0||isEnd) {
			if (guessPrice>randomPrice) {
				msg = "���ˣ�����һ��";
			}else if(guessPrice<randomPrice){
				msg = "С�ˣ�����һ��";
			}else {
				msg = "��ϲ�㣬�¶���";
				isEnd=true;
			}
			System.out.println(msg);
		}

	}

}
