//ai helped make enemy class
public class Enemy implements Class.Attackable {
    private int armor;
    private int health;
    private int Lvl;
    private int damage;
    private int xp;

    public Enemy(int Lvl, int floor, boolean boss) {
        this.Lvl = Lvl + (floor - 1) / 5;
        this.health = 80 + (floor - 1) * 15;
        this.armor = 5 + (floor - 1);
        this.damage = 15 + (floor - 1) * 2;
        this.xp = 30 + (floor - 1) * 5;

        if (boss) {
            this.health *= 3;
            this.damage *= 2;
            this.armor += 5;
            this.xp *= 3;
        }
    }

    @Override
    public double attack() {
        System.out.println("Enemy attacked!");
        return damage;
    }

    public void takeDamage(double comingDamage) {
        int actualDamage = (int) comingDamage - armor;

        if (actualDamage < 0) {
            actualDamage = 0;
        }

        health -= actualDamage;

        if (health < 0) {
            health = 0;
        }

        System.out.println("Enemy took " + actualDamage + " damage!");
        System.out.println("Enemy health: " + health);
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getXp() {
        return xp;
    }

    public int getLvl() {
        return Lvl;
    }
}
