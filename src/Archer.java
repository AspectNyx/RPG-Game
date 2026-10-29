public class Archer extends Class {
    private int passive;

    public Archer(String playerName) {
        super(100, playerName, 150, 1);
        this.passive = 10;
    }
    public boolean dodge() {
        int chance = (int)(Math.random() * 100) + 1;
        return chance <= passive;
    }
    @Override
    public double attack() {
        int damage = 35;

        System.out.println("Archer attacked!");
        return damage;
    }
}
