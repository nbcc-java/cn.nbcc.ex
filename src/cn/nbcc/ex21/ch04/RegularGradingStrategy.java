package cn.nbcc.ex21.ch04;

import cn.nbcc.ex21.ch04.Student.Grade;

/**
 * ��ͨѧ���ļƷֲ���
 * @author Administrator
 *
 */
public class RegularGradingStrategy extends BasicGradeStrategy {

	
	@Override
	public int getGradePointsFor(Grade grade) {
		return basicGradePointFor(grade);
	}

}
