package cn.nbcc.ex27.ch04;

public class App {

	public static void main(String[] args) {
		
		Bell bell = new Bell();  //新建一个铃
		Student s1 = new Student("张三");//新建若干学生
		Student s2 = new Student("李四");
		
		Teacher t1 = new Teacher("Mr.王");//新建一个王老师
		
		bell.addBellListener(s1);//注册监听名单
		bell.addBellListener(s2);
		bell.addBellListener(t1);
		
		bell.ring();//产生打铃事件，并通知所有监听人作出响应
		
		
		

	}

}
