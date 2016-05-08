package cn.nbcc.ex21.ch04;


public class Teacher extends User {
	public Teacher(String id, String name) {
		super(id, name);
	}

	public void login() {
		super.login();
		System.out.println("«–ªªµΩΩÃ “ ”Õº");
	}
}
