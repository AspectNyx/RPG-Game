public abstract class  Class {
    private int armor;
    private String Name;
    private int health;
    private int lvl;
    private int xp;
    private int xpToLevelUp;

public Class(int Playerarmor, String PlayerName, int Playerhealth, int Playerlvl){
    this.armor = Playerarmor;
    this.Name=PlayerName;
    this.health=Playerarmor;
    this.lvl=Playerlvl;

    }
public abstract double attack();
  //ai used to help make xp level up system
    public void gainXP(int amount) {
        xp += amount;

        while (xp >= xpToLevelUp) {
            xp -= xpToLevelUp;
            lvl++;
            xpToLevelUp += 2;

            System.out.println("You leveled up!");
            System.out.println("Current level: " + lvl);
        }
    }

}
