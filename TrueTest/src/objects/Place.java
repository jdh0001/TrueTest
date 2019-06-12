package objects;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Place {
	private String name;
	private int floorNum;
	private boolean rest;
	private Creature[] enemies;
	private int placeHolder;
	private Dungeon dun;
	
	
	public Place(boolean r, int floorN, Player p, Dungeon d) {
		dun = d;
		floorNum = floorN;
		placeHolder = 0;
		name = "Floor "+floorNum;
		rest = r;
		if(!r) {
			genEnemies(p);
		}
	}
	
	private void genEnemies(Player p) {
		int numEnemies = ThreadLocalRandom.current().nextInt(1,6*floorNum);
		int enemType = 0, levelRange = ThreadLocalRandom.current().nextInt((0+p.getLevel()),3+(p.getLevel()));
		enemies = new Creature[numEnemies];
		for(int i = 0; i < numEnemies; i++) {
			enemType = ThreadLocalRandom.current().nextInt(0,4);
			
			if(enemType == 1) {
				enemies[i] = new Monster(levelRange,1);
			}else if(enemType == 2) {
				enemies[i] = new Sentient(levelRange,2);
			}else {
				enemies[i] = new Beast(levelRange,0);
			}
			
		}
	}
	
	public void encounter(Player p) {
		Scanner read = new Scanner(System.in);
		String choice = "n";
		boolean flag = true;
		if(rest) {
			System.out.println("You are in a safe area, there are no enemies here.\n");
			System.out.println("A strong looking old man wants to buy your excess items.");
			while(flag) {
				try {
					flag = false;
					System.out.println("Sell your items? (y/n)");
					choice = read.next();
				}catch(Exception e) {
					flag = true;
				}
				
			}
			if(choice.trim().charAt(0) =='y') {
				int size = p.getInventory().length, total = 0, sold = 0;
				Item[] dummyInv = p.getInventory();
				for(int i = 0; i < size; i++) {
					if(dummyInv[i] == null) {break;} else {
						total += dummyInv[i].getValue();	
						sold++;
					}
				}
				System.out.println(p.getName()+" sold "+sold+" items for "+total+" gold.");
				p.increaseGold(total);
				if(sold>0) {
					System.out.println("The old man is delighted to increase his stock of items");
					p.clearInventory();
				}else {
					System.out.println("The old man is disgusted you wasted his time.");
				}
				
			} else {
				System.out.println("You chose not to sell. The old man seems disappointed..\n");
			}
			
			System.out.println("Would you like to buy equipment?(y/n)");
			choice = "n";
			choice = read.next();
			int opt = 0;
			boolean buy = true;
 			
			if(choice.trim().toLowerCase().charAt(0)=='y') {
				int broke = 0;
				while(buy) {
					buy = false;
					System.out.println("This shop sells armor and weapons.\n");
					try {
						System.out.println("Input 1 to buy a WEAPON or 0 to buy ARMOR");
						opt = read.nextInt();
					}catch(Exception e) {
						
					}
					if(p.getGold()>25) {
						if(opt==0) {
							Weapon temp = p.getAt();
							Weapon better = new Weapon(temp);
							if(better.getValue()>p.getGold()) {
								System.out.println("You cannot afford this WEAPON.");
								broke++;
							}else {
								p.setWeapon(better);
								System.out.println("You equipped "+better.getName().toUpperCase()+"!\n");
								System.out.println(temp.getName()+" was placed in your inventory.\n");
								p.decreaseGold(better.getValue());
								System.out.println("You have "+p.getGold()+" gold left!\n");	
								
								for(int i = 0; i < p.getInventory().length; i++) {
									if(p.getInventory()[i] == null) {
										p.getInventory()[i] = temp;
										
									}
								}
							}
							
						}else if(opt==1) {
							Armor[] armory = p.getAa();
							int place = 0;
							for(int i = 0; i < armory.length; i++) {
								if(armory[i] == null) {
									place++;
									break;
								}else if(armory[i] != null && i == (armory.length-1)) {
									place = p.getOldestArmor();
									p.incrementOldestArmor();
								}
							}
							Armor temp = p.getAa()[place];
							Armor better = new Armor(temp);
							if(better.getValue()>p.getGold()) {
								System.out.println("You cannot afford this ARMOR.\n");
								broke++;
							}else {
								p.getAa()[place] = better;
								System.out.println("You equipped "+better.getName().toUpperCase()+"!\n");
								System.out.println(temp.getName()+" was placed in your inventory.\n");
								p.decreaseGold(better.getValue());
								System.out.println("You have "+p.getGold()+" gold left!\n");
								
								for(int i = 0; i < p.getInventory().length; i++) {
									if(p.getInventory()[i] == null) {
										p.getInventory()[i] = temp;
										
									}
								}
							}
						}//end opt
					}//end gold check
					
					System.out.println("Would you like to continue shopping?(y/n)");
					choice = read.next();
					if(choice.trim().toLowerCase().charAt(0)=='y') buy = true;
					if(broke >= 3) buy = false;
				}
				if(broke<3) {System.out.println("The old man seems to appreciate your business.\n\n");}else {
					System.out.println("The old man is disgusted by you..\n\n");
				}
			}
			
		}else {
			if(placeHolder >= enemies.length) { dun.setCurrentFloor(floorNum+1); placeHolder = 0;}else {
				//int type = enemies[placeHolder].getcType();
				Monster a;
				Sentient b;
				Beast c;
				boolean win = false;
				
				if(enemies[placeHolder] instanceof Monster) {
					enemies[placeHolder].generateStats();
					a = (Monster) enemies[placeHolder];
					win = Formula.battle(p,a);
				}else if(enemies[placeHolder] instanceof Sentient) {
					enemies[placeHolder].generateStats();
					b = (Sentient) enemies[placeHolder];
					win = Formula.battle(p,b);
				}else if(enemies[placeHolder] instanceof Beast) {
					enemies[placeHolder].generateStats();
					c = (Beast) enemies[placeHolder];
					win = Formula.battle(p,c);
				}
				
				if(win) placeHolder++;
				
				if(placeHolder >= enemies.length) dun.setCurrentFloor(floorNum+1);
			}
		}
	}
	

	public String getName() {
		return name;
	}

	public boolean isRest() {
		return rest;
	}

	public Creature[] getEnemies() {
		return enemies;
	}

	public int getPlaceHolder() {
		return placeHolder;
	}
	
	public int getFloorNum() {
			return floorNum;
	}
}
