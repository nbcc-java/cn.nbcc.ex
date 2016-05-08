package cn.nbcc.ex21.ch04;

import cn.nbcc.ex21.ch04.Student.Grade;


public interface GradingStrategy {
	//根据等级分获得相应数值分
	int getGradePointsFor(Grade grade);

}
