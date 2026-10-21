public class Warrior extends Class{
    private int passive;

    public Warrior(int armor,String Name, int health, int lvl, int passive) {
        super(armor,Name, health, lvl);
        this.passive = passive;
    }
}
