package objects;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Dungeon {
	private String dunName;
	private int totalFloors;
	private int currentFloor;
	private Place[] floors;
	
	public Dungeon(int tF, Player p) {
		totalFloors = tF;
		dunName = Formula.generateDungeonName();
		if(totalFloors < 1) totalFloors = 1;
		currentFloor = 1;
		floors = new Place[totalFloors];
		genFloors(p);
	}
	
	public Dungeon() {
		totalFloors = 1;
		currentFloor = 1;
	}
	
	private void genFloors(Player p){
		boolean temp = false;
		int sum=0;
		for(int i = 0; i<totalFloors; i++) {
			
			if(i > 0 && i < (totalFloors/2 +1) && ThreadLocalRandom.current().nextInt(0,2)==1 && !temp) {
				//first floor can't be rest
				//no two adjacent floors may be rest
				temp = true;
			}else {
				temp = false;
			}
			
//			if(ThreadLocalRandom.current().nextInt(0,5)==3) temp = true;
			floors[i] = new Place(temp, (i+1), p, this);

		}


	}
	
	

	public String getDunName() {
		return dunName;
	}

	public int getTotalFloors() {
		return totalFloors;
	}
	
	public int getCurrentFloor() {
		return currentFloor;
	}
	public boolean finalFloor() {
		if(currentFloor >= (totalFloors)) return true;
		return false;
	}
	public Place[] getFloors() {
		return floors;
	}
	public void setCurrentFloor(int curr) {
		if(curr <= totalFloors) {
			currentFloor = curr;
			if(curr == totalFloors) System.out.println("\n /////FINAL FLOOR///// \n");
		}
	}

}
