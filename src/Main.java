//// ai made the interactable menu cause im wanted too see the full game work
import java.util.Scanner;

void main() {
    Scanner input = new Scanner(System.in);
    int floor = 1;

    // Choose character name
    System.out.print("Enter your character name: ");
    String playerName = input.nextLine();

    // Choose class
    System.out.println("Choose your class:");
    System.out.println("1. Warrior");
    System.out.println("2. Archer");
    System.out.println("3. Mage");
    System.out.print("Choice: ");

    int choice = input.nextInt();
    Class player;

    // Class deciding
    switch (choice) {
        case 1:
            player = new Warrior(playerName);
            break;
        case 2:
            player = new Archer(playerName);
            break;
        case 3:
            player = new Mage(playerName);
            break;
        default:
            System.out.println("Invalid choice. Starting as Warrior.");
            player = new Warrior(playerName);
    }

    System.out.println("Welcome to the game, " + playerName + "!");

    boolean playing = true;

    // Start game
    while (playing) {
        System.out.println("\n--- MAIN MENU ---");
        System.out.println("Current floor: " + floor);
        System.out.println("1. Fight an enemy");
        System.out.println("2. View Stats");
        System.out.println("3. Quit");
        System.out.print("Choice: ");

        int menuChoice = input.nextInt();

        switch (menuChoice) {

            case 1: {
                // Boss appears every 5 floors
                boolean bossFloor = floor % 5 == 0;

                Enemy enemy = new Enemy(
                        player.getLvl(), floor, bossFloor
                );

                if (bossFloor) {
                    System.out.println("\nBOSS FIGHT!");
                    System.out.println("You reached floor " + floor + "!");
                } else {
                    System.out.println("\nAn enemy appeared!");
                    System.out.println("Floor: " + floor);
                }

                System.out.println("Enemy level: " + enemy.getLvl());

                // Battle
                while (enemy.isAlive() && player.isAlive()) {
                    System.out.println("\n1. Attack");
                    System.out.println("2. Run away");
                    System.out.print("Choice: ");

                    int battleChoice = input.nextInt();

                    if (battleChoice == 1) {
                        // Player attacks
                        enemy.takeDamage(player.attack());

                        // Enemy attacks if still alive
                        if (enemy.isAlive()) {
                            double enemyDamage = enemy.attack();

                            // Warrior block passive
                            if (player instanceof Warrior warrior
                                    && warrior.blockAttack()) {
                                System.out.println(
                                        "You blocked the enemy's attack!"
                                );
                            }

                            // Archer dodge passive
                            else if (player instanceof Archer archer
                                    && archer.dodge()) {
                                System.out.println(
                                        "You dodged the enemy's attack!"
                                );
                            }

                            // Take damage if attack was not blocked or dodged
                            else {
                                player.takeDamage(enemyDamage);
                            }
                        } else {
                            System.out.println("Enemy defeated!");

                            int earnedXP = enemy.getXp();
                            player.gainXP(earnedXP);

                            System.out.println(
                                    "You earned " + earnedXP + " XP!"
                            );
                        }

                    } else if (battleChoice == 2) {
                        System.out.println("You escaped!");
                        break;

                    } else {
                        System.out.println("Invalid choice.");
                    }
                }

                // Check if the player died
                if (!player.isAlive()) {
                    System.out.println("You died! Game over.");
                    playing = false;
                }

                // Advance only after defeating the enemy
                else if (!enemy.isAlive()) {
                    if (bossFloor) {
                        System.out.println("Boss defeated!");
                    }

                    floor++;
                    System.out.println(
                            "You advanced to floor " + floor + "!"
                    );
                }

                break;
            }

            case 2:
                System.out.println("\n--- PLAYER STATS ---");
                System.out.println("Name: " + playerName);
                System.out.println("Level: " + player.getLvl());
                System.out.println("Floor: " + floor);
                break;

            case 3:
                playing = false;
                System.out.println("Thanks for playing!");
                break;

            default:
                System.out.println("Invalid choice.");
        }
    }

    input.close();
}
