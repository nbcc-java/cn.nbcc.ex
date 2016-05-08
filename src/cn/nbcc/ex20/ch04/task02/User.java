package cn.nbcc.ex20.ch04.task02;

public class User {
	private String name;
	protected String id;
	
//	public User() {
//	}
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
	public void login(){
		System.out.println(name+"µÇÂ¼");
	}
//	public abstract void login();
	public void logout(){
		System.out.println(name+"ÍË³ö");
	}
	
	@Override
	public String toString() {
		return String.format("id=%s,name=%s", id,name);
	}
	
}
