package cn.nbcc.ex20.ch04.task01;

import java.util.Random;
import java.util.Scanner;

public abstract class Land {
	
	protected Seed land[];
	Seed types[] = {new Chili(),new Peanut(),new Pumpkin()};
	int total = 0;
	int costs = 0;
	int exp = 0;
	
	public Land() {
		land = new  Seed[28];
	}
	
	abstract void plant();
	
	public int getTotalCost(){
		int costs = 0;
		for (int i = 0; i < land.length; i++) {
			costs += land[i].getCost();
		}
		return costs;
	}
	
	public int getTotalEarnings() {
		int earnings = 0;
		for (int i = 0; i < land.length; i++) {
			earnings += land[i].getEarnings();
		}
		return earnings;
	}
	
	public int getExperience() {
		int experience = 0;
		for (int i = 0; i < land.length; i++) {
			experience+=land[i].getExperience();
		}
		return experience;
	}
	
	public void printLand() {
		for (int i = 0; i < land.length; i++) {
			String fullPath = land[i].getClass().getName();
			System.out.printf("%s\t",fullPath.substring(fullPath.lastIndexOf('.')+1,fullPath.lastIndexOf('.')+3).toUpperCase());
			if ((i+1)%4==0) {
				System.out.println();
			}
		}
	}
	
	public void printInfo() {
		System.out.println();
		System.out.printf("Total earning: %s%n",getTotalEarnings());
		System.out.printf("profit: %s%n",getTotalEarnings()-getTotalCost());
		System.out.printf("Experience: %s%n",getExperience());
	}

	public static void main(String[] args) {
		Land land = new Land() {
			@Override
			void plant() {
				Random r = new Random(); 
				for (int i = 0; i < land.length; i++) {
					land[i]=types[r.nextInt(types.length)];
				}
			}
		};
		land.plant();
		land.printLand();
		land.printInfo();
		
		Land land2 = new Land() {
			
			@Override
			void plant() {
				int index = 0;
				while (true) {
					Scanner sc = new Scanner(System.in);
					System.out.println("Please choose your seed(1 for Chili,2 for Pumpkin,3 for peanut,-1 for exit)");
					int c = sc.nextInt();
					if (c==-1) {
						break;
					}
					System.out.println("Please enter your amount:");
					int num = sc.nextInt();
					for (int i = 0; i < num && index<land.length; i++,index++) {
						land[index]=types[c-1];
					}
					if (index>=land.length) {
						System.out.println("Land is full!");
						break;
					}
				}
				
			}
		};
		land2.plant();
		land2.printLand();
		land2.printInfo();
		

	}

}
