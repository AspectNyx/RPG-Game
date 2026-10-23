public class Enemy {
    private int armor;
    private int health;
    private int lvl;
    private int xp;
    private int damage;

    public Enemy(int health, int armor, int level, int damage) {
        this.health = health;
        this.armor = armor;
        this.lvl = level;
        this.damage = damage;

        public int attack() {
            System.out.println("Enemy attacked!");
            return damage;
        }
    }



}
