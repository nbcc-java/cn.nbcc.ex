package cn.nbcc.book.ch02;

public class Task01 {
	
	public static int gcd(int a,int b){
		if (b==0) {
			return a;
		}else {
			return gcd(b,a%b);
		}
	}
	
	public static void main(String[] args) {
		int ret = gcd(1000,495);
		System.out.println(ret);
	}
}
