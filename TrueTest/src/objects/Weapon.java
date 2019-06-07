package objects;

import java.util.concurrent.ThreadLocalRandom;

public class Weapon extends Item {
	
	private static int paMod;
	private static int maMod;
	
	private static int paType;
	//Type 0 - Pierce
	//Type 1 - Slash
	//Type 2 - Bludgeon
	
	private static int maType;
	//Type 0 - None
	//Type 1 - Fire
	//Type 2 - Water
	//Type 3 - Wind
	//Type 4 - Earth
	//Type 5 - Light
	//Type 6 - Dark
	//Type 7 - Lightning
	
	//private boolean dualWield;
	//can be dual wielded or not
	private String name;
	
	public Weapon(String n, String d, String sN, int val, int wt, int rar, int iT, int pam, int mam, int pat, int mat) {
		super(d, sN, val, wt, rar, iT);
		name = n;
		paMod = pam;
		maMod = mam;
		paType = pat;
		maType = mat;
		
		
		if(paMod <= 0) paMod = 1;
		if(maMod < 0) maMod = 0;
		if(paType < 0 || paType > 2) paType = 2;
		if(maType < 0 || maType > 7) maType = 0;
		//to add random magic type let 'mat = 0' and 'mam > 0'
		if(maMod != 0 && maType == 0) maType = ThreadLocalRandom.current().nextInt(1, 8);
		if(maType != 0 && maMod == 0) maMod = 1;
		
		
	}
	
	public Weapon(int iT, int rar) {
		super(iT,rar);
		paMod = ThreadLocalRandom.current().nextInt(1,21);
		maMod = ThreadLocalRandom.current().nextInt(1,21);;
		paType = ThreadLocalRandom.current().nextInt(0,3);;
		maType = ThreadLocalRandom.current().nextInt(0,8);;
		name = Formula.weaponName(paType, maType);
	}
	
	public Weapon() {
		super();
		name = "???";
		paMod = 1;
		maMod = 0;
		paType = 2;
		maType = 0;
		//dualWield = false;
	}
	
	public Weapon(int rar){
		super(0,rar);
		//if(ThreadLocalRandom.current().nextInt(0, 2) == 1) {dualWield = true;}else {dualWield = false;}
		maType = ThreadLocalRandom.current().nextInt(0, 8);
		paType = ThreadLocalRandom.current().nextInt(0, 3);
		name = Formula.weaponName(paType, maType);
		genStats(rar);
	}
	
	public Weapon(int rar, int a, int b) {
		super(0,rar,a,b);
		maType = b;
		paType = a;
		genStats(rar);
	}
	
	private static void genStats(int rar) {
		
		if(maType == 0) {
			maMod = 0;
		}else if(maType <= 4){
			maMod = ThreadLocalRandom.current().nextInt(1, 26) * (maType + ThreadLocalRandom.current().nextInt(0, 6));
		}else if(maType > 4) {
			maMod = ThreadLocalRandom.current().nextInt(5, 31) * (maType);
		}	
		paMod = ThreadLocalRandom.current().nextInt(4, 26) * (paType + 2);
		
	}
	
	public int getPaMod() {
		return paMod;
	}
	public String getName() {
		return name;
	}

	public int getMaMod() {
		return maMod;
	}

	public int getPaType() {
		return paType;
	}

	public int getMaType() {
		return maType;
	}

//	public boolean isDualWield() {
//		return dualWield;
//	}

	

}
