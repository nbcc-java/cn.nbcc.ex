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
				msg = "大了，再试一次";
			}else if(guessPrice<randomPrice){
				msg = "小了，再试一次";
			}else {
				msg = "恭喜你，猜对了";
				isEnd=true;
			}
			System.out.println(msg);
		}

	}

}
