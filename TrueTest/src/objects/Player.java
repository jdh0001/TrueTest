package objects;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Player {
	private static String name;
	//Required for life, no 0's
	private static int health;
	private static int stamina;
	private static int mana;
	
	//Only level is necessary to not be 0
	private static int level;
	private static int exp;
	private static int gold;
	
	private static Weapon at;
	private static Armor[] aa;
	
	private int deathCount;
	private boolean death;
	
	//They can all be 0 but should not in most cases
	private static int mAtk;
	private static int pAtk;
	private static int mDef;
	private static int pDef;
	
	
	//They can be 0 
	private static int agility;
	private static int luck;
	private static int armorScore;
	
	private static Item[] inventory;
	private static int oldestArmor;
	private static Item[] hotbar;
	private static int cowardCount;
	//Type 0 - Health Restore
	//Type 1 - Stamina Restore
	//Type 2 - Mana Restore
	//Type 3 - Agility Buff
	//Type 4 - Armor Score Buff
	//Type 5 - Remove Status Effects
	
	public Player(String n) {
		name = n;
		if(name == "") name = "Idiot McLoserBoy Jr.";
		deathCount = 0;
		death = false;
		health = ThreadLocalRandom.current().nextInt(15,31);
		stamina = ThreadLocalRandom.current().nextInt(15,31);
		mana = ThreadLocalRandom.current().nextInt(15,31);
		level = 1;
		exp = 0;
		gold = 5;
		at = new Weapon(0);
		aa = new Armor[8];
		aa[0] = new Armor(0,0,false);
		aa[1] = new Armor(0,0,false);
		luck = 1;
		agility = ThreadLocalRandom.current().nextInt(4,16);
		inventory = new Item[15];
		hotbar = new Item[6];
		armorScore = 0;
		int throwAway = consolidatePArmor();
		oldestArmor = 0;
	}
	
	public static void increaseExp(int e) {
		if(e < 0) e = 0;
		int next = getNextLevelExp();
		if((e+exp) >= next) levelUp((e+exp), next);
		
		
	}
	
	
	private static int getNextLevelExp() {
		int temp = level;
		if(temp < 5 ) {temp = 1;} else
		if(temp < 10) {temp = 5;} else
		if(temp < 15) {temp = 10;} else
		if(temp < 20) {temp = 15;} else
		if(temp < 25) {temp = 20;} else
		if(temp < 30) {temp = 25;} else
		if(temp < 35) {temp = 30;} else
		if(temp < 40) {temp = 35;} else
		if(temp < 45) {temp = 40;} else
		if(temp < 50) {temp = 45;} else
		if(temp < 55) {temp = 50;} else
		if(temp < 60) {temp = 55;} else
		if(temp < 65) {temp = 60;} else
		if(temp < 70) {temp = 65;} else
		if(temp < 75) {temp = 70;} else
		if(temp < 80) {temp = 75;} else
		if(temp < 85) {temp = 80;} else
		if(temp < 90) {temp = 85;} else
		if(temp < 95) {temp = 90;} else
		if(temp >= 95) {temp = 95;}
	
		switch(temp) {
			case 1:	return 10;
			case 5: return 18;
			case 10:return 24;
			case 15:return 40;
			case 20:return 63;
			case 25:return 75;
			case 30:return 86;
			case 35:return 99;
			case 40:return 108;
			case 45:return 120;
			case 50:return 133;
			case 55:return 145;
			case 60:return 157;
			case 65:return 170;
			case 70:return 185;
			case 75:return 200;
			case 80:return 225;
			case 85:return 250;
			case 90:return 300;
			default: return -1;
		}	
		
	}
	
	private static void levelUp(int exReserve, int next) {
		exReserve = exReserve - next;
		level++;
		next = getNextLevelExp();
		
		health += ((level % 10) + ThreadLocalRandom.current().nextInt(0,11));
		stamina += ((level % 9) + ThreadLocalRandom.current().nextInt(0,11));
		mana += ((level % 9) + ThreadLocalRandom.current().nextInt(0,11));
		
		pAtk += ((level % 20) + ThreadLocalRandom.current().nextInt(0,6));
		mAtk += ((level % 15) + ThreadLocalRandom.current().nextInt(0,4));
		pDef += ((level % 18) + ThreadLocalRandom.current().nextInt(0,6));
		mDef += ((level % 15) + ThreadLocalRandom.current().nextInt(0,4));
		
		agility += (stamina % 5) + ThreadLocalRandom.current().nextInt(0,6);
		luck += ThreadLocalRandom.current().nextInt(0,6);
		
		System.out.println("\nYou leved up to level: "+level+"!\n");
		
		if(exReserve >= next) { levelUp(exReserve, next);}else {
			exp = exReserve;
		}
		
		if(exp < 0) System.err.println("Error occurred with level up. See Player: Line 113-123");
		
	}
	
	private static int consolidatePArmor() {
		int total=0;
		if(aa.length>0) {
			for(int i = 0; i<aa.length; i++) {
				Armor temp = aa[i];
				if(temp == null||temp == null) {} else {
					total += temp.getPdMod();
					armorScore++;
				}
			}
		}
		return total;
	}
	
	private static int consolidateMArmor() {
		int total=0;
		if(aa.length>0) {
			for(int i = 0; i<aa.length; i++) {
				Armor temp = aa[i];
				if(temp == null||temp == null) {} else {
					total += temp.getMdMod();
					
				}
			}
		}
		return total;
	}
	
	public int damageOutput(Creature attacker) {
		
		int physAtk = attacker.getpAtk();
		int atkAgi = attacker.getAgility();
		int magAtk = attacker.getmAtk();
		int atkLv = attacker.getLevel();
		int atkLck = attacker.getLuck();
		
		int physDef = pDef + consolidatePArmor();
		int defAgi = agility;
		int magDef = mDef + consolidateMArmor();
		int tarLv = level;
		int tarLck = luck;
		
		
		int totalPhysAtk = (int)(physAtk + (atkLv * atkLv / (physAtk+1)) + (atkAgi / 2));
		int totalMagAtk = (int)(magAtk + (atkLv + atkLv / (magAtk+1)));
		
		int totalAtk = (int) (totalMagAtk + totalPhysAtk);
		
		int totalPhysDef = (int) (physDef + (tarLv * tarLv / (physDef+1)) + (defAgi * .75));
		int totalMagDef = (int) (magDef + (tarLv * tarLv / (magDef+1)) + (tarLck / 3));
			
		
		int totalDef = (int) (totalPhysDef + totalMagDef);
		
		int magDam = totalMagAtk - totalMagDef;
		int physDam = totalPhysAtk - totalPhysDef;
		int finDamage = physDam;
		
		if(magDam>=physDam) finDamage = magDam;
		
		if(finDamage < 0) finDamage = 1;
		
		//Critical Hit if within range of luck
		if(ThreadLocalRandom.current().nextInt(1, atkLck+1) < (2+(atkLck/3))) {
			finDamage *= 2;
			System.out.println("CRITICAL HIT!\n");
		}
		
		
		
		return finDamage;
		
	}
	
	public int getOldestArmor() {
		return oldestArmor;
	}
	
	public void incrementOldestArmor() {
		oldestArmor++;
	}
	
	public int getHealth() {
		
		return health;
	}

	public static int getGold() {
		return gold;
	}

	public static void increaseGold(int gp) {
		gold += gp;
	}
	
	public static void decreaseGold(int gp) {
		gold -= gp;
		if(gold < 0) gold = 0;
	}
	
	public void increaseDeathCount() {
		deathCount++;
		if(deathCount >= 3) {
			death = true;
		}
	}
	
	public static void clearInventory() {
		inventory = new Item[15];
	}
	
	public static void addInventory(Item t) {
		int size = inventory.length;
		boolean placed = false, flag = true;
		Scanner read = new Scanner(System.in);
		String choice = "n";
		for(int i = 0; i < size; i++) {
			if(inventory[i] == null) {
				placed = true;
				inventory[i] = t;
				break;
			}
		}
		if(!placed) {
			while(flag) {
				try {
					flag = false;
					System.out.println("Inventory is full. Replace an item of lesser value? (y/n)");
					choice = read.next();
				}catch(Exception e) {
					flag = true;
				}
			}
			if(choice.trim().charAt(0)=='y') {	
				Item temp = null;
				for(int i = 0; i < size; i++) {
					if(inventory[i].getValue() < t.getValue()) {
						inventory[i] = t;
						flag = true;
						break;
					}
				}
				if(flag) {
					System.out.println("Replaced item worth "+temp.getValue()+" for item worth"+t.getValue());
				}else {
					System.out.println("There were no items of lesser value, so it was thrown away.");
				}
			}else {
				System.out.println("Item was thrown away.");
			}
			
		}
	}

	public String getName() {
		return name;
	}

	public int getStamina() {
		return stamina;
	}
	
	public boolean isDead() {
		return death;
	}
	
	public int getMana() {
		return mana;
	}

	public int getLevel() {
		return level;
	}

	public Weapon getAt() {
		return at;
	}

	public Armor[] getAa() {
		return aa;
	}

	public int getmAtk() {
		return mAtk;
	}

	public int getpAtk() {
		return pAtk;
	}

	public int getmDef() {
		return mDef;
	}

	public int getpDef() {
		return pDef;
	}

	public int getAgility() {
		return agility;
	}

	public int getLuck() {
		return luck;
	}

	public int getArmorScore() {
		return armorScore;
	}

	public Item[] getInventory() {
		return inventory;
	}
	
	public void setWeapon(Weapon w) {
		at = w;
	}

	public int getRunCount() {
		return cowardCount;
	}
	
	public void increaseRunCount() {
		cowardCount++;
	}
	
	public Item[] getHotBar(){
		return hotbar;
	}
}
