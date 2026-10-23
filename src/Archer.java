public class Archer extends Class {
    private int passive;
    public Archer( String PlayerName) {
        super(100, PlayerName, 150, 1);
        this.passive=passive;

    }
    @Override
    public double attack() {
        int damage = 35;
        int chance = (int)(Math.random() * 100) + 1;

        if (chance <= 10) {
            damage = damage * 2;
            System.out.println("Critical hit!");
        }

        System.out.println("Archer attacked!");
        return damage ;
    }
}
