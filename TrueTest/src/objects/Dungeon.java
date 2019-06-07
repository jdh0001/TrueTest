package objects;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Dungeon {
	private static String dunName;
	private static int totalFloors;
	private static int currentFloor;
	private static Place[] floors;
	
	public Dungeon(int tF, Player p) {
		totalFloors = tF;
		if(totalFloors < 1) totalFloors = 1;
		currentFloor = 1;
		floors = new Place[totalFloors];
		genFloors(p);
	}
	
	public Dungeon() {
		totalFloors = 1;
		currentFloor = 1;
	}
	
	private static void genFloors(Player p){
		for(int i = 0; i<totalFloors; i++) {
			boolean temp = false;
			if(ThreadLocalRandom.current().nextInt(0,5)==3) temp = true;
			floors[i] = new Place(temp, (i+1), p);
		}
	}
	
	

	public static String getDunName() {
		return dunName;
	}

	public static int getTotalFloors() {
		return totalFloors;
	}
	
	public static int getCurrentFloor() {
		return currentFloor;
	}
	public static boolean finalFloor() {
		if(currentFloor >= (totalFloors)) return true;
		return false;
	}
	public static Place[] getFloors() {
		return floors;
	}
	public static void setCurrentFloor(int curr) {
		if(curr <= totalFloors) {
			currentFloor = curr;
			if(curr == totalFloors) System.out.println("\n /////FINAL FLOOR///// \n");
		}
	}

}
