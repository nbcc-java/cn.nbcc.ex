package cn.nbcc.ex20.ch04.task01;

public class Seed {
	private String name;
	private int ripePeriod;	//����ʱ��
	private int experience;	//����ֵ
	private int earnings;	//����
	private int price;		//���Ѽ۸�
	
	public Seed(String name) {
		this.name = name;
	}

	public int getCost() {
		return price;
	}


	public int getRipePeriod() {
		return ripePeriod;
	}

	public void setRipePeriod(int ripePeriod) {
		this.ripePeriod = ripePeriod;
	}


	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getExperience() {
		return experience;
	}

	public int getEarnings() {
		return earnings;
	}

	public void setEarnings(int earnings) {
		this.earnings = earnings;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	

}
