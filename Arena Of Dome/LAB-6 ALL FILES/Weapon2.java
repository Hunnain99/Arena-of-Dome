import java.util.ArrayList;

public class Weapon2 extends Weapon {


    public Weapon2(double cost, int damage) {
        super(cost, damage);
    }


    public ArrayList<Weapon> getWeapon() {
        return weapons;
    }

    @Override
    public String toString() {
        return "Weapon2 [ " + "cost: " + cost + ", " + "dmg: " + damage + " ]";
    }

}
