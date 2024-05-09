/**
 * ClassName - An example class for assignment: OBJECT INHERITANCE
 * Copyright 2021 Howard Community College
 * @author Hunnain Arsalan
 * @version 1.0
 *
 */
public class Monster implements Combatant {
    private int currentHealth;
    private int damageDealt;
    private double treasureCarried;

    public Monster(int currentHealth, int damageDealt, double treasureCarried) {
        this.currentHealth = currentHealth;
        this.damageDealt = damageDealt;
        this.treasureCarried = treasureCarried;
    }

    public Monster() {
        this.currentHealth = 0;
        this.damageDealt = 0;
        this.treasureCarried = 0;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void set_Current_Health(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getDamageDealt() {
        return damageDealt;
    }

    public void setDamageDealt(int damageDealt) {
        this.damageDealt = damageDealt;
    }

    public double getTreasureCarried() {
        return treasureCarried;
    }

    public void setTreasureCarried(double treasureCarried) {
        this.treasureCarried = treasureCarried;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "currentHealth=" + currentHealth +
                ", damageDealt=" + damageDealt +
                ", treasureCarried=" + treasureCarried +
                '}';
    }


    @Override
    public void attack(Combatant target, int targetHealth,
                       String gladiatorName, String monsterName, int damage) {
        getAttacked(target, targetHealth, monsterName, damage);
    }

    @Override
    public void getAttacked(Combatant target, int targetHealth,
                            String monsterName, int damage) {

    }
}
