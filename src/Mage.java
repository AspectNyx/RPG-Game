public class Mage extends Class {
    private int  passive;
    public Mage(String PlayerName) {
        super(110, PlayerName, 175, 1);
        this.passive=passive;
    }
    @Override
    public double attack() {
        int turn = 0;
        double damage = 35;
        int chance = (int) (Math.random() * 100) + 1;

        if (chance <= 15) {
            damage = damage * 2;
            System.out.println("Critical hit!");
        }
        if (turn == 3) {
            turn = 0;
            damage = damage * 1.5;
            turn++;
        }
        System.out.println("Mage attacked!");
        return damage;
    }

}

