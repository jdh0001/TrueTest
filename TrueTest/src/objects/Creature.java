package objects;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Creature extends Thing {
	//Required for life, no 0's
	private static int health;
	private static int stamina;
	private static int mana;
	
	//Only level is necessary to not be 0
	private static int level;
	private static int exp;
	private static int gold;
	
	//They can all be 0 but should not in most cases
	private static int mAtk;
	private static int pAtk;
	private static int mDef;
	private static int pDef;
	
	//They can be 0 
	private static int agility;
	private static int luck;
	private static int armorScore;
	
	private static int cType;
	//Type 0 - Beast
	//Type 1 - Monster
	//Type 2 - Sentient
	
	private static Item[] drops;
	
	
	public Creature(String d, String sN, int hp, int stm, int man, int lv,
			int ex, int gp, int ma, int pa, int md, int pd, int aglt, int lck, int aS, int cT) {
		super(d, sN);
		
		health = hp;
		stamina = stm;
		mana = man;
		
		level = lv;	
		exp = ex;
		gold = gp;
		
		mAtk = ma;
		pAtk = pa;	
		mDef = md;
		pDef = pd;
		
		agility = aglt;
		luck = lck;	
		armorScore = aS;
		
		cType = cT;
		
		if(health <= 0) health = 1;
		if(stamina <= 0) stamina = 1;
		if(mana <= 0) mana = 1;
		if(level <= 0) {level = 1;}else if(level > 89) {level = 89;}
		
		if(exp < 0) exp = 0;
		if(gold < 0) gold = 0;
		if(mAtk < 0) mAtk = 0;
		if(pAtk < 0) pAtk = 0;
		
		if(mDef < 0) mDef = 0;
		if(pDef < 0) pDef = 0;
		if(agility < 0) agility = 0;
		if(luck < 0) luck = 0;
		
		if(armorScore < 0) armorScore = 1;
		
		if(cType < 0 || cType > 2) cType = 0;
		
		
	}

	public Creature() {
		super();
		
		health = 1;
		stamina = 1;
		mana = 1;
		level = 1;
		
		exp = 0;
		gold = 0;
		mAtk = 1;
		pAtk = 1;
		
		mDef = 1;
		pDef = 1;
		agility = 1;
		luck = 1;
		
		armorScore = 0;
		cType = 0;
	}
	
	
	public Creature(String d, String sN, int lv, int cT) {
		super(d,sN);
		
		level = lv;
		cType = cT;
		if(level <= 0) level = 1;
		
		generateStats();
		generateDrops();
		
	}
	
	public Creature(int lv, int cT) {
		
		//super("1",cT,0,false);
		cType = cT;
		level = lv;
		generateStats();
		generateDrops();
		
	}
	
	/*Used to randomly generate a creature's statistics based on level and cType*/
	private static void generateStats() {
		
		//Beast
		if(cType == 0) {
			
			health = (int)(5 * level + ThreadLocalRandom.current().nextInt(0, (10+level)));
			mana = (int)(1 + (level/2));
			stamina = (int)((health * .9) + level);
			armorScore = (int)(ThreadLocalRandom.current().nextInt(0,2));

			
			pAtk = (int)(level + (health * .6)); 
			if(armorScore > 0) { 
				pDef = (int)(level + (health * .75)); 
			}else {
				pDef = (int)(level + (health * .55));
			}
			mAtk = (int)(level/3);
			mDef = (int)(level/2);
			
			agility = (int)(((stamina - ((pAtk + pDef) / 5))) + level);
			luck = (int)(ThreadLocalRandom.current().nextInt(1,(12+level)));
			
			exp = (int)(ThreadLocalRandom.current().nextInt(1, 6) * level);
			gold = (int)(ThreadLocalRandom.current().nextInt(0,level+1)+1);
			
			
		}else 
		//Monster	
		if (cType == 1) {
			
			health = (int)(10 * level + ThreadLocalRandom.current().nextInt(0, (15+level)));
			mana = (int)(1 + (level) + (health/(ThreadLocalRandom.current().nextInt(2, 5))));
			stamina = (int)((health * .8) + level);
			armorScore = (int)(ThreadLocalRandom.current().nextInt(0,4));
			
			pAtk = (int)(level + ((health * ThreadLocalRandom.current().nextInt(2, 5)) / ThreadLocalRandom.current().nextInt(4, 7))); 
			pDef = (int)(level + (health * (ThreadLocalRandom.current().nextInt((2+armorScore), 6) / ThreadLocalRandom.current().nextInt(4, (9-armorScore-1)))));
			mAtk = (int)(level + (pAtk*.75));
			if(armorScore > 0) {
				mDef = (int)(level + (pDef * .50 * armorScore));
			} else {
				mDef = (int)(level + (pDef * .45) + 3);
			}
			agility = (int)((stamina * .65) + level);
			luck = (int)(ThreadLocalRandom.current().nextInt(1,(12+level)));
			
			exp = (int)(ThreadLocalRandom.current().nextInt(1, 11) * level);
			gold = (int)(ThreadLocalRandom.current().nextInt(0,(level+10))+1);
			
			
		}else
		//Sentient	
		if(cType == 2) {
			
			health = (int)(4 * level + ThreadLocalRandom.current().nextInt(0, (7+level)));
			mana = (int)(1 + (level) + (health/(ThreadLocalRandom.current().nextInt(2, 5))));
			stamina = (int)((health * .8) + level);
			armorScore = (int)(ThreadLocalRandom.current().nextInt(0,5));
			
			pAtk = (int)(level + (health * ThreadLocalRandom.current().nextInt(1, 6) / ThreadLocalRandom.current().nextInt(4, 7)) + (stamina / 4)); 
			pDef = (int)(level + (health * (ThreadLocalRandom.current().nextInt((1+armorScore), 7) / ThreadLocalRandom.current().nextInt(4, (10-armorScore-1)))));
			mAtk = (int)(level + (pAtk * (ThreadLocalRandom.current().nextInt(0,(5 + (mana / 4))) / 4)));
			mDef = (int)(level + (pDef * (ThreadLocalRandom.current().nextInt(0,(5 + (mana / 4))) / 4)));
			
			agility = (int)((stamina * (ThreadLocalRandom.current().nextInt(0,(5 + (mana / 4))))) + level);
			luck = (int)(ThreadLocalRandom.current().nextInt(1,(12+level)));		
			
			exp = (int)(ThreadLocalRandom.current().nextInt(1, 17) * level);
			gold = (int)(ThreadLocalRandom.current().nextInt(0,(level+20))+5);
			
		}else {
			System.err.println("Error cType = "+cType+" is not valid. Expected values (0,1,2).");
		}
		
		
		
	}
	
	private static void generateDrops(){
		
		drops = new Item[ThreadLocalRandom.current().nextInt(0,5)];
		
		int rare = ThreadLocalRandom.current().nextInt(0,(int)(level/15 +1));
		boolean met = false;
		if(cType == 0) {}else if(ThreadLocalRandom.current().nextInt(0,3)==1){met = true;}
		
		
		Item misc1 = new Misc(3, ThreadLocalRandom.current().nextInt(0,(int)(level/15 +1)));
		Item misc2 = new Misc(3, ThreadLocalRandom.current().nextInt(0,(int)(level/15 +1)));
		Item consum1 = new Misc(ThreadLocalRandom.current().nextInt(0,(int)(level/15 +1)), ThreadLocalRandom.current().nextInt(0,6));
		Item armor1 = new Armor(rare, ThreadLocalRandom.current().nextInt(0,(rare+3)), met);
		Item weapon1 = new Weapon(ThreadLocalRandom.current().nextInt(0,(int)(level/15 +1)), 
				ThreadLocalRandom.current().nextInt(0,3), 
				ThreadLocalRandom.current().nextInt(0,9));
		
		Item[] potential = new Item[] {misc2, consum1, armor1, weapon1}; 
		
		if(drops.length==0) {} else {
			for(int i = 0; i < drops.length; i++) {
				if(i == 0) drops[i] = misc1;
				if(i != 0) drops[i] = potential[ThreadLocalRandom.current().nextInt(0,(4-i+1))];
			}
		}
		
	}
	
	public int getHealth() {
		return health;
	}

	public int getStamina() {
		return stamina;
	}

	public int getMana() {
		return mana;
	}

	public int getLevel() {
		return level;
	}

	public int getExp() {
		return exp;
	}

	public int getGold() {
		return gold;
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

	public int getcType() {
		return cType;
	}

	public Item[] getDrops() {
		return drops;
	}
	
//	public String getName() {
//		return super.getName();
//	}
	
	public String getDescription() {
		return super.getDescription();
	}
	
	
}
