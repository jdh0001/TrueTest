package objects;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Formula {

	
	public static String beastName() {
		
		String[] beasties = new String[] 
		{"Wolf", "Boar", "Dog", "Tiger", "Giant Beaver",
		"Dire Wolf", "Rabid Rabbit", "Gorilla", "Eagle",
		"Giant Hawk", "Shark", "Octopus", "Giant Squid",
		"Killer Whale", "Giant Goat", "Cobra", "Anaconda",
		"Aligator", "Crocodile", "Moose", "Mountain Lion",
		"Coyote", "Emu", "Baboon", "Boa Constrictor", 
		"Giant Racoon", "Black Bear", "Brown Bear", "Lion",		
		"Giant Owl", "Giant Mole", "Man Eating Horse"};
		
		return beasties[ThreadLocalRandom.current().nextInt(0,(beasties.length))];
	}
	
	public static String monsterName() {
		
		String[] monsters = new String[]
		{"Goblin", "Red Goblin", "Hob Goblin", "Over Goblin", "Ogre",
		"Battle Ogre", "Centaur", "Minotaur", "Leotaur", "Chimera",
		"Lesser Demon", "Greater Demon", "Imp", "Lesser Devil", 
		"Greater Devil", "Bicorn", "Average Clown", "Zombie", "Ghoul",
		"Vampire Spawn", "Vampire", "Gargoyle", "Water Dragon", "Dragon",
		"Drake", "Wyvern", "Orc", "Corrupted Angel", "Corrupted Machine",
		"Corrupted Unicorn", "Manticore", "Dark Spirit", "Solid Ghost",
		"Animate Chair", "Possessed Bush", "Floating Candle", "Bad Clown",
		"Corrupted Zealot", "Undead Knight", "Robo Caller", ("Corrupted "+sentientName()),
		("Undead "+beastName()), ("Animate "+weaponName(0,2))};
		
		return monsters[ThreadLocalRandom.current().nextInt(0,(monsters.length))];
	}
	
	public static String sentientName() {
		
		String[] sentients = new String[]
		{"Bandit Bob", "Wasabi Hero Dan", "Mayo Marsella", "Mayo Mathew",
		"Mustard Convict", "Ketchup Rogue", "Ranch Rogue", "Onion Knight",
		"Bandit Steve", "Bandit Kevin", "Bandit Lora", "Susan Managerbane",
		"Antivaxxer Karen", "Businessman Chet", "Boss Brad", "Evil Chad",
		"Neutral Chad", "Garlic Tina", "Taste Buster", "Pepper Brandon",
		"Tertiary Antagonist", "Generic NPC", "Armored Lester", "Candy Tim",
		"Soy Darla", "Terry Teriyaki", "Robwith Grabbiehanz", "Secret Mime",
		"Crimelord Bubba", "Starving Artist", "Unfunny Clown", "Beardy Greg",
		"Sad Karla", "Aoli Fred", "Beat Bret", "Loaf Lover", "Colonel Corncob",
		"Mango Max", "Crunchy Idiot", "Gooey Gui", "Knight IceTea", "Knight Trisha",
		"Knight Queue", "Knight Stack", "Dayda Structure", "Sinister Salad",
		"Yeet Dreams", "Sailor Meme", "Sailor Sail", "Sailor Mast", "Sailor Anchor",
		"Seamen Yokel", "Seamen Wanton", "Captain Bodymist", "Phirst Mayt", 
		"Captain Squish", "Nonhazardous Duke", "Scientist Darwin", "Scientist Ross",
		"Scientist Realman", "Believable Realname", "Todd Jones", "Citizen Cain",
		"Civilian Casualty", "Confused Electrician", "Every EyeTeaMan", "Wunder Wooman",
		"Notan Alien", "Flesh Harvester", "Corn Child", "Jimmy TeaCirc", "No Thanks",
		"Incompetent Pacifist", "Bobby B", "Sub Dom", "Serious Robert", "Negative Nancy"};
		
		return sentients[ThreadLocalRandom.current().nextInt(0,(sentients.length))];
	}

	public static String weaponName(int a, int b) {
		
		if(a>2||b<0) a = 0;
		if(b>7||b<0) b = 0;
		
		String[] magics = new String[] {
		"", "Fire ", "Water ","Wind ", "Earth ", "Light ","Dark ", "Lightning "};
		
		String[] hit = new String [] {
		"Piercing ", "Slashing ", "Bludgeoning "};
		
		String[] weapons = new String[]
		{"Dagger", "Long Sword", "Short Sword", "Hand Axe",
		"Great Axe", "Spear", "Knuckles", "Mace", "Cudgel",
		"Staff", "Knife", "Halberd", "Stick", "Spiked Knuckle",
		"Long Bow", "Short Bow", "Crossbow", "Whip", "Cutlass"};
		
		return (hit[a]+magics[b]+weapons[ThreadLocalRandom.current().nextInt(0,(weapons.length))]);
	}
	
	public static String armorName(int mat, boolean metal) {
		String armr="";
		//Type 0 - Boar      / Wood
		//Type 1 - Wolf      / Iron
		//Type 2 - Bear      / Steel
		//Type 3 - Dire Wolf / Mithril
		//Type 4 - Ogre      / Orichalcum
		//Type 5 - Demon     / Adamantine
		//Type 6 - Dragon    / Radiant
		
		String[] metalic = new String[]
		{"Wood ", "Iron ", "Steel ", "Mithral ", "Orichalcum ",
		"Adamantine ", "Radiant "};
		
		String[] mater = new String[]
		{"Boar ", "Wolf ", "Bear ", "Dire Wolf ", "Ogre ", "Demon "," Dragon "};
		
		
		
		String[] armors = new String[]
		{"Helmet", "Spiked Helmet", "Horned Helm", "Hard Hat",
		"Headband", "Circlet", "Hat", "Beanie", "Hood", "Head Wrap",
		"Gloves", "Gauntlets", "Oven Mitts", "Mittens", "Fingerless Gloves",
		"Shoes", "Boots", "High Heels", "Sandals", "Flip Flops", "Sneakers",
		"Mail", "Plate", "Studded Chest", "Chest Piece", "Shirt", "Coat",
		"Pants", "Shorts", "Biker Shorts", "Dress", "Sun Dress", "Gothic Dress",
		"Slacks", "Tights", "Mask", "Cape", "Cloak", "Robe", "Bathrobe",
		"Kilt", "Skirt", "Mini Skirt", "Flannel Shirt", "Hoodie", "Denim Jacket",
		"Jeans", "Knee High Boots", "Goggles", "Glasses", "Sticker", "Body Paint",
		"Leggings", "Scarf", "Nose Ring", "Ring", "Septum Piercing", "Tongue Ring",
		("Temporary "+beastName()+" Tattoo"), "Bracelet", "Necklace", "Amulet",
		"Bracers", "Shoulder Pads", "Eye Patch", "Suit", "Tie", "Top Hat"};
		
		if(metal) {
			armr = metalic[mat] + armors[ThreadLocalRandom.current().nextInt(0,(armors.length))];
		}else {
			armr = mater[mat] + armors[ThreadLocalRandom.current().nextInt(0,(armors.length))];
		}
		
		return armr;
	}
	
	public static String consumableName(int a) {
		//Type 0 - Health Restore
		//Type 1 - Stamina Restore
		//Type 2 - Mana Restore
		//Type 3 - Agility Buff
		//Type 4 - Armor Score Buff
		//Type 5 - Remove Status Effects
		
		if(a>5||a<0) a = 0;
		
		String[] potPre = new String[]
		{"Health ", "Stamina ", "Mana ", "Agility Buff ", "Armor Score Buff ", "Curing "};
		
		String[] consumables = new String[]
		{"Potion", "Elixor", "Oil", "Ointment", "Tincture", "Medicine",
		"Herbs", "Drink", "Brand Alcohol", "Enema", "Pills", "Chewable Tablets",
		"Syringe", "Arm Patch", "Flavored Candy", "Powder Packet", "Soda", "Tea"};
		
		return (potPre[a] + consumables[ThreadLocalRandom.current().nextInt(0,(consumables.length))]);
	}
	
	public static String miscName() {
		
		String[] miscs = new String[]
		{"Trash","Beast Pelt","Dead Skin","Religious Idol","Painting","Fake Blood","Real Blood",
		"Lice", "Teeth", "Innards", "Broken Key", "Silly Poem", "Rare Figurine",
		"Chipped Paint", "Leftovers", "Blocks", "Doll", "Bees Knees", "Actual Crabs", 
		"Fried Air", "Cologne", "Perfume", "Cutlery", "Human Garbage", "Love Letter",
		"Foreign Currency", "Used Gum", "Overwhelmed Starfish", "Reason To Live",
		"Boring Jam", "Tax Return", "Misspelled Werd", "Sea Shell", "Tea Shell",
		"Stale Biscuits", "Lint", "Mundane Wand", "Glass Shards", "Mixed Tape",
		"Sauce Packets", "Irremovable Quest Item", "Old Memes", "Sponsored Shows",
		"Nuanced Critique", "Dandelions", "Someones Wallet", "Arcade Tolkiens",
		"Invisible Friend", ("Stuffed "+beastName()), "Glass Ewes", "False Teeth",
		"Pay Check", "Fangs", "Claws", "Scales", "Metal Ingots", "Electrum Pieces",
		"New Game", "Error could not", "Grandmother Clock", "Parents Love",
		"Student Debt", "Medical Debt", "Evil Gummies", "House Deed", "Car Deed",
		"Good Credit", "Extra Fries", "Surprise Onion Ring", "Salty Salt",
		"Olive Paste", "Coffee Mug", "Voodoo Doll", "Pitt Steins", "Duck Duck",
		"Goose", "Golden Egg", "Silver Egg", "Lead Carrots", "Kale Smoothie",
		"Worthless Junk", "Coupons", "Gift Cards", "Existential Crisis"};
		
		return miscs[ThreadLocalRandom.current().nextInt(0,(miscs.length))];
	}
		
	public static boolean battle(Player p, Sentient c) {
		
		int php = p.getHealth();
		int chp = c.getHealth();
		int damageTracker = 0;
		int escChance = p.getAgility()+2;
		String cN = c.getName(), pN = p.getName();
		Scanner read = new Scanner(System.in);
		String decision = "";
		boolean flag = true, fight = true, iFlag = true, victory = false;
		while(flag) {
			
			System.out.println("An enemy "+cN+" stands before you.\n");
			System.out.println("Do you wish to fight? (y/n)");
			
			while(iFlag) {
				try {
					iFlag = false;
					decision = read.next();
				}catch(Exception e) {
					System.out.println("Input y to fight or Input n to flee");
					iFlag = true;
				}
			}
			
			if(decision.trim().charAt(0)=='n'||decision.trim().charAt(0)=='N') fight = false;
			
			if(fight) {
				System.out.println("You have chosen to fight!\n");
				
				if(p.getAgility()>c.getAgility()) {
					System.out.println(pN+" attacks with "+p.getAt().getName()+".");
					damageTracker = c.damageOutput(p, p.getAt());
					chp -= damageTracker;
					System.out.println("Enemy "+cN+" takes "+damageTracker+" damage.\n");
					if(chp>0) { 
						System.out.println(cN+" attacks!\n");
						damageTracker = p.damageOutput(c); 
						php -= damageTracker; 
						System.out.println("Player "+pN+" takes "+damageTracker+" damage.\n");
					}
					
				}else if(c.getAgility()>p.getAgility()) {
					
					System.out.println(cN+" attacks!\n");
					damageTracker = p.damageOutput(c); 
					php -= damageTracker; 
					System.out.println("Player "+pN+" takes "+damageTracker+" damage.\n");

					if(php>0) { 
						System.out.println(pN+" attacks with "+p.getAt().getName()+".");
						damageTracker = c.damageOutput(p, p.getAt());
						chp -= damageTracker;
						System.out.println("Enemy "+cN+" takes "+damageTracker+" damage.\n");
					}
					
				}else if(c.getAgility()==p.getAgility()){
					
					if(ThreadLocalRandom.current().nextInt(0,2)==1) {
						System.out.println(pN+" attacks with "+p.getAt().getName()+".");
						damageTracker = c.damageOutput(p, p.getAt());
						chp -= damageTracker;
						System.out.println("Enemy "+cN+" takes "+damageTracker+" damage.\n");
						if(chp>0) { 
							System.out.println(cN+" attacks!\n");
							damageTracker = p.damageOutput(c); 
							php -= damageTracker; 
							System.out.println("Player "+pN+" takes "+damageTracker+" damage.\n");
						}
					}else {
						System.out.println(cN+" attacks!\n");
						damageTracker = p.damageOutput(c); 
						php -= damageTracker; 
						System.out.println("Player "+pN+" takes "+damageTracker+" damage.\n");

						if(php>0) { 
							System.out.println(pN+" attacks with "+p.getAt().getName()+".");
							damageTracker = c.damageOutput(p, p.getAt());
							chp -= damageTracker;
							System.out.println("Enemy "+cN+" takes "+damageTracker+" damage.\n");
						}
					}
					
				}else {
					System.err.println("perpetual agility logical loop. exiting...");
					System.out.println("p="+p.getAgility()+"||c="+c.getAgility());
					flag = false;
				}
			}else {
				if(escChance > c.getAgility()) {
					System.out.println("You dash passed the "+cN+"!\n");
					flag = false;
				}else {
					System.out.println("You could not find an opening to flee!\n");
					System.out.println(cN+" takes the opportunity to attack!\n");
					damageTracker = (int)(p.damageOutput(c)/escChance);
					php -= damageTracker;
					System.out.println("Player "+pN+" takes "+damageTracker+" damage.\n");
					escChance++;
				}
			}
			
			if(php <= 0 || chp <= 0) { 
				flag = false;
				if(chp>=0) {
					System.out.println(pN+" was defeated by the "+cN+"!\n");
					System.out.println(pN+" dropped "+p.getGold()+" gold to get away safely.");
					p.decreaseGold(p.getGold());
				}else {
					System.out.println(pN+" defeated the "+cN+"!\n");
					victory = true;
				}
			}
		}//end battle loop
		
		if(victory) {
			p.increaseExp(c.getExp());
			p.increaseGold(c.getGold());
			//add items
		}
		return victory;
	}//end battle
	
public static boolean battle(Player p, Beast c) {
		
		int php = p.getHealth();
		int chp = c.getHealth();
		int damageTracker = 0;
		int escChance = p.getAgility()+2;
		String cN = c.getName(), pN = p.getName();
		Scanner read = new Scanner(System.in);
		String decision = "";
		boolean flag = true, fight = true, iFlag = true, victory = false;
		while(flag) {
			
			System.out.println("An beast enemy "+c.tN()+" stands before you.\n");
			System.out.println("Do you wish to fight? (y/n)");
			
			while(iFlag) {
				try {
					iFlag = false;
					decision = read.next();
				}catch(Exception e) {
					System.out.println("Input y to fight or Input n to flee");
					iFlag = true;
				}
			}
			
			if(decision.trim().charAt(0)=='n'||decision.trim().charAt(0)=='N') fight = false;
			
			if(fight) {
				System.out.println("You have chosen to fight!\n");
				System.out.println("Player hp="+p.getHealth()+"|| Enemy hp="+c.getHealth());
				
				if(p.getAgility()>c.getAgility()) {
					System.out.println(pN+" attacks with "+p.getAt().getName()+".");
					damageTracker = c.damageOutput(p, p.getAt());
					chp -= damageTracker;
					System.out.println("Enemy "+cN+" takes "+damageTracker+" damage.\n");
					if(chp>0) { 
						System.out.println(cN+" attacks!\n");
						damageTracker = p.damageOutput(c); 
						php -= damageTracker; 
						System.out.println("Player "+pN+" takes "+damageTracker+" damage.\n");
					}
					
				}else if(c.getAgility()>p.getAgility()) {
					
					System.out.println(cN+" attacks!\n");
					damageTracker = p.damageOutput(c); 
					php -= damageTracker; 
					System.out.println("Player "+pN+" takes "+damageTracker+" damage.\n");

					if(php>0) { 
						System.out.println(pN+" attacks with "+p.getAt().getName()+".");
						damageTracker = c.damageOutput(p, p.getAt());
						chp -= damageTracker;
						System.out.println("Enemy "+cN+" takes "+damageTracker+" damage.\n");
					}
					
				}else if(c.getAgility()==p.getAgility()){
					
					if(ThreadLocalRandom.current().nextInt(0,2)==1) {
						System.out.println(pN+" attacks with "+p.getAt().getName()+".");
						damageTracker = c.damageOutput(p, p.getAt());
						chp -= damageTracker;
						System.out.println("Enemy "+cN+" takes "+damageTracker+" damage.\n");
						if(chp>0) { 
							System.out.println(cN+" attacks!\n");
							damageTracker = p.damageOutput(c); 
							php -= damageTracker; 
							System.out.println("Player "+pN+" takes "+damageTracker+" damage.\n");
						}
					}else {
						System.out.println(cN+" attacks!\n");
						damageTracker = p.damageOutput(c); 
						php -= damageTracker; 
						System.out.println("Player "+pN+" takes "+damageTracker+" damage.\n");

						if(php>0) { 
							System.out.println(pN+" attacks with "+p.getAt().getName()+".");
							damageTracker = c.damageOutput(p, p.getAt());
							chp -= damageTracker;
							System.out.println("Enemy "+cN+" takes "+damageTracker+" damage.\n");
						}
					}
					
				}else {
					System.err.println("perpetual agility logical loop. exiting...");
					System.out.println("p="+p.getAgility()+"||c="+c.getAgility());
					flag = false;
				}
			}else {
				if(escChance > c.getAgility()) {
					System.out.println("You dash passed the "+cN+"!\n");
					flag = false;
				}else {
					System.out.println("You could not find an opening to flee!\n");
					System.out.println(cN+" takes the opportunity to attack!\n");
					damageTracker = (int)(p.damageOutput(c)/escChance);
					php -= damageTracker;
					System.out.println("Player "+pN+" takes "+damageTracker+" damage.\n");
					escChance++;
				}
			}
			
			if(php <= 0 || chp <= 0) { 
				flag = false;
				if(chp>=0) {
					System.out.println(pN+" was defeated by the "+cN+"!\n");
					System.out.println(pN+" dropped "+p.getGold()+" gold to get away safely.");
					System.out.println("Enemy had "+chp+"/"+c.getHealth()+" health left.");
					p.decreaseGold(p.getGold());
				}else {
					System.out.println(pN+" defeated the "+cN+"!\n");
					victory = true;
				}
			}
		}//end battle loop
		
		if(victory) {
			p.increaseExp(c.getExp());
			p.increaseGold(c.getGold());
			//add items
		}
		return victory;
	}//end battle

public static boolean battle(Player p, Monster c) {
	
	int php = p.getHealth();
	int chp = c.getHealth();
	int damageTracker = 0;
	int escChance = p.getAgility()+2;
	String cN = c.getName(), pN = p.getName();
	Scanner read = new Scanner(System.in);
	String decision = "";
	boolean flag = true, fight = true, iFlag = true, victory = false;
	while(flag) {
		
		System.out.println("An enemy "+cN+" stands before you.\n");
		System.out.println("Do you wish to fight? (y/n)");
		
		while(iFlag) {
			try {
				iFlag = false;
				decision = read.next();
			}catch(Exception e) {
				System.out.println("Input y to fight or Input n to flee");
				iFlag = true;
			}
		}
		
		if(decision.trim().charAt(0)=='n'||decision.trim().charAt(0)=='N') fight = false;
		
		if(fight) {
			System.out.println("You have chosen to fight!\n");
			
			if(p.getAgility()>c.getAgility()) {
				System.out.println(pN+" attacks with "+p.getAt().getName()+".");
				damageTracker = c.damageOutput(p, p.getAt());
				chp -= damageTracker;
				System.out.println("Enemy "+cN+" takes "+damageTracker+" damage.\n");
				if(chp>0) { 
					System.out.println(cN+" attacks!\n");
					damageTracker = p.damageOutput(c); 
					php -= damageTracker; 
					System.out.println("Player "+pN+" takes "+damageTracker+" damage.\n");
				}
				
			}else if(c.getAgility()>p.getAgility()) {
				
				System.out.println(cN+" attacks!\n");
				damageTracker = p.damageOutput(c); 
				php -= damageTracker; 
				System.out.println("Player "+pN+" takes "+damageTracker+" damage.\n");

				if(php>0) { 
					System.out.println(pN+" attacks with "+p.getAt().getName()+".");
					damageTracker = c.damageOutput(p, p.getAt());
					chp -= damageTracker;
					System.out.println("Enemy "+cN+" takes "+damageTracker+" damage.\n");
				}
				
			}else if(c.getAgility()==p.getAgility()){
				
				if(ThreadLocalRandom.current().nextInt(0,2)==1) {
					System.out.println(pN+" attacks with "+p.getAt().getName()+".");
					damageTracker = c.damageOutput(p, p.getAt());
					chp -= damageTracker;
					System.out.println("Enemy "+cN+" takes "+damageTracker+" damage.\n");
					if(chp>0) { 
						System.out.println(cN+" attacks!\n");
						damageTracker = p.damageOutput(c); 
						php -= damageTracker; 
						System.out.println("Player "+pN+" takes "+damageTracker+" damage.\n");
					}
				}else {
					System.out.println(cN+" attacks!\n");
					damageTracker = p.damageOutput(c); 
					php -= damageTracker; 
					System.out.println("Player "+pN+" takes "+damageTracker+" damage.\n");

					if(php>0) { 
						System.out.println(pN+" attacks with "+p.getAt().getName()+".");
						damageTracker = c.damageOutput(p, p.getAt());
						chp -= damageTracker;
						System.out.println("Enemy "+cN+" takes "+damageTracker+" damage.\n");
					}
				}
				
			}else {
				System.err.println("perpetual agility logical loop. exiting...");
					System.out.println("p="+p.getAgility()+"||c="+c.getAgility());
				flag = false;
			}
		}else {
			if(escChance > c.getAgility()) {
				System.out.println("You dash passed the "+cN+"!\n");
				flag = false;
			}else {
				System.out.println("You could not find an opening to flee!\n");
				System.out.println(cN+" takes the opportunity to attack!\n");
				damageTracker = (int)(p.damageOutput(c)/escChance);
				php -= damageTracker;
				System.out.println("Player "+pN+" takes "+damageTracker+" damage.\n");
				escChance++;
			}
		}
		
		if(php <= 0 || chp <= 0) { 
			flag = false;
			if(chp>=0) {
				System.out.println(pN+" was defeated by the "+cN+"!\n");
				System.out.println(pN+" dropped "+p.getGold()+" gold to get away safely.");
				p.decreaseGold(p.getGold());
			}else {
				System.out.println(pN+" defeated the "+cN+"!\n");
				
				victory = true;
			}
		}
	}//end battle loop
	
	if(victory) {
		p.increaseExp(c.getExp());
		p.increaseGold(c.getGold());
		//add items
	}
	return victory;
}//end battle
}
