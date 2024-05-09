import java.util.ArrayList;

public class Weapon1 extends Weapon {

    public Weapon1(double cost, int damage) {
        super(cost, damage);
    }

    public ArrayList<Weapon> getWeapon() {
        return weapons;
    }

    @Override
    public String toString() {
        return "Weapon1 [ " + "cost: " + cost + ", " + "dmg: " + damage + " ]";
    }

}
