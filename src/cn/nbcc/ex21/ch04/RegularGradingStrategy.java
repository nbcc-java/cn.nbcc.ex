package cn.nbcc.ex21.ch04;

import cn.nbcc.ex21.ch04.Student.Grade;

/**
 * 普通学生的计分策略
 * @author Administrator
 *
 */
public class RegularGradingStrategy extends BasicGradeStrategy {

	
	@Override
	public int getGradePointsFor(Grade grade) {
		return basicGradePointFor(grade);
	}

}
