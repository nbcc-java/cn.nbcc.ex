package cn.nbcc.ex27.ch04;

public class Student implements BellListener{
	
	String name;
	
	public Student(String name) {
		this.name = name;
	}

	@Override
	public void onBellRang() {
		//ѧ������������Ĵ�����Ϊд�ڴ�
		System.out.println("ѧ��"+name+"�ڽ��������õȴ��Ͽ�");
		
	}

}
