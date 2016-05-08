package cn.nbcc.ex20.ch04.task02;

import java.util.Random;

public class Room {

	private int numOfSeats;			//��λ��
	private String loc;				//���ڵ�
	private int seatOccupied[];		//��λռ�ñ�־����
	private int ocSeats;			//��ǰռ�õ���λ��

	public Room(String location, int numOfSeats) {
		this.loc = location;
		this.numOfSeats = numOfSeats;
		seatOccupied = new int[numOfSeats+1];//�±�Ϊ0Ԫ�ز���
	}

	public String getLoc() {
		return loc;
	}

	public int getSize() {
		return numOfSeats;
	}

	public boolean hasNextSeat() {
		return ocSeats<numOfSeats;
	}
	public void occupied(int seatIndex) {
		seatOccupied[seatIndex]=1;
		ocSeats++;
	}

	public int getRandomSeatIndex() {
		Random r = new Random();
		int index = 0;
		do{
			index = r.nextInt(numOfSeats)+1;
		}while(seatOccupied[index]==1);
		return index;
	}

}
