import java.util.ArrayList;
import java.util.Scanner;

/**
 * Arena - An driver class for class exercise: CE_Abstraction Copyright 2021
 * Howard Community College
 * 
 * @author Hunnain Arsalan
 * @version 1.0
 *
 */
public class Arena {

	// define the constants in the constant block

	// main menu constants
	private static final int ARENA = 1;
	private static final int QUIT = 5;
	private static final int REST = 2;
	private static final int SHOP = 3;
	private static final int STATUS = 4;

	// monster menu constants
	private static final int GOBLIN = 1;
	private static final int OGRE = 2;
	private static final int GIANT = 3;
	private static final int DRAGON = 4;

	// monster damage constants
	private static final int GOBLIN_DAMAGE = 2;
	private static final int OGRE_DAMAGE = 4;
	private static final int GIANT_DAMAGE = 6;
	private static final int DRAGON_DAMAGE = 10;

	// other constants
	private static final double SILVER = 10.0;
	private static final double STD_WINDFALL = 2.0;

	// Equipment constants
	private static final double CLUB_COST = 1.0;
	private static final double SWORD_COST = 2.5;
	private static final double WEAPON1_COST = 4.5;
	private static final double WEAPON2_COST = 7.0;
	private static final int CLUB_DMG = 2;
	private static final int SWORD_DMG = 4;
	private static final int WEAPON1_DMG = 6;
	private static final int WEAPON2_DMG = 8;

	private static final double RAGS_COST = 1.0;
	private static final double LEAHTER_COST = 1.0;
	private static final double ARMOR1_COST = 1.0;
	private static final double ARMPR2_COST = 1.0;
	private static final int RAGS_DMG = 1;
	private static final int LEATHER_DMG = 3;
	private static final int ARMOR1_DMG = 5;
	private static final int ARMOR2_DMG = 8;

	private static final int CLUB = 1;
	private static final int SWORD = 2;
	private static final int WEAPON1 = 3;
	private static final int WEAPON2 = 4;
	private static final int RAGS = 5;
	private static final int LEATHER = 6;
	private static final int ARMOR1 = 7;
	private static final int ARMOR2 = 8;

	public static void main(String[] args) {

		System.out.println("Copyright 2021 Howard Community College\n");
		Scanner myScanner = new Scanner(System.in);
		String name = "";

//		Weapons
		Weapon[] weapons = new Weapon[4];
		weapons[0] = new Club(1.0, 2, "Oak");
		weapons[1] = new Sword(2.5, 4, false);
		weapons[2] = new Weapon1(4.5, 6);
		weapons[3] = new Weapon2(7.0, 8);

		int hitPoints = 0;
		int action = 0; // this the sentinel LCV (loop control variable)

		int monsterChoice = 0;
		int equipmentChoice = 0;
		boolean isAlive = false; // opponent status

		String monsterName = "";
		String boutOutcome = "";
		int damage = 0;
		double windfall = 0.0; // represents the winner take all in a battle

		System.out.println("Welcome to the Arena of Doom!");
		System.out.print("What is your name, gladiator? ");

		name = myScanner.next();

		// instantiate a Gladiator with the 0-arg constructor
		Gladiator myGladiator = new Gladiator();
		myGladiator.setName(name);

		while (action != QUIT) {

			action = getValidMenuChoice(myScanner);

			switch (action) {

			case ARENA:
				monsterChoice = getValidMonsterChoice(myScanner);

				/*
				 * When the user fights a monster, and that monster is not a
				 * goblin, then modify the fighting code to: Update the
				 * Gladiator's state using the instance methods of the gladiator
				 * and the constants declared in AoD.
				 * 
				 * For example, the gladiator should lose OGRE_DAMAGE health
				 * when fighting an Ogre. The gladiator gains 2 silver.
				 * Hard-code this amount for now, but put a comment just above
				 * each hard-coded law that says // TODO: update this hard-coded
				 * value.
				 */

				switch (monsterChoice) {

				case GOBLIN:
					System.out
							.print("Enter the goblin's intial health points: ");
					hitPoints = myScanner.nextInt();
					damage = GOBLIN_DAMAGE;
					monsterName = "Goblin";

					Goblin myGoblin = new Goblin(hitPoints, damage, SILVER, 8);

					myGladiator.attack((Combatant) myGoblin, myGoblin.getCurrentHealth(),
							myGladiator.getName(), monsterName,
							myGladiator.getArmor().get(0).damage);

					boolean gladiatorPlayed = true;
					while (!isAlive) {
						int goblinHealth, gladiatorHealth;
						goblinHealth = myGoblin.getCurrentHealth();
						gladiatorHealth = myGladiator.getCurrentHealth();
						if (goblinHealth <= 0) {
							isAlive = true;
							System.out.println(monsterName + " has been killed!");
							System.out.println();
							System.out.println(myGladiator.getName() + " the Gladiator, defeats the Goblin!");
							myGladiator.setTreasureCarried(myGladiator.getTreasureCarried() + myGoblin.getTreasureCarried());
							break;
						} else if (gladiatorHealth <= 0) {
							isAlive = true;
							System.out.println(myGladiator.getName() + "the Gladiator, inflicted damage on the " + monsterName + "!");
							System.out.println();
							break;
						} else {
							if (gladiatorPlayed) {
								myGoblin.attack(myGladiator, myGladiator.getCurrentHealth(),
										myGladiator.getName(), monsterName, myGoblin.get_Damage_Dealt());
								gladiatorPlayed = false;
							} else {
								myGladiator.attack(myGoblin, myGoblin.getCurrentHealth(),
										myGladiator.getName(), monsterName,
										myGladiator.getArmor().get(0).damage);
								gladiatorPlayed = true;
							}
						}
					}

					break;

				case OGRE:
					monsterName = "Ogre";
					System.out
							.print("Enter the ogre's intial health points: ");
					hitPoints = myScanner.nextInt();
					damage = OGRE_DAMAGE;
					windfall = STD_WINDFALL;

					Ogre myOgre = new Ogre(hitPoints, damage, windfall, "");

					myGladiator.attack( myOgre, myOgre.getCurrentHealth(),
							myGladiator.getName(), monsterName,
							myGladiator.getArmor().get(0).damage);

					gladiatorPlayed = true;
					while (!isAlive) {
						int goblinHealth, gladiatorHealth;
						goblinHealth = myOgre.getCurrentHealth();
						gladiatorHealth = myGladiator.getCurrentHealth();
						if (goblinHealth <= 0) {
							isAlive = true;
							System.out.println(monsterName + " has been killed!");
							System.out.println();
							System.out.println(myGladiator.getName() + " the Gladiator, defeats the Goblin!");
							myGladiator.setTreasureCarried(myGladiator.getTreasureCarried() + myOgre.getTreasureCarried());
							break;
						} else if (gladiatorHealth <= 0) {
							isAlive = true;
							System.out.println(myGladiator.getName() + "the Gladiator, inflicted damage on the " + monsterName + "!");
							System.out.println();
							break;
						} else {
							if (gladiatorPlayed) {
								myOgre.attack(myGladiator, myGladiator.getCurrentHealth(),
										myGladiator.getName(), monsterName, myOgre.get_Damage_Dealt());
								gladiatorPlayed = false;
							} else {
								myGladiator.attack(myOgre, myOgre.getCurrentHealth(),
										myGladiator.getName(), monsterName,
										myGladiator.getArmor().get(0).damage);
								gladiatorPlayed = true;
							}
						}
					}

					break;

				case GIANT:
					monsterName = "Giant";
					System.out
							.print("Enter the Giant's intial health points: ");
					hitPoints = myScanner.nextInt();
					damage = GIANT_DAMAGE;
					windfall = STD_WINDFALL;

					Giant myGiant = new Giant(hitPoints, damage, windfall);

					myGladiator.attack(myGiant, myGiant.getCurrentHealth(),
							myGladiator.getName(), monsterName,
							myGladiator.getArmor().get(0).damage);

					gladiatorPlayed = true;
					while (!isAlive) {
						int goblinHealth, gladiatorHealth;
						goblinHealth = myGiant.getCurrentHealth();
						gladiatorHealth = myGladiator.getCurrentHealth();
						if (goblinHealth <= 0) {
							isAlive = true;
							System.out.println(monsterName + " has been killed!");
							System.out.println();
							System.out.println(myGladiator.getName() + " the Gladiator, defeats the Goblin!");
							myGladiator.setTreasureCarried(myGladiator.getTreasureCarried() + myGiant.getTreasureCarried());
							break;
						} else if (gladiatorHealth <= 0) {
							isAlive = true;
							System.out.println(myGladiator.getName() + "the Gladiator, inflicted damage on the " + monsterName + "!");
							System.out.println();
							break;
						} else {
							if (gladiatorPlayed) {
								myGiant.attack(myGladiator, myGladiator.getCurrentHealth(),
										myGladiator.getName(), monsterName, myGiant.get_Damage_Dealt());
								gladiatorPlayed = false;
							} else {
								myGladiator.attack(myGiant, myGiant.getCurrentHealth(),
										myGladiator.getName(), monsterName,
										myGladiator.getArmor().get(0).damage);
								gladiatorPlayed = true;
							}
						}
					}

					break;

				case DRAGON:
					monsterName = "Dragon";
					System.out
							.print("Enter the Dragon's intial health points: ");
					hitPoints = myScanner.nextInt();
					damage = DRAGON_DAMAGE;
					windfall = STD_WINDFALL;


					Dragon myDragon = new Dragon(hitPoints, damage, windfall);

					myGladiator.attack(myDragon, myDragon.getCurrentHealth(),
							myGladiator.getName(), monsterName,
							myGladiator.getArmor().get(0).damage);

					gladiatorPlayed = true;
					while (!isAlive) {
						int goblinHealth, gladiatorHealth;
						goblinHealth = myDragon.getCurrentHealth();
						gladiatorHealth = myGladiator.getCurrentHealth();
						if (goblinHealth <= 0) {
							isAlive = true;
							System.out.println(monsterName + " has been killed!");
							System.out.println();
							System.out.println(myGladiator.getName() + " the Gladiator, defeats the Goblin!");
							myGladiator.setTreasureCarried(myGladiator.getTreasureCarried() + myDragon.getTreasureCarried());
							break;
						} else if (gladiatorHealth <= 0) {
							isAlive = true;
							System.out.println(myGladiator.getName() + "the Gladiator, inflicted damage on the " + monsterName + "!");
							System.out.println();
							break;
						} else {
							if (gladiatorPlayed) {
								myDragon.attack(myGladiator, myGladiator.getCurrentHealth(),
										myGladiator.getName(), monsterName, myDragon.get_Damage_Dealt());
								gladiatorPlayed = false;
							} else {
								myGladiator.attack(myDragon, myDragon.getCurrentHealth(),
										myGladiator.getName(), monsterName,
										myGladiator.getArmor().get(0).damage);
								gladiatorPlayed = true;
							}
						}
					}


					break;

				default:
					System.out.println("Error! Unrecognized monster.");
					break;

				} // end of monster switch statement

				// update the treasure carried of the gladiator
				myGladiator.setTreasureCarried(
						myGladiator.getTreasureCarried() + windfall);

				// printouts needed
				System.out.printf("%s, the Gladiator, %s the %s!%n", name,
						boutOutcome, monsterName);

				break;

			case REST:
				hitPoints = 2;
				myGladiator.set_Current_Health(
						(myGladiator.getCurrentHealth() + hitPoints));
				myGladiator.setTreasureCarried(myGladiator.getTreasureCarried() - 1.0);
				System.out.println("");
				System.out.printf(
						"%s the Gladiator rests, gaining %d hit points.%n",
						name, hitPoints);
				System.out.printf("Hit points are now: %d%n",
						myGladiator.getCurrentHealth());
				break;

			case SHOP:

				equipmentChoice = getValidEquipmentChoice(myScanner);

				switch (equipmentChoice) {
					case CLUB:
						if (myGladiator.getTreasureCarried() >= CLUB_COST) {
							Club club = new Club(CLUB_COST, CLUB_DMG, "Oak");
							myGladiator.setTreasureCarried(myGladiator.getTreasureCarried() - CLUB_COST);
							myGladiator.setWeapon(club);
						} else {
							System.out.println("insufficient balance!");
						}
						break;
					case SWORD:
						if (myGladiator.getTreasureCarried() >= SWORD_COST) {
							Sword sword = new Sword(SWORD_COST, SWORD_DMG, false);
							myGladiator.setTreasureCarried(myGladiator.getTreasureCarried() - SWORD_COST);
							myGladiator.setWeapon(sword);
						} else {
							System.out.println("insufficient balance!");
						}
						break;
					case WEAPON1:
						if (myGladiator.getTreasureCarried() >= WEAPON1_COST) {
							Weapon1 weapon1 = new Weapon1(WEAPON1_COST, WEAPON1_DMG);
							myGladiator.setTreasureCarried(myGladiator.getTreasureCarried() - WEAPON1_COST);
							myGladiator.setWeapon(weapon1);
						} else {
							System.out.println("insufficient balance!");
						}
						break;
					case WEAPON2:
						if (myGladiator.getTreasureCarried() >= WEAPON2_COST) {
							Weapon2 weapon2= new Weapon2(WEAPON2_COST, WEAPON2_DMG);
							myGladiator.setTreasureCarried(myGladiator.getTreasureCarried() - WEAPON2_COST);
							myGladiator.setWeapon(weapon2);
						} else {
							System.out.println("insufficient balance!");
						}
						break;
					case RAGS:
						if (myGladiator.getTreasureCarried() >= RAGS_COST) {
							Rags rags = new Rags(RAGS_COST, RAGS_DMG, "RED");
							myGladiator.setTreasureCarried(myGladiator.getTreasureCarried() - RAGS_COST);
							myGladiator.setArmor(rags);
						} else {
							System.out.println("insufficient balance!");
						}
						break;
					case LEATHER:
						if (myGladiator.getTreasureCarried() >= LEAHTER_COST) {
							Leather leather = new Leather(LEAHTER_COST, LEATHER_DMG, 2.0);
							myGladiator.setTreasureCarried(myGladiator.getTreasureCarried() - LEAHTER_COST);
							myGladiator.setArmor(leather);
						} else {
							System.out.println("insufficient balance!");
						}
						break;
					case ARMOR1:
						if (myGladiator.getTreasureCarried() >= ARMOR1_COST) {
							Armor1 armor1 = new Armor1(ARMOR1_COST, ARMOR1_DMG);
							myGladiator.setTreasureCarried(myGladiator.getTreasureCarried() - ARMOR1_COST);
							myGladiator.setArmor(armor1);
						} else {
							System.out.println("insufficient balance!");
						}
						break;
					case ARMOR2:
						if (myGladiator.getTreasureCarried() >= ARMPR2_COST) {
							Armor2 armor2 = new Armor2(ARMPR2_COST, ARMOR2_DMG);
							myGladiator.setTreasureCarried(myGladiator.getTreasureCarried() - ARMPR2_COST);
							myGladiator.setArmor(armor2);
						} else {
							System.out.println("insufficient balance!");
						}
						break;
				}

				break;

			case STATUS:
				System.out.println("");
				System.out.printf("%s the Gladiator%n", name);
				System.out.printf("Hit points: %d Silver: %.1f%n",
						myGladiator.getCurrentHealth(),
						myGladiator.getTreasureCarried());

				ArrayList<Weapon> weaponArrayList = myGladiator.getWeapon();
				System.out.printf("Weapon: ");
				for (int i = 0; i < weaponArrayList.size(); i++) {
					System.out.println(weaponArrayList.get(i));
				}
				System.out.printf("Armor: ");
				ArrayList<Armor> armorArrayList = myGladiator.getArmor();
				for (int i = 0; i < armorArrayList.size(); i++) {
					System.out.println(armorArrayList.get(i));
				}
				break;

			case QUIT:
				System.out.println("");
				System.out.printf("%s The Gladiator has left the building.%n",
						name);
				System.out.printf("Goodbye, %s. Thank you for playing.", name);
				break;

			default:
				System.out.println("Error! Unrecognized menu choice.");
				break;

			} // end of action switch statement

		} // end of the while loop

		myScanner.close();

	} // end of main method

	private static void fighting(Gladiator myGladiator, Goblin myGoblin, boolean alive, String monsterName) {



	}

	/**
	 * purpose - static method returns an integer, called menu_choice. This
	 * method should: - display the menu - prompt the user to enter a menu
	 * option - validate this entry - if it is valid return the integer number
	 * of the menu entry - if it is invalid, display an error, and keep asking
	 * for a valid menu choice.
	 *
	 * @param input - a Scanner object to permit user input
	 * @return
	 * @return menu_choice - an integer representing the user's valid menu
	 *         choice
	 */
	public static int getValidMenuChoice(Scanner input) {

		int menu_choice;
		boolean isValid = false;
		// Declare variables for Object
		int ENTER_ARENA = 1;
		int QUIT = 5;
		int REST = 2;
		int SHOP = 3;
		int STATUS = 4;

		do {
			System.out.println("\nChoose an Action\n");
			// display menu list for menu choice
			System.out.printf("%d - Enter the Arena\n", ENTER_ARENA);
			System.out.printf("%d - Rest at the Healer's Tent\n", REST);
			System.out.printf("%d - Buy Equipment at the Bazaar\n", SHOP);
			System.out.printf("%d - Display Status\n", STATUS);
			System.out.printf("%d - Quit the Game\n", QUIT);

			System.out.print("\nWhat would you like to do: ");
			menu_choice = input.nextInt();

			isValid = !(menu_choice < ENTER_ARENA || menu_choice > QUIT);

			System.out.println((isValid ? ""
					: "Invalid menu choice. Please enter a number from the menu.\n"));

		} while (!isValid);

		return menu_choice;

	} // end of getValidMenuChoice

	public static int getValidEquipmentChoice(Scanner input) {

		int equipment_choice;

		System.out.println("\tWeapon\tDmg\tCost\n-------------------");
		System.out.println(CLUB + ".) " + "Club\t" + CLUB_DMG + "\t" + CLUB_COST);
		System.out.println(SWORD + ".) " + "Sword\t" + SWORD_DMG + "\t" + SWORD_COST);
		System.out.println(WEAPON1 + ".) " + "Weapon1\t" + WEAPON1_DMG + "\t" + WEAPON1_COST);
		System.out.println(WEAPON2 + ".) " + "Weapon2\t" + + WEAPON2_DMG + "\t" + WEAPON2_COST);
		System.out.println("\tArmor\tDmg\tCost\n-------------------");
		System.out.println(RAGS + ".) " + "Rags\t" + RAGS_DMG + "\t" + RAGS_COST);
		System.out.println(LEATHER + ".) " + "Leather\t" + LEATHER_DMG + "\t" + LEAHTER_COST);
		System.out.println(ARMOR1 + ".) " + "Armor1\t" + ARMOR1_DMG + "\t" + ARMOR1_COST);
		System.out.println(ARMOR2 + ".) " + "Armor2\t" + ARMOR2_DMG + "\t" + ARMOR1_COST);

		System.out.print("\nWhat would you like to buy: ");
		equipment_choice = input.nextInt();

		return equipment_choice;

	}

	/**
	 * 
	 * @param input
	 * @return an integer, called getValidMonsterChoice 
	 */
	public static int getValidMonsterChoice(Scanner input) {

		int monster_choice;
		boolean isValid = false;
		int GOBLIN = 1;
		int OGRE = 2;
		int GIANT = 3;
		int DRAGON = 4;

		do {
			System.out.println("\nChoose an Opponent\n");
			// display menu list for monster choice
			System.out.printf("%d - Goblin\n", GOBLIN);
			System.out.printf("%d - Ogre\n", OGRE);
			System.out.printf("%d - Giant\n", GIANT);
			System.out.printf("%d - Dragon\n", DRAGON);
			// System.out.printf("%d - Quit the Game\n", QUIT);

			System.out.print("\nWhat will you fight: ");
			monster_choice = input.nextInt();

			isValid = !(monster_choice < GOBLIN || monster_choice > DRAGON);

			System.out.println((isValid ? ""
					: "Invalid menu choice. Please enter a number from the menu.\n"));

		} while (!isValid);

		return monster_choice;
	} // end of getValidMonsterChoice

} // end of class Arena