package cn.nbcc.ex20.ch04.task02;

public class Exam {

	private Room room;		//教室
	private CourseSession cs;
	private String klass;	//班级
	private Student stuSeats[];

	public Exam(CourseSession cs, Room room,String klass) {
		this.cs = cs;
		this.room = room;
		this.klass = klass;
		stuSeats=new Student[room.getSize()+1];//下标为0元素不可用
	}
	
	public String getSeatSheet() {
		String sheader = buildSheetHeader();
		String sbody = buildSheetBody(); 
		return sheader+sbody;
	}

	/**
	 * 构建座位表
	 * @return
	 */
	private String buildSheetBody() {
		for (int i = 0; i < cs.getNumOfStudent(); i++) {
			if (room.hasNextSeat()) {
				int index = room.getRandomSeatIndex();		//得到随机座位序号
				room.occupied(index);						//占据座位
				stuSeats[index]=cs.getStudentAt(i);			//对应学生
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < stuSeats.length; i++) {
			//如果当前座是空座，则继续
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
	 * 构建表头
	 * @return
	 */
	private String buildSheetHeader() {
		
		return String.format("课程名:%s\t课程号:%s\t班级:%s\t考场:%s%n", cs.getCourseName(),cs.getCourseId(),klass,room.getLoc());
	}

}
