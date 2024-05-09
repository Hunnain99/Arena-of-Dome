/**
 * ClassName - An example class for assignment: EXERCISE COMPOSITION
 * Copyright 2021 Howard Community College
 * @author Hunnain Arsalan
 * @version 1.0
 *
 */
public class Goblin extends Monster implements Combatant{
    private int annoyanceLevel;     // Variable
    private final static double TREASURE_CARRIED  = 1.5;        // CONSTANT Variable

    // Default Constructor
    public Goblin(){
        super();
        this.annoyanceLevel = 5;    // Variable initializer
    }
    // Parametrize Constructor


    public Goblin(int currentHealth, int damageDealt, double treasureCarried, int annoyanceLevel) {
        super(currentHealth, damageDealt, treasureCarried);
        this.annoyanceLevel = annoyanceLevel;
    }

    public Goblin(int annoyanceLevel) {
        this.annoyanceLevel = annoyanceLevel;
    }

    // Setter
    public void set_Damage_Dealt(int damage) {
        super.setDamageDealt(damage);
    }
    // Setter
    public void set_Current_Health(int health) {
        super.set_Current_Health(health);
    }
    // Setter
    public void set_Annoyance_Level(int level) {
        this.annoyanceLevel = level;
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
    public int get_Annoyance_Level() {
        return this.annoyanceLevel;
    }
    // Getter
    public double get_TREASURE_CARRIED() {
        return TREASURE_CARRIED;
    }

    @Override
    public void attack(Combatant target, int targetHealth,
                       String gladiatorName, String monsterName, int damage) {
        System.out.println("The Goblin, is attacking!");
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
