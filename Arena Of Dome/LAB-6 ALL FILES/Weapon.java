import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * ClassName - An example class for assignment: OBJECT INHERITANCE
 * Copyright 2021 Howard Community College
 * @author Hunnain Arsalan
 * @version 1.0
 *
 */

public abstract class Weapon {
    protected double cost;
    protected int damage;
    ArrayList<Weapon> weapons;

    public Weapon(double cost, int damage) {
        this.cost = cost;
        this.damage = damage;
    }
    public Weapon() {
        this.cost = 0;
        this.damage = 2;
    }

    public abstract ArrayList<Weapon> getWeapon();

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public abstract String toString();
}
