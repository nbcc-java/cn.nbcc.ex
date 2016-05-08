package cn.nbcc.ex16.ch04;

public class User {
	protected String name;
	protected String id;

	public User() {
	}

	public User(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void login() {
		System.out.println(name + "µÇê‘");
	}

	public void logout() {
		System.out.println(name + "ÍË³ö");
	}
}
