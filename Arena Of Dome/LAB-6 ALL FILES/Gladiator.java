import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * ClassName - An example class for assignment: EXERCISE COMPOSITION
 * Copyright 2021 Howard Community College
 * @author Hunnain Arsalan
 * @version 1.0
 *
 */

public class Gladiator implements Combatant {

    private String name;
    private int currentHealth;
//    private Club weapon;
//    private Rags armor;
    private ArrayList<Weapon> weapon = new ArrayList<>();
    private ArrayList<Armor> armor = new ArrayList<>();
    private double treasureCarried;

    public Gladiator() {
        this("The Masked", 10, new Club(1.0, 2, "Oak"), new Rags(1.0, 1, "RED"), 5.0);
    }

    public Gladiator(String name, int currentHealth, Club weapon, Rags armor, double treasureCarried) {
        this.name = name;
        this.currentHealth = currentHealth;
//        this.weapon = weapon;
        this.armor.add(armor);
        this.weapon.add(weapon);
        this.treasureCarried = treasureCarried;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void set_Current_Health(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public ArrayList<Weapon> getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
//        this.weapon = weapon;
        this.weapon.add(weapon);
    }

    public ArrayList<Armor> getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor.add(armor);
    }

    public double getTreasureCarried() {
        return treasureCarried;
    }

    public void setTreasureCarried(double treasureCarried) {
        this.treasureCarried = treasureCarried;
    }

    @Override
    public void attack(Combatant target, int targetHealth,
                       String gladiatorName, String monsterName, int damage) {
        System.out.println(gladiatorName + ", the Gladiator, is attacking!");
        getAttacked(target, targetHealth, monsterName, damage);
    }

    @Override
    public void getAttacked(Combatant target, int targetHealth, String monsterName, int damage) {
        System.out.println("The " + monsterName + " is being attacked!");
        target.set_Current_Health(targetHealth - damage);
        if ((targetHealth - damage) > 0) {
            System.out.println(monsterName + " is still alive!");
            System.out.println();
        }
    }
}