package objects;

import java.util.concurrent.ThreadLocalRandom;

public class Armor extends Item {
	
	private static int pdMod;
	private static int mdMod;
	
	private static boolean metalArmor;
	//for false use left column
	//for true use right column
	
	private static int material;
	//Type 0 - Boar      / Wood
	//Type 1 - Wolf      / Iron
	//Type 2 - Bear      / Steel
	//Type 3 - Dire Wolf / Mithril
	//Type 4 - Ogre      / Orichalcum
	//Type 5 - Demon     / Adamantine
	//Type 6 - Dragon    / Radiant
	
	private String name;
	
	
	public Armor(String n, String d, String sN, int val, int wt, int rar, int iT, int pdm, int mdm, int aT, int mtrl, boolean mA) {
		super(d, sN, val, wt, rar, iT);
		name = n;
		pdMod = pdm;
		mdMod = mdm;
		//aType = aT;
		material = mtrl;
		metalArmor = mA;
		
		if(pdMod <= 0) pdMod = 1;
		if(mdMod < 0) mdMod = 0;
		//if(//aType < 0 || //aType > 2) //aType = 0;
		if(material < 0 || material > 6) material = 0;
		
	}

	public Armor() {
		super();
		name ="!!!";
		pdMod = 1;
		mdMod = 0;
		//aType = 0;
		material = 0;
		metalArmor = false;
		
		
	}
	
	public Armor(int rar, int mat, boolean metal) {
		super(rar,mat,metal);
		name = Formula.armorName(mat,metal);
		material = mat;
		metalArmor = metal;
		genStats(rar);
	}
	
	private static void genStats(int rar) {
		if(metalArmor) {
			pdMod = ThreadLocalRandom.current().nextInt(4, 26) * (material+2);
			mdMod = (int)(pdMod * .7 + ThreadLocalRandom.current().nextInt(1, 11));
		} else {
			pdMod = ThreadLocalRandom.current().nextInt(4, 21) * (material+1);
			if(material > 3) { mdMod = (ThreadLocalRandom.current().nextInt(4, 26) * (material+1)); }else {
				mdMod = (int)(pdMod * .7 + ThreadLocalRandom.current().nextInt(0, 14));
			}
		}
				
	}

	public int getPdMod() {
		return pdMod;
	}

	public int getMdMod() {
		return mdMod;
	}

	public boolean isMetalArmor() {
		return metalArmor;
	}

	//public int getaType() {
	//	return //aType;
	//}

	public int getMaterial() {
		return material;
	}
	public String getName() {
		return name;
	}

}
