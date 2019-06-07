package objects;

public class SubDungeon extends Dungeon {

	public SubDungeon(int tF, Player p) {
		super(tF, p);
		
	}

	public SubDungeon() {
		
	}
	
	public static String getDunName() {
		return Dungeon.getDunName();
	}

	public static int getTotalFloors() {
		return Dungeon.getTotalFloors();
	}
	
	public static int getCurrentFloor() {
		return Dungeon.getCurrentFloor();
	}

	public static Place[] getFloors() {
		return Dungeon.getFloors();
	}
}
