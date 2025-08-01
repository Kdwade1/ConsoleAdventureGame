package game;

import enemies.Enemy;
import player.Player;
import player.Basic;
import player.Archer;
import player.Knight;
import player.Hero;
import player.Tank;

import enemies.minion.Bandit;
import enemies.minion.Zombie;
import enemies.minion.Witch;
import enemies.minion.Ghost;
import enemies.bosses.Boss;
import enemies.bosses.ManWithTwoDogs;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GameFrame {
    private Player player;
    private Basic basic; // Use Basic directly for testing
    private Knight knight;
    private Archer archer;
    private Hero hero;
    private Tank tank;

    private Scanner scanner = new Scanner(System.in);
    private boolean running = true;
    private final List<Enemy>enemyPrototype =List.of(
            new Bandit(),
            new Zombie(),
            new Witch(),
            new Ghost()


    );
    private Boss boss;
    private ManWithTwoDogs manWithTwoDogs;

    public static void slowPrint(String output) {
        for (int i = 0; i < output.length(); i++) {
            char c = output.charAt(i);
            System.out.print(c);
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        GameFrame game = new GameFrame();
        game.startGame();

    }

    public void startGame() {
        Scanner in = new Scanner(System.in);
        slowPrint("You come across a mysterious dungeon that you found during your travels. Before your adventure begins, we need to know exactly who you are.\n");

        System.out.print("What is your name, you deviant? ");
        String name = scanner.nextLine();

        slowPrint("Ah, so your name is " + name + "! That's a stupid name... Anyway, let's set you up as a Basic adventurer.\n");

        // Create Basic player
        basic = new Basic(name);
        knight = new Knight(name);
        archer= new Archer(name);
        tank = new Tank(name);
        hero = new Hero(name);

        System.out.println("\t 1. The Knight");
        System.out.println("\t 2. The Archer");
        System.out.println("\t 3. The Tank");
        System.out.println("\t 4. The Hero");
        String build = in.nextLine();
        switch (build) {
            case "1" -> {
                slowPrint("Ah you are " + name + " the knight"+  "\n");
                player= knight;


            }
            case "2" -> {
                slowPrint("Ah so you're " + name + " the archer" +  "\n");
                player= archer;

            }
            case "3" -> {
                slowPrint("Ah you are " + name + " the Tank" +  "\n");
                player = tank;

            }


            case "4" -> {
                slowPrint("....So you're " + name + "  the " + hero.name + "! Kinda cheap...\n");
                player= hero;

            }
            default -> {
                System.out.println("So you're .." + name + "  The" +basic.name +"....interesting choice \n");
                player= basic;


            }

        }

        slowPrint("You are now " + player.name + " with " + player.health + " health!\n");

        // Simulate actions with Basic player
//        player.usePotion();
//        player.takeDamage(15);

        System.out.println("Shall you enter?...(Y/N)");
        String confirm = in.nextLine().toLowerCase();

        switch (confirm) {
            case "y" -> {
                slowPrint("Fine...Be that way.......\n");
                Enemy firstEnemy = enemyPrototype.get(new Random().nextInt(enemyPrototype.size()));
                battle(firstEnemy);
            }
            case "n" -> {
                System.out.println("Thank you for listening!");
                System.exit(0);

            }
            default -> {
                System.out.println("Funny guy eh....");
                player.setNumberOfPotions(0);
                System.out.println("There you get no potions!");
                Enemy firstEnemy = new Bandit();
                battle(firstEnemy);

            }


        }
        System.out.println(" Well what are we doing today?");
        System.out.println("1. Fight the boss");
        System.out.println("2. Enter the gauntlet");
        String mode=in.nextLine();

        switch (mode) {
            case "1" -> {
                slowPrint("Fight the boss");

                battle(manWithTwoDogs);

            }
            case "2" -> {
                slowPrint("Enter the gauntlet");

            }
        }

    }
    public void runGauntlet(){
        System.out.println("\n You've step in the gauntlet...You can't escape now...");
        Enemy[] gauntletEnemy ={
                new Bandit(),
                new Zombie(),
                new Witch(),
                new Ghost()
        };
        for(Enemy enemy: gauntletEnemy){
            slowPrint("\n next foe appeared");
            battle(enemy);
        }

        if (player.getHealth() <= 0) {
            slowPrint("You fell in the Gauntlet...\n");
            return;
        }


    }

    public void battle(Enemy enemy) {
        slowPrint(" Oh no " + enemy.getName() + " appeared");
        while (player.getHealth() > 0 && enemy.isAlive()) {
            System.out.println("\n-------------------------");
            System.out.println("Your HP: " + player.getHealth());
            System.out.println(enemy.getName() + " HP: " + enemy.getHealth());
            System.out.println("-------------------------");

            System.out.println("Choose your action: [A]ttack or [P]otion");
            String input = scanner.nextLine().toLowerCase();
            switch (input) {
                case "a" -> {
                    int damage = player.attack();
                    enemy.takeDamage(damage);
                }
                case "p" -> player.usePotion();
                default -> System.out.println("I guess your going to do nothing... weird");
            }
            if (enemy.isAlive()) {
                int enemyDamage = enemy.attack();
                player.takeDamage(enemyDamage);
            }


                }
        if (player.getHealth() <= 0) {
            System.out.println("Oh what a shame....");
            System.exit(0);
        } else {
            slowPrint("You defeated the " + enemy.getName() + "!\n");
            List<String> loots = enemy.dropLoots();
            if (loots.isEmpty()) {
                System.out.println("The enemy dropped nothing.");
            } else {
                for (String item : loots) {
                    System.out.println("Looted: " + item);
                }
            }
        }
    }
}
