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
	
	public int getCurrentFloor() {
		return super.getCurrentFloor();
	}

	public Place[] getFloors() {
		return super.getFloors();
	}
}
