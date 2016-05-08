package cn.nbcc.ex21.ch04;

import cn.nbcc.ex21.ch04.Student.Grade;

public abstract class BasicGradeStrategy implements GradingStrategy {

	/**
	 * 
	 * @param grade
	 * @return
	 */
	public int basicGradePointFor(Grade grade) {
		if (grade==Grade.A) {
			return 4;
		}
		if (grade==Grade.B) {
			return 3;
		}
		if (grade==Grade.C) {
			return 2;
		}
		if (grade==Grade.D) {
			return 1;
		}
		return 0;
	}

	@Override
	public abstract int getGradePointsFor(Grade grade);
	

}
