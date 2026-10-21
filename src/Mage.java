public class Mage extends Class {
    private int passive;
    public Mage(int armor, String Name, int health, int lvl, int passive) {
        super(armor, Name, health, lvl);
        this.passive=passive;
    }
}
