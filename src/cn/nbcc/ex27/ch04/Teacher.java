package cn.nbcc.ex27.ch04;

public class Teacher implements BellListener {

	String name;
	public Teacher(String name) {
		this.name = name;
	}
	@Override
	public void onBellRang() {
		//��ʦ�������������Ϊд�ڴ�
		System.out.println("��ʦ"+name+"�߽����ң���ʼ������׼���Ͽ�");
	}

}
