/**
 * ClassName - An example class for assignment: MORE COMPOSITION
 * Copyright 2021 Howard Community College
 * @author Hunnain Arsalan
 * @version 1.0
 *
 */
import java.io.*;
class Leather extends Armor {	// Class Leather Start
    private double cost;	//	Member Variable
    private int damage;	//	Member Variable
    private double thickness;	//	Member Variable

    public Leather()	// Constructor Default
    {
        this.cost=4.5;
        this.damage=3;
        this.thickness=2.0;
    }
    // Parameterized Constructor
    public Leather(double cost, int damage, double thickness) {
        super(cost, damage);
        this.cost = cost;
        this.damage = damage;
        this.thickness = thickness;
    }
    // Getter and setters for all member variables.
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

    public double getThickness() {
        return thickness;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    @Override
    public String toString() {
        return "Leather [ " + "cost: " + cost + ", " + "dmg: " + damage + " ]";
    }
}	// End Class Leather

