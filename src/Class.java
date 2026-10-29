public abstract class  Class {
    private int armor;
    private String Name;
    private double health;
    private int lvl;
    private int xp;
    private int xptolevelup;

public Class(int Playerarmor, String PlayerName, double Playerhealth, int Playerlvl){
    this.armor = Playerarmor;
    this.Name=PlayerName;
    this.health=Playerhealth;
    this.lvl=Playerlvl;
    this.xp=0;
    this.xptolevelup=120;

    }
    public interface Attackable {
        double attack();
    }

    public abstract double attack();
  ///ai used to help make xp level up system
    public void gainXP(int amount) {
        xp += amount;

        while (xp >= xptolevelup) {
            xp -= xptolevelup;
            lvl++;
            xptolevelup += 2;

            System.out.println("You leveled up!");
            System.out.println("Current level: " + lvl);
        }
    }
    public boolean isAlive() {
        return health > 0;
    }

    public double getHealth() {
        return health;
    }
    public void takeDamage(double damage) {
        health = health - damage;

        if (health < 0) {
            health = 0;
        }

        System.out.println("Health: " + health);
    }
    public int getLvl(){
        return lvl;
    }

}
