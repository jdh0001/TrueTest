package objects;

import java.util.concurrent.ThreadLocalRandom;

public class Consumable extends Item {

	private static int modAmt;
	
	private static int specType;
	//Type 0 - Health Restore
	//Type 1 - Stamina Restore
	//Type 2 - Mana Restore
	//Type 3 - Agility Buff
	//Type 4 - Armor Score Buff
	//Type 5 - Remove Status Effects
	
	private String name;
	
	
	public Consumable(String n, String d, String sN, int val, int wt, int rar, int iT, int sT, int mA) {
		super(d, sN, val, wt, rar, iT);
		name = n;
		specType = sT;
		modAmt = mA;
		
		if(modAmt < 0) modAmt = 10;
		if(specType < 0 || specType > 5) specType = 0;
		if(specType == 5) modAmt = 0;
		if(specType != 5 && modAmt%10 !=0) modAmt = 10; 
		if(specType != 5 && modAmt == 0) modAmt = 10;
		
		
	}

	public Consumable() {
		super();
		name = ",,,";
		specType = 0;
		modAmt = 10;
		
	}
	
	public Consumable(int rar, int sT) {
		super(2,rar);
		name = Formula.consumableName(sT);
		specType = sT;
		genStats(rar);
	}
	
	private static void genStats(int rar) {
		
		if(specType == 5) { modAmt = 0; } else {
			switch(rar) {
			case 0: modAmt = 10 + 10 * ThreadLocalRandom.current().nextInt(0, 2); break;
			case 1: modAmt = 10 + 10 * ThreadLocalRandom.current().nextInt(1, 3); break;
			case 2: modAmt = 10 + 10 * ThreadLocalRandom.current().nextInt(3, 7); break;
			case 3: modAmt = 10 + 10 * ThreadLocalRandom.current().nextInt(5, 10); break;
			case 4: modAmt = 10 + 10 * ThreadLocalRandom.current().nextInt(10, 21); break;
			default:	modAmt = 10; break;
			}
		}
		
	}
	

}
