package cn.nbcc.ex20.ch04.task02;

import java.util.Random;

public class Room {

	private int numOfSeats;			//座位数
	private String loc;				//所在地
	private int seatOccupied[];		//座位占用标志数组
	private int ocSeats;			//当前占用的座位数

	public Room(String location, int numOfSeats) {
		this.loc = location;
		this.numOfSeats = numOfSeats;
		seatOccupied = new int[numOfSeats+1];//下标为0元素不用
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
