package objects;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		String name = "", choice = "n";
		int difficulty = 0, set = 3;
		boolean flag = true;
		
		while(flag) {
			try {
				flag = false;
				System.out.println("Please enter your name:");
				name = read.nextLine();
			}catch(Exception e) {
				flag = true;
			}
		}
		flag = true;

		while(flag) {
			try {
				flag = false;
				System.out.println("1 =  easy, 2 = normal, 3 = hard, 4 = fingerbreaker");
				System.out.println("Please select your difficulty:");
				
				difficulty = read.nextInt();
			}catch(Exception e) {
				flag = true;
				
				
			}
		}
		
		flag = true;
		
		switch(difficulty) {
			case 1: set = 3; System.out.println("You selected easy. \n"); break;
			case 2: set = 7; System.out.println("You selected normal. \n"); break;
			case 3: set = 15; System.out.println("You selected hard. \n"); break;
			case 4: set = 27; System.out.println("You selected fingerbreaker. \n"); break;
			case 5: set = 1000; System.out.println("You selected endless wave mode. \n"); break;
			default: set = 3; System.out.println("You selected easy. \n"); break;
		}
		
		Player p = new Player(name);
		System.out.println(p.getName()+" wields "+p.getAt().getName().toUpperCase()+" and wears "+p.getAa()[0].getName().toUpperCase()+".\n");
		Dungeon d;
		
		while(flag) {
			flag = false;
			d = new SubDungeon(set, p);
			System.out.println("\n***********************************************************************");
			System.out.println("\nEntering the "+d.getDunName()+"!\n");
			System.out.println("***********************************************************************\n");
			
			Place[] floors = d.getFloors();
			
			for(int i = 0; i<floors.length;i++) {
				if(floors[i].isRest()) {
					floors[i].encounter(p);
					
				}else {
					for(int j = 0; j < floors[i].getEnemies().length;j++) {
						floors[i].encounter(p);
						if(p.isDead()) {
							flag = false;
							i = 90000;
							j = 90000;
							break;
						}
					}
				}
				if(!p.isDead()) {
					System.out.println("\n**Floor "+floors[i].getFloorNum()+" cleared**\n");
					System.out.println("("+(floors.length - floors[i].getFloorNum())+") Floors left in the dungeon!\n");
				}
			}
			if(!p.isDead()) {
				System.out.println("\n***********************************************************************");
				System.out.println("\nThe "+d.getDunName()+" cleared!\n");
				System.out.println("***********************************************************************\n");
				System.out.println("New dungeon? (y/n)");
				
				choice = read.nextLine();
				//read.close();
				if(choice.trim().charAt(0)=='y') {
					
					flag = true;
				}else {
					flag = false;
				}
			}	
		}
		
		if(!p.isDead()) {
			System.out.println("\nYou win!\n");
			System.out.println("Total score: "+p.getGold());
			System.out.println("Player level: "+p.getLevel());
		} else {
			System.out.println("You died..");
			System.out.println("Your body reanimates into a monster for the next explorer to face..");
		}
		System.out.println("\nEXITING GAME");
		
	}

}
