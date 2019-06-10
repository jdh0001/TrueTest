package objects;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Item extends Thing {

	private int value;
	private int weight;
	
	private int rarity;
	//0 - Common
	//1 - Uncommon
	//2 - Rare
	//3 - Ultra Rare
	//4 - Only One
	//5 - Quest Item
	
	private int iType;
	//Type 0 - Weapon
	//Type 1 - Armor
	//Type 2 - Consumable
	//Type 3 - Misc
	
	
	public Item(String d, String sN, int val, int wt, int rar, int iT) {
		
		super(d, sN);
		
		value = val;
		weight = wt;
		rarity = rar;
		iType = iT;
		
		if(value < 0) value = 0;
		if(weight < 0) weight = 0;
		if(rarity < 0 || rarity > 5) rarity = 0;
		if(iType < 0 || iType > 3) iType = 3;
		
	}

	public Item() {
		super();
		
		value = 0;
		weight = 0;
		rarity = 0;
		iType = 3;
	}
	
	public Item(int iT, int rar) {
		//super("2", iT, 0, false);
		iType = iT;
		rarity = rar;
		genStats(false);
	}
	
	public Item(int iT, int rar, int a, int b) {
		//super("2", iT, a, b);
		iType = iT;
		rarity = rar;
	}
	
	public Item(int rar, int mat, boolean metal) {
		//super("2",1,mat,metal);
		iType = 1;
		rarity = rar;
		genStats(metal);
	}
	
	private void genStats(boolean metal) {
		
		if(iType == 0) {
			weight = ThreadLocalRandom.current().nextInt(1, 9);
			if(rarity == 5) { value = 0; } else {
				value = rarity * weight + ThreadLocalRandom.current().nextInt(10, 100);
			}
		}else
		if(iType == 1) {
			if(metal) { weight = ThreadLocalRandom.current().nextInt(5, 25); } else {
				weight = ThreadLocalRandom.current().nextInt(1, 16);
			}
			if(rarity == 5) { value = 0; } else {
				value = rarity * weight + ThreadLocalRandom.current().nextInt(10, 150);
			}
		}else
		if(iType == 2) {
			weight = ThreadLocalRandom.current().nextInt(0, 2);
			if(rarity == 5) { value = 0; } else {
				value = rarity * weight + ThreadLocalRandom.current().nextInt(0, 50) + 50;
			}
		}else
		if(iType == 3) {
			weight = ThreadLocalRandom.current().nextInt(0, 6);
			if(rarity == 5) { value = 0; } else {
				value = rarity * (weight + 1) + ThreadLocalRandom.current().nextInt(1, 500);
			}
		}else {
			weight = 0;
			value = 0;
		}
	}
	

//	public String getName() {
//		return super.getName();
//	}
	
	public int getValue() {
		return value;
	}

	public int getWeight() {
		return weight;
	}

	public int getRarity() {
		return rarity;
	}

	public int getiType() {
		return iType;
	}

	public String getDescription() {
		return super.getDescription();
	}
	
}
