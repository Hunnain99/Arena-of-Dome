/**
 * ClassName - An example class for assignment: EXERCISE COMPOSITION
 * Copyright 2021 Howard Community College
 * @author Hunnain Arsalan
 * @version 1.0
 *
 */

public class Rags extends Armor {

    private double cost;
    private int damage;
    private String color;

    public Rags() {
        super();
        this.cost = 0.5;
        this.damage = 2;
        this.color = "Dull grey";
    }

    public Rags(double cost, int damage, String color) {
        super(cost, damage);
        this.cost = cost;
        this.damage = damage;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Rags [ " + "cost: " + cost + ", " + "dmg: " + damage + " ]";
    }

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}