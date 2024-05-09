import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * ClassName - An example class for assignment: EXERCISE COMPOSITION
 * Copyright 2021 Howard Community College
 * @author Hunnain Arsalan
 * @version 1.0
 *
 */

public class Club extends Weapon {
    private String woodType;

    @Override
    public String toString() {
        return "Club [ " + "cost: " + cost + ", " + "dmg: " + damage + " ]";
    }

    public Club() {
        super();
        this.woodType = "Oak";
    }

    public Club(double cost, int damage, String woodType) {
        super(cost, damage);
        this.woodType = woodType;
    }

    public ArrayList<Weapon> getWeapon() {
        return weapons;
    }

    public String getWoodType() {
        return woodType;
    }

    public void setWoodType(String woodType) {
        this.woodType = woodType;
    }

}