package objects;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		String name = "";
		int difficulty = 0, set = 3;
		boolean flag = true;
		
		while(flag) {
			try {
				flag = false;
				System.out.println("Please enter your name:");
				name = read.next();
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
		
		switch(difficulty) {
			case 1: set = 3; System.out.println("You selected easy. \n"); break;
			case 2: set = 7; System.out.println("You selected normal. \n"); break;
			case 3: set = 15; System.out.println("You selected hard. \n"); break;
			case 4: set = 27; System.out.println("You selected fingerbreaker. \n"); break;
			case 5: set = 1000; System.out.println("You selected endless wave mode. \n"); break;
			default: set = 3; System.out.println("You selected easy. \n"); break;
		}
		
		Player p = new Player(name);
		System.out.println(p.getName()+" wields "+p.getAt().getName().toUpperCase()+".\n");
		Dungeon d = new SubDungeon(set, p);
		Place[] floors = d.getFloors();
		
		for(int i = 0; i<floors.length;i++) {
			if(floors[i].isRest()) {
				floors[i].encounter(p);
				
			}else {
				for(int j = 0; j < floors[i].getEnemies().length;j++) {
					floors[i].encounter(p);

				}
			}	
			System.out.println("\n**Floor "+floors[i].getFloorNum()+" cleared**\n");
			System.out.println("("+(floors.length - floors[i].getFloorNum())+") Floors left in the dungeon!");
			
		}
		System.out.println("\nYou win!\n");
		System.out.println("Total score: "+p.getGold());
		System.out.println("Player level: "+p.getLevel());
		
		System.out.println("\nEXITING GAME");
	}

}
