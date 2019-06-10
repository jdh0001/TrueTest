package objects;

import java.util.concurrent.ThreadLocalRandom;

public class Monster extends Creature {
	
	private int paType;
	//Type 0 - Pierce
	//Type 1 - Slash
	//Type 2 - Bludgeon
	
	private int maType;
	//Type 0 - None
	//Type 1 - Fire
	//Type 2 - Water
	//Type 3 - Wind
	//Type 4 - Earth
	//Type 5 - Light
	//Type 6 - Dark
	//Type 7 - Lightning
	
	private int pWeakness;
	//Type 0 - Pierce
	//Type 1 - Slash
	//Type 2 - Bludgeon
	//Type 3 - None
	
	private int[] mWeakness;
	//Type 0 - None
	//Type 1 - Fire
	//Type 2 - Water
	//Type 3 - Wind
	//Type 4 - Earth
	//Type 5 - Light
	//Type 6 - Dark
	//Type 7 - Lightning
	
	
	private String name;
	
	
	public Monster(String n, String d, String sN, int hp, int stm, int man, int lv, int ex, int gp, int ma, int pa,
			int md, int pd, int aglt, int lck, int aS, int cT, int pat, int mat, int pw, int[] mw) {
		super( d, sN, hp, stm, man, lv, ex, gp, ma, pa, md, pd, aglt, lck, aS, cT);
		name = n;
		paType = pat;
		maType = mat;
		pWeakness = pw;
		mWeakness = mw;
		
		if(paType < 0 || paType > 2) paType = 0;
		if(maType < 0 || maType > 7) maType = 0;
		if(pWeakness < 0 || pWeakness > 3) pWeakness = 3;
		if(mWeakness.length == 0) mWeakness = new int[] {0};
		
		int temp = mWeakness.length, pos=0;
		int[] store = new int[temp]; 
		
		for(int i = 0; i<temp; i++) {
			if(mWeakness[i]<0 || mWeakness[i]>3) {
			}else {
				store[pos] = mWeakness[i];
				pos++;
			}
		}
		mWeakness = store;
		
		
	}
	public Monster(int lv, int cT) {
		super(lv, 1);
		name = Formula.monsterName();;
		paType = ThreadLocalRandom.current().nextInt(0,3);
		maType = ThreadLocalRandom.current().nextInt(0,8);
		pWeakness = ThreadLocalRandom.current().nextInt(0,4);
		mWeakness = new int[] {ThreadLocalRandom.current().nextInt(0,8)};
	}

	public Monster() {
		super();
		name ="...";
		paType = 0;
		maType = 0;
		pWeakness = 1;
		mWeakness = new int[] {0};
		
	}

	public int damageOutput(Player attacker, Weapon w) {
		
		Monster target = this;
		
		int physAtk = attacker.getpAtk();
		int atkAgi = attacker.getAgility();
		int magAtk = attacker.getmAtk();
		int atkLv = attacker.getLevel();
		int atkLck = attacker.getLuck();
		
		int physDef = target.getpDef();
		int defAgi = target.getAgility();
		int magDef = target.getmDef();
		int tarLv = target.getLevel();
		int tarLck = target.getLuck();
		
		int wpMod = w.getPaMod();
		int wmMod = w.getPaMod();
		int wpa = w.getPaType();
		int wma = w.getMaType();
		
		
		
		int totalPhysAtk = (int)(physAtk + wpMod + (atkLv * atkLv / (physAtk+1)) + (atkAgi / 2));
		int totalMagAtk = (int)(magAtk + wmMod + (atkLv + atkLv / (magAtk+1)));
		
		int totalAtk = (int) (totalMagAtk + totalPhysAtk);
		
		int totalPhysDef = (int) (physDef + (tarLv * tarLv / (physDef+1)) + (defAgi * .75));
		int totalMagDef = (int) (magDef + (tarLv * tarLv / (magDef+1)) + (tarLck / 3));
		
		if(target.pWeakness == wpa) totalPhysDef = (int)(totalPhysDef * .5);
		
		for(int i = 0; i < mWeakness.length; i++) {
			if(target.mWeakness[i] == wma) {
				totalMagDef = (int)(totalMagDef * .5);
				break;
			}
		}
		
		int totalDef = (int) (totalPhysDef + totalMagDef + 6);
		

		int magDam = totalMagAtk - totalMagDef;
		int physDam = totalPhysAtk - totalPhysDef;
		int finDamage = physDam;
		
		if(magDam>=physDam) finDamage = magDam;
		
		//Critical Hit if within range of luck
		if(ThreadLocalRandom.current().nextInt(1, atkLck+1) < (2+(atkLck/5))) {
			finDamage *= 2;
			System.out.println("CRITICAL HIT!\n");
		}
		
		if(finDamage < 0) finDamage = 0;
		
		return finDamage;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return super.getDescription();
	}
	
	public int getHealth() {
		return super.getHealth();
	}

	public int getStamina() {
		return super.getStamina();
	}

	public int getMana() {
		return super.getMana();
	}

	public int getLevel() {
		return super.getLevel();
	}

	public int getExp() {
		return super.getExp();
	}

	public int getGold() {
		return super.getGold();
	}

	public int getmAtk() {
		return super.getmAtk();
	}

	public int getpAtk() {
		return super.getpAtk();
	}

	public int getmDef() {
		return super.getmDef();
	}

	public int getpDef() {
		return super.getpDef();
	}

	public int getAgility() {
		return super.getAgility();
	}

	public int getLuck() {
		return super.getLuck();
	}

	public int getArmorScore() {
		return super.getArmorScore();
	}

	public int getcType() {
		return super.getcType();
	}

	public Item[] getDrops() {
		return super.getDrops();
	}
	
}
