package cn.nbcc.ex27.ch04;

public class App {

	public static void main(String[] args) {
		
		Bell bell = new Bell();  //�½�һ����
		Student s1 = new Student("����");//�½�����ѧ��
		Student s2 = new Student("����");
		
		Teacher t1 = new Teacher("Mr.��");//�½�һ������ʦ
		
		bell.addBellListener(s1);//ע���������
		bell.addBellListener(s2);
		bell.addBellListener(t1);
		
		bell.ring();//���������¼�����֪ͨ���м�����������Ӧ
		
		
		

	}

}
