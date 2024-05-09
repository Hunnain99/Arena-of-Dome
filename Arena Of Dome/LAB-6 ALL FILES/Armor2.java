public class Armor2 extends Armor {

    public Armor2(double cost, int damage) {
        super(cost, damage);
    }

    @Override
    public String toString() {
        return "Leather [ " + "cost: " + cost + ", " + "dmg: " + damage + " ]";
    }

}
