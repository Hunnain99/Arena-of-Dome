/**
 * ClassName - An example class for assignment: MORE COMPOSITION
 * Copyright 2021 Howard Community College
 * @author Hunnain Arsalan
 * @version 1.0
 *
 */

public class Dragon extends Monster implements Combatant{
    private final static double TREASURE_CARRIED  = 1.5;        // CONSTANT Variable

    // Default Constructor
    public Dragon(){
        super();
    }
    // Parametrize Constructor


    public Dragon(int currentHealth, int damageDealt, double treasureCarried) {
        super(currentHealth, damageDealt, treasureCarried);
    }

    // Setter
    public void set_Damage_Dealt(int damage) {
        super.setDamageDealt(damage);
    }
    // Setter
    public void set_Current_Health(int health) {
        super.set_Current_Health(health);
    }

    // Getter
    public int get_Damage_Dealt() {
        return super.getDamageDealt();
    }
    // Getter
    public int get_Current_Health() {
        return super.getCurrentHealth();
    }
    // Getter
    public double get_TREASURE_CARRIED() {
        return TREASURE_CARRIED;
    }

    @Override
    public void attack(Combatant target, int targetHealth,
                       String gladiatorName, String monsterName, int damage) {
        System.out.println("The Dragon, is attacking!");
        getAttacked(target, targetHealth, monsterName, damage);
    }

    @Override
    public void getAttacked(Combatant target, int targetHealth,
                            String monsterName, int damage) {
        System.out.println("The Dragon is being attacked!");
        set_Current_Health(getCurrentHealth() - damage);
        if (getCurrentHealth()>=1)
        {
            System.out.println("The Dragon is still alive.");
        }
        else {
            System.out.println("The Dragon has been killed!");
        }
    }
}