package cn.nbcc.ex21.ch04;

import cn.nbcc.ex21.ch04.Student.Grade;


public interface GradingStrategy {
	//���ݵȼ��ֻ����Ӧ��ֵ��
	int getGradePointsFor(Grade grade);

}
