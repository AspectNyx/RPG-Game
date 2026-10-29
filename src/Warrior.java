
public class Warrior extends Class {
    private int passive;

    public Warrior(String playerName) {
        super(150, playerName, 250, 1);
        this.passive = 20;
    }

    public boolean blockAttack() {
        int chance = (int)(Math.random() * 100) + 1;
        return chance <= passive;
    }
    @Override
    public double attack() {
        int damage = 35;
        int chance = (int)(Math.random() * 100) + 1;

        if (chance <= 20) {
            damage = damage * 2;
            System.out.println("Critical hit!");
        }

        System.out.println("Warrior attacked!");
        return damage;
    }
}
