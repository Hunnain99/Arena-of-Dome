public interface Combatant {
    public abstract void attack(Combatant target, int targetHealth,
                                String gladiatorName, String monsterName, int damage);
    public abstract void getAttacked(Combatant target, int targetHealth,
                                     String monsterName, int damage);
    public void set_Current_Health(int health);
}
