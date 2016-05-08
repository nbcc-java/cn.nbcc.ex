package cn.nbcc.ex21.ch04;

import cn.nbcc.ex21.ch04.Student.Grade;


public class EliteGradingStrategy implements GradingStrategy {

	@Override
	public int getGradePointsFor(Grade grade) {
		if (grade==Grade.A||grade==Grade.B||grade==Grade.C||grade==Grade.D) {
			return 4;
		}
		return 0;
	}

}
