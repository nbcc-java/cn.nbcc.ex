package cn.nbcc.ex10.ch02;

import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class Task03 {

	public static void main(String[] args) {
		final int MAX_STARS = 10;
		double n = 0;
		double max = 0.0,sum=0.0;
		double rates[] = new double[31];
		int index = 0;

		Scanner s = new Scanner(System.in);
		
		while((n=s.nextDouble())>0){
			if (n>max) {
				max = n;
			}
			rates[index++]=n;
			sum+=n;
		}
		
		System.out.printf("近一个月的平均收益率为%.4f %% %n",sum/index);
		for (int i = 0; i < index; i++) {
			String stars = StringUtils.repeat('*',(int)((rates[i]/max)*MAX_STARS));
			System.out.printf("%-10s\t%.6f%n",stars,rates[i]);
		}

	}

}
