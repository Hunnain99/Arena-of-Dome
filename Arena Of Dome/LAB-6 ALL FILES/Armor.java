public abstract class Armor {

    protected double cost;
    protected int damage;

    public Armor() {}

    public Armor(double cost, int damage) {
        this.cost = cost;
        this.damage = damage;
    }

    @Override
    public abstract String toString();


}
