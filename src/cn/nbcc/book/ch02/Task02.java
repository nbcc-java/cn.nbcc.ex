package cn.nbcc.book.ch02;

public class Task02 {
	
	public static void main(String[] args) {
		for (int i = 100; i <1000 ; i++) {
			int hundred = i / 100;
			int decade  = i % 100 /10;
			int digit = i % 10;
			if (i==hundred*hundred*hundred + decade*decade*decade+digit*digit*digit) {
				System.out.println("fond:"+i);
			}
			
		}
	}

}
