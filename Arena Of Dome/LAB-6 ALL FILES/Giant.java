/**
 * ClassName - An example class for assignment: MORE COMPOSITION
 * Copyright 2021 Howard Community College
 * @author Hunnain Arsalan
 * @version 1.0
 *
 */

public class Giant extends Monster implements Combatant{
    private final static double TREASURE_CARRIED  = 1.5;        // CONSTANT Variable

    // Default Constructor
    public Giant(){
        super();
    }
    // Parametrize Constructor


    public Giant(int currentHealth, int damageDealt, double treasureCarried) {
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
        System.out.println("The Giant, is attacking!");
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
}