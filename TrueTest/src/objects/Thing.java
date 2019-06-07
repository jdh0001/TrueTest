package objects;

public abstract class Thing {
	
	//private static String name;
	private static String description;
	private static String shortName;
	
	//All values manually assigned
	public Thing(String d, String sN) {
		//name = n;
		description = d;
		shortName = sN;
	}
	
	//Lazy test creation
	public Thing() {
		//name = "NoName";
		description = "NoName";
		shortName = "NoName";
	}
	
//	//Random name,desc,shortname generator
//	public Thing(int tType, int mat, boolean metal) {
//		if(n.equals("1")) {
//			generateCName(tType);
//		}else 
//		if(n.equals("2")) {
//			generateIName(tType, mat, metal, 0, 0);
//		}else {
//			//name = "NoName1";
//			description = "NoName1";
//			shortName = "NoName1";
//		}
//	}
//	
//	//Random name,desc,shortname generator
//	public Thing(int tType, int a, int b) {
//		if(n.equals("1")) {
//			generateCName(tType);
//		}else 
//		if(n.equals("2")) {
//			generateIName(tType, 0, false, a, b);
//		}else {
//			name = "NoName1";
//			description = "NoName1";
//			shortName = "NoName1";
//		}
//	}
	
	//calls outside method to select a name, assigns generic desc, and binds a shortname
	
	//for creatures
//	private static void generateCName(int cType) {
//		
//		if(cType == 0) {
//			name = Formula.beastName();
//			description = "A beast that seems hostile to those that approach it.";
//			shortName = name.replaceAll(" ", "");
//			System.out.println(name);
//		}else
//		if(cType == 1) {
//			name = Formula.monsterName();
//			description = "A creature mutated and twisted int oan abomination: a monster.";
//			shortName = name.replaceAll(" ", "");
//			System.out.println(name);
//		}else
//		if(cType == 2) {
//			name = Formula.sentientName();
//			description = "A creature with sentience and the power to reason and strategize.";
//			shortName = name.replaceAll(" ", "");
//			System.out.println(name);
//		}else {
//			name = "Mystery Creature";
//			description = "A creature that mysteriously appeared, even though it should be impossible.";
//			shortName = name.replaceAll(" ", "");
//			System.out.println(name);
//		}
//		
//	}
	
	//for items
//	private static void generateIName(int iType, int mat, boolean metal, int a, int b) {
//		if(iType == 0) {
//			
//			name = Formula.weaponName(a, b);
//			description = "A fearsome weapon called a "+name+".";
//			shortName = name.replaceAll(" ", "");
//			System.out.println(name);
//		}else
//		if(iType == 1) {
//
//			name = Formula.armorName(mat,metal);
//			description = "A sturdy piece of armor called"+name+".";
//			shortName = name.replaceAll(" ", "");
//			System.out.println(name);
//		}else
//		if(iType == 2) {
//			name = Formula.consumableName(a);
//			description = "A concoction called "+name+".";
//			shortName = name.replaceAll(" ", "");
//			System.out.println(name);
//		}else
//		if(iType == 3){
//			name = Formula.miscName();
//			description = "A treasure that can be sold for money.";
//			shortName = name.replaceAll(" ", "");
//			System.out.println(name);
//		
//		}else {
//			name = "Mystery Creature";
//			description = "A creature that mysteriously appeared, even though it should be impossible.";
//			shortName = name.replaceAll(" ", "");
//		}
//	}

//	public String getName() {
//		return name;
//	}
	
	public String getDescription() {
		return description;
	}
	
}
