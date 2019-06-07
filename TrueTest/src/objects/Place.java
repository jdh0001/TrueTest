package objects;

import java.util.concurrent.ThreadLocalRandom;

public class Place {
	private String name;
	private static int floorNum;
	private boolean rest;
	private static Creature[] enemies;
	private static int placeHolder;
	
	
	public Place(boolean r, int floorN, Player p) {
		floorNum = floorN;
		placeHolder = 0;
		name = "Floor "+floorNum;
		rest = r;
		if(!r) {
			genEnemies(p);
		}
	}
	
	private static void genEnemies(Player p) {
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
	
	public static void encounter(Player p) {
		if(placeHolder >= enemies.length) { Dungeon.setCurrentFloor(floorNum+1);}else {
			int type = enemies[placeHolder].getcType();
			Monster a;
			Sentient b;
			Beast c;
			boolean win = false;
			
			if(enemies[placeHolder] instanceof Monster) {
				a = (Monster) enemies[placeHolder];
				win = Formula.battle(p,a);
			}else if(enemies[placeHolder] instanceof Sentient) {
				b = (Sentient) enemies[placeHolder];
				win = Formula.battle(p,b);
			}else if(enemies[placeHolder] instanceof Beast) {
				c = (Beast) enemies[placeHolder];
				win = Formula.battle(p,c);
			}
			
			if(win) placeHolder++;
			
			if(placeHolder >= enemies.length) Dungeon.setCurrentFloor(floorNum+1);
		}
	}

	public String getName() {
		return name;
	}

	public boolean isRest() {
		return rest;
	}

	public static Creature[] getEnemies() {
		return enemies;
	}

	public static int getPlaceHolder() {
		return placeHolder;
	}
	
	public int getFloorNum() {
			return floorNum;
	}
}
