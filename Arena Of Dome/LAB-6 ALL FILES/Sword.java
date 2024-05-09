/**
 * ClassName - An example class for assignment: MORE COMPOSITION
 * Copyright 2021 Howard Community College
 * @author Hunnain Arsalan
 * @version 1.0
 *
 */
import java.io.*;
import java.util.ArrayList;

class Sword extends Weapon {	// Class Sword
    boolean isEngraved;	//	Member Variable
    
    public Sword()	// Constructor
    {
        super();
        isEngraved=false;
    }

    public Sword(double cost, int damage, boolean isEngraved) {
        super(cost, damage);
        this.isEngraved = isEngraved;
    }

    public Sword(boolean isEngraved) {
        this.isEngraved = isEngraved;
    }

    public ArrayList<Weapon> getWeapon() {
        return weapons;
    }

    public boolean isEngraved() {
        return isEngraved;
    }

    public void setEngraved(boolean engraved) {
        isEngraved = engraved;
    }

    @Override
    public String toString() {
        return "Sword [ " + "cost: " + cost + ", " + "dmg: " + damage + " ]";
    }
}	// End of Sword

