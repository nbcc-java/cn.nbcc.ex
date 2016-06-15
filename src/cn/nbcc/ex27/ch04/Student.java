package cn.nbcc.ex27.ch04;

public class Student implements BellListener{
	
	String name;
	
	public Student(String name) {
		this.name = name;
	}

	@Override
	public void onBellRang() {
		//学生听到铃声后的处理行为写在此
		System.out.println("学生"+name+"在教室中坐好等待上课");
		
	}

}
