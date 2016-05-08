package cn.nbcc.ex20.ch04.task02;

public class Exam {

	private Room room;		//����
	private CourseSession cs;
	private String klass;	//�༶
	private Student stuSeats[];

	public Exam(CourseSession cs, Room room,String klass) {
		this.cs = cs;
		this.room = room;
		this.klass = klass;
		stuSeats=new Student[room.getSize()+1];//�±�Ϊ0Ԫ�ز�����
	}
	
	public String getSeatSheet() {
		String sheader = buildSheetHeader();
		String sbody = buildSheetBody(); 
		return sheader+sbody;
	}

	/**
	 * ������λ��
	 * @return
	 */
	private String buildSheetBody() {
		for (int i = 0; i < cs.getNumOfStudent(); i++) {
			if (room.hasNextSeat()) {
				int index = room.getRandomSeatIndex();		//�õ������λ���
				room.occupied(index);						//ռ����λ
				stuSeats[index]=cs.getStudentAt(i);			//��Ӧѧ��
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < stuSeats.length; i++) {
			//�����ǰ���ǿ����������
			if (stuSeats[i]==null) {
				continue;
			}
			sb.append(i+"\t");
			sb.append(stuSeats[i].getId()+"\t");
			sb.append(stuSeats[i].getName()+"\n");
		}
		return sb.toString();
	}

	/**
	 * ������ͷ
	 * @return
	 */
	private String buildSheetHeader() {
		
		return String.format("�γ���:%s\t�γ̺�:%s\t�༶:%s\t����:%s%n", cs.getCourseName(),cs.getCourseId(),klass,room.getLoc());
	}

}
