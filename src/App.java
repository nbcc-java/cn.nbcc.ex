import java.util.Scanner;


public class App {

	static boolean isSep(char c,char[] sp){
		return c==sp[0]||c==sp[1]||c==sp[2];
	}
	static boolean  isEnd(int i,String s){
		if (i>=s.length()) {
			return true;
		}else
			return false;
	}
	public static void main(String[] args) {
		
		int total = 0;
		int amount[] = new int[11];
		char sp[] = {'\t',' ','\n'};
		
//		String test = "\"What you see is a very hefty response,\" said CNN Aviation Correspondent Rene Marsh.";
		Scanner sc =new Scanner(System.in);
		String test = sc.nextLine();
		for(int i=0;i<test.length();i++) {
			int wCount = 0;
			char c = test.charAt(i);
			while (!isEnd(i,test)&&isSep(c, sp)) {
				i++;
			}
			while(!isEnd(i,test)&&!isSep(c, sp))
			{
				wCount++;
				if (i==test.length()-1) {
					break;
				}
				c=test.charAt(++i);
			}
			total+=1;
			if (wCount<=10) {
				amount[wCount]++;
			}			
		}
		
		System.out.printf("%d\t",total);
		for (int j=1;j<amount.length;j++) {
			System.out.printf("%d\t",amount[j]);
		}
		System.out.println();
	}
}
