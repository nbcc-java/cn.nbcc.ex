package cn.nbcc.ex21.ch04;

import cn.nbcc.ex21.ch04.Student.Grade;




public class HornorsGradingStrategy extends BasicGradeStrategy {
	
	@Override
	public int getGradePointsFor(Grade grade) {
		int points = basicGradePointFor(grade);
		if (points>0) {
			points+=1;
		}
		return points;
	}

}
