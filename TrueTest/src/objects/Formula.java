package objects;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Formula {
	
	//ASCII color breakouts
	private static String red = "\u001b[31m";
	private static String yellow = "\u001b[3mm";
	private static String reset = "\u001b[0m";
	private static String green = "\u001b[32m";
	
	//dynamic name generators
	
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
	
	public static String generateDungeonName() {
		
		
		String[] mod = new String[] 
		{"Evil", "Good", "Madness", "Mad", "Happy", "Sad", "Mushroom", "Tasty",
		"Unholy", "Holy", "Restful", "Monster", "Crazy", "Weird", "Mispelled",		
		Formula.sentientName()+"\'s", "Manic", "Depressed", "Pessimistic",				
		"Dinner", "Lunch", "Snack", "Wayward", "Musical", "Polyamorous", "Mobile",
		"Cruel", "Merciful", "Sadistic", "Masochistic", "Candy Coated",
		"Snowflake", "Liberal", "Goopy", "Gross", "Dirty", "Diseased",
		"Corrupted", "Ugly", "Beautiful", "Cool", "Hot", "Burning", "Frozen",
		"Dangerous", "Deadly", "Willful", "Hellish", "Saintly", "Comical"};
				
		String[] mod2 = new String[] 
		{"Evil", "Good", "Madness", "Cheese", "Happiness", "Sadness", "Mushrooms", "Food",
		"Demons", "Monsters", "Resting", "No Gold", "Insanity", "Creepiness", "Typos",		
		Formula.monsterName()+"s", "Energy", "Depression", "Pessimisism",				
		"Rice", "Meat", "Eating", "Devouring", "Composing", "Heart Break", "Legs and Wheels",
		"Cruelty", "Mercy", "Vegetables", "Candy", "Trash", "Garbage", "???",
		"Ice", "Tears", "Goo", "Poo", "Dirt", "Illness", "Lavatories", "Easy Victories",
		"Corruption", "Bullying", "Beauty", "No Air", "Steam", "Fire", "Ice and Snow",
		"Danger", "Death", "Pride", "Hell", "Paradise", "Comedy", "Screams", "Laughter"
				
		};
		
		String[] dungies = new String[] 
		{" Crypt of ", " Dungeon of ", " Tomb of ", " Cave of ", " Crevasse of ",
		" Lair of ", " Underground Base of ", " Hidden Location of ", " Castle of "};
		
		return mod[ThreadLocalRandom.current().nextInt(0,(mod.length))]+
				dungies[ThreadLocalRandom.current().nextInt(0,(dungies.length))]+
				mod2[ThreadLocalRandom.current().nextInt(0,(mod2.length))];
	}
		
	
	//encounters based on enemy type
	
	
	public static boolean battle(Player p, Sentient c) {
		
		int php = p.getHealth();
		int chp = c.getHealth();
		int damageTracker = 0, looper = 0;
		int escChance = p.getAgility()+2;
		String cN = c.getName(), pN = p.getName();
		Scanner read = new Scanner(System.in);
		String decision = "";
		boolean flag = true, fight = true, iFlag = true, victory = false;
		while(flag) {
			
			System.out.println("A level "+c.getLevel()+" sentient enemy, "+cN+" stands before you.\n");
			System.out.println("Do you wish to fight? (y/n)");
			
			while(iFlag) {
				try {
					iFlag = false;
					decision = read.next();
					read.nextLine();
				}catch(Exception e) {
					System.out.println("Input y to fight or Input n to flee");
					iFlag = true;
					looper++;
					//in the case of feedback loop for combat, force exits loop
					if(looper >= 10) { iFlag = true; decision = "N";}
				}
			}
			
			if(decision.trim().charAt(0)=='n'||decision.trim().charAt(0)=='N') fight = false;
			
			if(fight) {
				System.out.println("\nYou have chosen to fight!\n");
				System.out.println("Player health:"+php+" || Enemy health:"+chp+"\n");
				
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
					escChance+=3;
				}
			}
			
			if(php <= 0 || chp <= 0) { 
				flag = false;
				if(chp>=0) {
					System.out.println(red+pN+" was defeated by the "+cN+"!\n"+reset);
					p.increaseRunCount();
					if(p.getGold() > 0) {
						if(p.getGold()<100) {
							p.decreaseGold(p.getGold());
							System.out.println(pN + " dropped " + yellow + p.getGold() + " gold" + yellow + " to get away safely.");
						}else {
							p.decreaseGold((int)(p.getGold()/2));
							System.out.println(pN + " dropped " + yellow + p.getGold() + " gold" + yellow + " to get away safely.");
						}
					}else {
						p.increaseDeathCount();
						System.out.println("You had no gold to throw and have taken a serious wound.");
					}
				}else {
					System.out.println(pN+" defeated the "+cN+"!\n");
					victory = true;
				}
			}
		}//end battle loop
		
		if(victory) {
			//add exp
			p.increaseExp(c.getExp());
			//add gold
			p.increaseGold(c.getGold());
			//add items
			Item[] droppings = c.getDrops();
			int place = 0;
			for(int i = 0; i < p.getInventory().length; i++) {
			if(p.getInventory()[i] == null && place < droppings.length && droppings.length > i) {
				Item temp = droppings[i];
				if(temp instanceof Weapon) {
					if(compareWeapon(p,(Weapon)temp)) {
						temp = p.getAt();
						p.setWeapon((Weapon)droppings[i]);
					}
				}
				if(temp instanceof Armor) {equipArmor(p,(Armor)temp);}else {
				
						p.getInventory()[i] = temp;
						place++;
					
				}
					
				
				}else if(place >= droppings.length) {
					break;
				}
			}
			//add items
		}
		return victory;
	}//end battle
	
public static boolean battle(Player p, Beast c) {
		
		int php = p.getHealth();
		int chp = c.getHealth();
		int damageTracker = 0, looper = 0;
		int escChance = p.getAgility()+2;
		String cN = c.getName(), pN = p.getName();
		Scanner read = new Scanner(System.in);
		String decision = "";
		boolean flag = true, fight = true, iFlag = true, victory = false;
		while(flag) {
			
			System.out.println("A level "+c.getLevel()+" beastial enemy, "+cN+" stands before you.\n");
			System.out.println("Do you wish to fight? (y/n)");
			
			while(iFlag) {
				try {
					iFlag = false;
					decision = read.next();
					read.nextLine();
					
				}catch(Exception e) {
					System.out.println("Input y to fight or Input n to flee");
					iFlag = true;
					looper++;
					//in the case of feedback loop for combat, force exits loop
					if(looper >= 10) { iFlag = true; decision = "N";}
				}
			}
			
			if(decision.trim().charAt(0)=='n'||decision.trim().charAt(0)=='N') fight = false;
			
			if(fight) {
				System.out.println("\nYou have chosen to fight!\n");
				System.out.println("Player health:"+php+" || Enemy health:"+chp+"\n");
				
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
					escChance+=3;
				}
			}
			
			if(php <= 0 || chp <= 0) { 
				flag = false;
				if(chp>=0) {
					System.out.println(red+pN+" was defeated by the "+cN+"!\n"+reset);
					p.increaseRunCount();
					if(p.getGold() > 0) {
						if(p.getGold()<100) {
							p.decreaseGold(p.getGold());
							System.out.println(pN + " dropped " + yellow + p.getGold() + " gold" + yellow + " to get away safely.");
						}else {
							p.decreaseGold((int)(p.getGold()/2));
							System.out.println(pN + " dropped " + yellow + p.getGold() + " gold" + yellow + " to get away safely.");
						}
					}else {
						p.increaseDeathCount();
						System.out.println("You had no gold to throw and have taken a serious wound.");
					}
				}else {
					System.out.println(pN+" defeated the "+cN+"!\n");
					victory = true;
				}
			}
		}//end battle loop
		
		if(victory) {
			//add exp
			p.increaseExp(c.getExp());
			//add gold
			p.increaseGold(c.getGold());
			//add items
			Item[] droppings = c.getDrops();
			int place = 0;
			for(int i = 0; i < p.getInventory().length; i++) {
			if(p.getInventory()[i] == null && place < droppings.length && droppings.length > i) {
				Item temp = droppings[i];
				if(temp instanceof Weapon) {
					if(compareWeapon(p,(Weapon)temp)) {
						temp = p.getAt();
						p.setWeapon((Weapon)droppings[i]);
					}
				}
				if(temp instanceof Armor) {equipArmor(p,(Armor)temp);}else {
				
						p.getInventory()[i] = temp;
						place++;
					
				}
					
				
				}else if(place >= droppings.length) {
					break;
				}
			}
			//add items
		}
		return victory;
	}//end battle

public static boolean battle(Player p, Monster c) {
	
	int php = p.getHealth();
	int chp = c.getHealth();
	int damageTracker = 0, looper = 0;
	int escChance = p.getAgility()+2;
	String cN = c.getName(), pN = p.getName();
	Scanner read = new Scanner(System.in);
	String decision = "";
	boolean flag = true, fight = true, iFlag = true, victory = false;
	while(flag) {
		
		System.out.println("A level "+c.getLevel()+" monstrous enemy, "+cN+" stands before you.\n");
		System.out.println("Do you wish to fight? (y/n)");
		
		while(iFlag) {
			try {
				iFlag = false;
				decision = read.next();
				read.nextLine();
			}catch(Exception e) {
				System.out.println("Input y to fight or Input n to flee");
				iFlag = true;
				looper++;
				//in the case of feedback loop for combat, force exits loop
				if(looper >= 10) { iFlag = true; decision = "N";}
			}
		}
		
		if(decision.trim().charAt(0)=='n'||decision.trim().charAt(0)=='N') fight = false;
		
		if(fight) {
			System.out.println("\nYou have chosen to fight!\n");
			System.out.println("Player health:"+php+" || Enemy health:"+chp+"\n");
			
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
				escChance+=3;
			}
		}
		
		if(php <= 0 || chp <= 0) { 
			flag = false;
			if(chp>=0) {
				System.out.println(red + pN+" was defeated by the "+cN+"!\n"+reset);
				p.increaseRunCount();
				if(p.getGold() > 0) {
					if(p.getGold()<100) {
						p.decreaseGold(p.getGold());
						System.out.println(pN + " dropped " + yellow + p.getGold() + " gold" + yellow + " to get away safely.");
					}else {
						p.decreaseGold((int)(p.getGold()/2));
						System.out.println(pN + " dropped " + yellow + p.getGold() + " gold" + yellow + " to get away safely.");
					}

				}else {
					p.increaseDeathCount();
					System.out.println("You had no gold to throw and have taken a serious wound.");
				}
			}else {
				System.out.println(pN+" defeated the "+cN+"!\n");
				victory = true;
			}
		}
	}//end battle loop
	
	if(victory) {
		//add exp
		p.increaseExp(c.getExp());
		//add gold
		p.increaseGold(c.getGold());
		//add items
		Item[] droppings = c.getDrops();
		int place = 0;
		for(int i = 0; i < p.getInventory().length; i++) {
		if(p.getInventory()[i] == null && place < droppings.length && droppings.length > i) {
			Item temp = droppings[i];
			if(temp instanceof Weapon) {
				if(compareWeapon(p,(Weapon)temp)) {
					temp = p.getAt();
					p.setWeapon((Weapon)droppings[i]);
				}
			}
			if(temp instanceof Armor) {equipArmor(p,(Armor)temp);}else {
			
					p.getInventory()[i] = temp;
					place++;
				
			}
				
			
			}else if(place >= droppings.length) {
				break;
			}
		}
		//add items
	}
	return victory;
}//end battle


//determine if equipment received from combat is better than current equipment


private static boolean compareWeapon(Player p, Weapon w) {
	Weapon curr = p.getAt();
	String choice = "";
	Scanner read = new Scanner(System.in);
	boolean newIsBetter = false;
	int currBestAttack = curr.getMaMod(), wBestAttack = w.getMaMod();
	
	if(wBestAttack>w.getPaMod()) wBestAttack = w.getPaMod();
	
	if(wBestAttack > currBestAttack) {
		System.out.println("You received the "+w.getName()+" which is better than your current weapon.\n");
		System.out.println("Equip the new weapon(y/n:");
		choice = read.next();
		if(choice.trim().toLowerCase().charAt(0)=='y') {
			newIsBetter = true;
		}
	} else if(wBestAttack == currBestAttack && curr.getMaType() < w.getMaType()){
		System.out.println("You received the "+w.getName()+" which is better than your current weapon.\n");
		System.out.println("Equip the new weapon(y/n:");
		choice = read.next();
		if(choice.trim().toLowerCase().charAt(0)=='y') {
			newIsBetter = true;
		}
	}
	
	return newIsBetter;
}
//TODO: Implement rest of equip item functions for after battle interaction
private static boolean equipArmor(Player p, Armor better) {
	boolean replacing = false;
	String choice = "";
	Scanner read = new Scanner(System.in);
	Armor[] armory = p.getAa();
	int place = 0;
	for(int i = 0; i < armory.length; i++) {
		if(armory[i] == null) {
			place++;
			break;
		}else if(armory[i] != null && i == (armory.length-1)) {
			place = p.getOldestArmor();
			p.incrementOldestArmor();
			replacing = true;
		}
	}
	if(armory[place]!=null) {
		Armor temp = p.getAa()[place];
		int totalOld = temp.getPdMod()+temp.getMdMod(), totalNew = better.getPdMod()+better.getMdMod();
		if(totalOld<totalNew) {

			System.out.println("You received the "+better.getName()+" which is better than your current armor.\n");
			System.out.println("Equip the new armor(y/n:");
			choice = read.next();
			if(choice.trim().toLowerCase().charAt(0)=='y') {
				replacing = true;
			
				p.getAa()[place] = better;
				for(int i = 0; i < p.getInventory().length; i++) {
					if(p.getInventory()[i] == null) {
						p.getInventory()[i] = temp;
						
					}
				}
			}else {
				
			}
		}
	}else {
		p.getAa()[place] = better;
		System.out.println("You equipped the "+better.getName());
	}
	return replacing;
}

}