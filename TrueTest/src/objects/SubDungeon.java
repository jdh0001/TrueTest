package objects;

public class SubDungeon extends Dungeon {

	public SubDungeon(int tF, Player p) {
		super(tF, p);
		
	}

	public SubDungeon() {
		
	}
	
	public String getDunName() {
		return super.getDunName();
	}

	public int getTotalFloors() {
		return super.getTotalFloors();
	}
	
	public int getCurrentFloor() {
		return super.getCurrentFloor();
	}

	public Place[] getFloors() {
		return super.getFloors();
	}
}
