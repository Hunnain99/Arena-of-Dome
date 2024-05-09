public class Armor1 extends Armor {

    public Armor1(double cost, int damage) {
        super(cost, damage);
    }

    @Override
    public String toString() {
        return "Leather [ " + "cost: " + cost + ", " + "dmg: " + damage + " ]";
    }

}
