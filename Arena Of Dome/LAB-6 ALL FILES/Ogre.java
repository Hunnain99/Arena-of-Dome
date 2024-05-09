/**
 * ClassName - An example class for assignment: MORE COMPOSITION
 * Copyright 2021 Howard Community College
 * @author Hunnain Arsalan
 * @version 1.0
 *
 */

public class Ogre extends Monster implements Combatant {	// Class Orge
	String tribalName;	//	Member Variable

	public Ogre()	// CConstructor Default
	{
		super();
		tribalName="Unknown";
	}
	public Ogre(int cur,int dam, double treasureCarried, String tribe)	// Parameterized Constructor
	{
		super(cur, dam, treasureCarried);
		tribalName=tribe;
	}
	public void set_damagedealt(int dam)	// Setter
	{
		super.setDamageDealt(dam);
	}
	public void set_currenthealth(int cur)	// Setter
	{
		super.set_Current_Health(cur);
	}
	public void set_tribename(String tribe)	// Setter
	{
		tribalName=tribe;
	}
	public int get_Damage_Dealt()	// Getter
	{
		return super.getDamageDealt();
	}
	public double get_currenthealth()	// Getter
	{
		return super.getCurrentHealth();
	}
	public String get_tribename()	// Getter
	{
		return tribalName;
	}

	@Override
	public void attack(Combatant target, int targetHealth,
					   String gladiatorName, String monsterName, int damage) {
		System.out.println("The Ogre, is attacking!");
		getAttacked(target, targetHealth, gladiatorName, damage);
	}

	@Override
	public void getAttacked(Combatant target, int targetHealth,
							String gladiatorName, int damage) {
		System.out.println("The " + gladiatorName + " is being attacked!");
		target.set_Current_Health(targetHealth - damage);
		if ((targetHealth - damage) > 0) {
			System.out.println(gladiatorName + " is still alive!");
			System.out.println();
		}
	}

	@Override
	public String toString() {
		return "Ogre{" +
				"tribalName='" + tribalName + '\'' +
				'}';
	}
}		// End Class Ogre

