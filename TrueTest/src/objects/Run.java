package objects;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		String name = "";
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
		Player p = new Player(name);
		System.out.println(p.getAt().getName()+"<---------------------------------");
		Dungeon d = new SubDungeon(3, p);
		Place[] floors = d.getFloors();
		
		for(int i = 0; i<floors.length;i++) {
			for(int j = 0; j<floors[i].getEnemies().length;j++) {
				floors[i].encounter(p);
			}
		}
		System.out.println("You win!");
		System.out.println("EXITING GAME");
	}

}
