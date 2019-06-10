package objects;

import java.util.concurrent.ThreadLocalRandom;

public class Beast extends Creature {
	
	private int atkType;
	//Type 0 - Pierce
	//type 1 - Slash
	//Type 2 - Bludgeon
	
	private int weakness;
	//Type 0 - Pierce
	//type 1 - Slash
	//Type 2 - Bludgeon
	
	private String name;
	
	
	public Beast(String n, String d, String sN, int hp, int stm, int man, int lv, int ex, int gp, int ma, int pa,
			int md, int pd, int aglt, int lck, int aS, int cT, int aT, int w) {
		super(d, sN, hp, stm, man, lv, ex, gp, ma, pa, md, pd, aglt, lck, aS, cT);
		name = n;
		atkType = aT;
		weakness = w;
		
		if(atkType < 0 || atkType > 2) atkType = 2;
		if(weakness < 0 || weakness > 2) weakness = 0;
	}

	public Beast() {
		super();
		atkType = 2;
		weakness = 0;
	}
	public Beast(String n, String d, String sN, int lv) {
		super(d,sN,lv,0);
		name = Formula.beastName();;
	}
	
	public Beast(int lv, int cT) {
		super(lv, 0);
		name = Formula.beastName();
		weakness = ThreadLocalRandom.current().nextInt(0,3);
		atkType = ThreadLocalRandom.current().nextInt(0,3);
	}

	public String tN() {
		return name;
	}
	
	public int damageOutput(Player p, Weapon w) {
		
		Beast target = this;
		
		int physAtk = p.getpAtk();
		int atkAgi = p.getAgility();
		int magAtk = p.getmAtk();
		int atkLv = p.getLevel();
		int atkLck = p.getLuck();
		
		int physDef = target.getpDef();
		int defAgi = target.getAgility();
		int magDef = target.getmDef();
		int tarLv = target.getLevel();
		int tarLck = target.getLuck();
		
		int wpMod = w.getPaMod();
		int wmMod = w.getPaMod();
		int wpa = w.getPaType();
		//int wma = w.getMaType();
		
		
		
		int totalPhysAtk = (int)(physAtk + wpMod + (atkLv * atkLv / (physAtk+1)) + (atkAgi / 2));
		int totalMagAtk = (int)(magAtk + wmMod + (atkLv + atkLv / (magAtk+1)));
		
		int totalAtk = (int) (totalMagAtk + totalPhysAtk);
		
		int totalPhysDef = (int) (physDef + (tarLv * tarLv / (physDef+1)) + (defAgi * .75));
		int totalMagDef = (int) (magDef + (tarLv * tarLv / (magDef+1)) + (tarLck / 3));
		
		if(target.weakness == wpa) totalPhysDef = (int)(totalPhysDef * .5);
		
		int totalDef = (int) (totalPhysDef + totalMagDef);
		
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
