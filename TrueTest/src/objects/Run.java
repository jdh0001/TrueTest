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
			//hidden difficulty
			case 5: set = 1000; System.out.println("You selected endless wave mode. \n"); break;
			default: set = 3; System.out.println("You selected easy. \n"); break;
		}
		
		Player p = new Player(name);
		//initial equipment set readout to make sure player is actually equipped
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
					//player is not dead -> new dungeon floor
					System.out.println("\n**Floor "+floors[i].getFloorNum()+" cleared**\n");
					System.out.println("("+(floors.length - floors[i].getFloorNum())+") Floors left in the dungeon!\n");
				}
			}
			if(!p.isDead()) {
				//player alive, dungeon complete, offers to do new dungeon
				System.out.println("\n***********************************************************************");
				System.out.println("\nThe "+d.getDunName()+" cleared!\n");
				System.out.println("***********************************************************************\n");
				System.out.println("New dungeon? (y/n)");
				
				choice = read.next();
				//read.close();
				if(choice.trim().charAt(0)=='y') {
					
					flag = true;
				}else {
					flag = false;
				}
				read.nextLine();
			}	
		}
		
		String bravery = "Unknown";
		int runs = p.getRunCount();
		if(runs>=(set*3)) {
			bravery = "coward";
		}else if(runs>=(set*2)) {
			bravery = "normal person";
		}else if(runs>=set) {
			bravery = "brave person";
		}else if(runs>0) {
			bravery = "hero";
		}else if(runs == 0) {
			bravery = "hero of legend";
		}
		
		if(!p.isDead()) {
		
			System.out.println("\nYou win!\n");
			System.out.println("Total score: "+p.getGold());
			System.out.println("Player level: "+p.getLevel());
			System.out.println("Bravery level: "+bravery.toUpperCase());	
			
		} else {
			if(runs == 0) bravery = "hero";
			System.out.println("You died a "+bravery+"..");
			System.out.println("Your body reanimates into a monster for the next explorer to face..");
		}
		System.out.println("\nEXITING GAME");
		
	}

}
