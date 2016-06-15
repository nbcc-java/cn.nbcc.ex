package cn.nbcc.ex27.ch04;

public class Teacher implements BellListener {

	String name;
	public Teacher(String name) {
		this.name = name;
	}
	@Override
	public void onBellRang() {
		//教师听到铃声后的行为写在此
		System.out.println("教师"+name+"走进教室，开始点名，准备上课");
	}

}
