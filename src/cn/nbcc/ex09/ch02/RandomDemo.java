package cn.nbcc.ex09.ch02;

public class RandomDemo {

	public static void main(String[] args) {
		
		int face1,face2,face3,face4,face5,face6;
		face1=face2=face3=face4=face5=face6=0;
		
		for (int dice = 1; dice <=6000 ; dice++) {
			int face = (int)(Math.random()*6+1);
			switch (face) {
			case 1:	face1++;break;
			case 2:	face2++;break;
			case 3:	face3++;break;
			case 4:	face4++;break;
			case 5:	face5++;break;
			case 6:	face6++;break;
			default:
				break;
			}
		}
		System.out.printf("face1=%d%n"
						+ "face2=%d%n"
						+ "face3=%d%n"
						+ "face4=%d%n"
						+ "face5=%d%n"
						+ "face6=%d%n",face1,face2,face3,face4,face5,face6);
		
		int freq2,freq3,freq4,freq5,freq6,freq7,freq8,freq9,freq10,freq11,freq12;
		freq2=freq3=freq4=freq5=freq6=freq7=freq8=freq9=freq10=freq11=freq12=0;
		
		for (int dice = 1; dice <=6000 ; dice++) {
			int f1 = (int)(Math.random()*6+1);
			int f2 = (int)(Math.random()*6+1);
			switch (f1+f2) {
			case 2:	freq2++;break;
			case 3:	freq3++;break;
			case 4:	freq4++;break;
			case 5:	freq5++;break;
			case 6:	freq6++;break;
			case 7:	freq7++;break;
			case 8:	freq8++;break;
			case 9:	freq9++;break;
			case 10:freq10++;break;
			case 11:freq11++;break;
			case 12:freq12++;break;
			default:
				break;
			}
		}
		System.out.printf("sum=2 freq=%d%n"
						+ "sum=3 freq=%d%n"
						+ "sum=4 freq=%d%n"
						+ "sum=5 freq=%d%n"
						+ "sum=6 freq=%d%n"
						+ "sum=7 freq=%d%n"
						+ "sum=8 freq=%d%n"
						+ "sum=9 freq=%d%n"
						+ "sum=10 freq=%d%n"
						+ "sum=11 freq=%d%n"
						+ "sum=12 freq=%d%n",freq2,freq3,freq4,freq5,freq6,freq7,freq8,freq9,freq10,freq11,freq12);
		
		
	}

}
