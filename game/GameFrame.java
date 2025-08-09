package game;

import enemies.Enemy;
import player.*;
import player.Basic;
import player.Archer;
import player.Knight;
import player.Hero;
import player.Tank;
import player.Warrior;

import enemies.minion.Minion;
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
    private Basic basic;
    private Knight knight;
    private Archer archer;
    private Hero hero;
    private Tank tank;
    private Warrior warrior;

    private final Scanner scanner = new Scanner(System.in);
    private final List<Enemy> enemyPrototype = List.of(
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
        slowPrint("You come across a mysterious dungeon that you found during your travels. Before your adventure begins, we need to know exactly who you are.\n");

        System.out.print("What is your name, you deviant? ");
        String name = scanner.nextLine();

        slowPrint("Ah, so your name is " + name + "! That's a stupid name... Anyway, let's set you up as a Basic adventurer.\n");

        // Initialize players
        basic = new Basic(name);
        knight = new Knight(name);
        archer = new Archer(name);
        tank = new Tank(name);
        warrior = new Warrior(name);
        hero = new Hero(name);

        // Initialize bosses
        manWithTwoDogs = new ManWithTwoDogs();

        System.out.println("\t 1. The Knight");
        System.out.println("\t 2. The Archer");
        System.out.println("\t 3. The Tank");
        System.out.println("\t 4. The Hero");
        System.out.println("\t 5. The Warrior");
        System.out.print("Choose your class: ");
        String build = scanner.nextLine();

        switch (build) {
            case "1" -> {
                slowPrint("Ah, you are " + name + " the Knight\n");
                player = knight;
            }
            case "2" -> {
                slowPrint("Ah, so you're " + name + " the Archer\n");
                player = archer;
            }
            case "3" -> {
                slowPrint("Ah, you are " + name + " the Tank\n");
                player = tank;
            }
            case "4" -> {
                slowPrint("...So you're " + name + " the " + hero.name + "! Kinda cheap...\n");
                player = hero;
            }
            case "5" -> {
                slowPrint("Ah, so you're " + name + " the Warrior\n");
                player = warrior;
            }
            default -> {
                System.out.println("So you're... " + name + " the " + basic.name + "....interesting choice\n");
                player = basic;
            }
        }

        player.fullHealth();

        slowPrint("You are now " + player.name + " with " + player.getHealth() + " health!\n");

        System.out.println("Shall you enter?...(Y/N)");
        String confirm = scanner.nextLine().toLowerCase();

        switch (confirm) {
            case "y" -> slowPrint("Fine... Be that way...\n");
            case "n" -> {
                System.out.println("Thank you for listening!");
                System.exit(0);
            }
            default -> {
                System.out.println("Funny guy, eh...");
                player.setNumberOfPotions(0);
                System.out.println("There you get no potions!");
                Enemy firstEnemy = new Bandit();
                battle(firstEnemy);
            }
        }

        while (true) {
            System.out.println("Well, what are we doing today?");
            System.out.println("1. Fight the boss");
            System.out.println("2. Enter the gauntlet");
            System.out.print("Select your option: ");
            String mode = scanner.nextLine();

            if (mode.equals("1")) {
                slowPrint("Fight the boss\n");
                battle(manWithTwoDogs);
                break;
            } else if (mode.equals("2")) {
                slowPrint("Enter the gauntlet\n");
                runGauntletOne();
                break;
            } else {
                System.out.println("Invalid input, please enter 1 or 2.");
            }
        }
    }

    // Pick random enemy based on encounter rate weights
    public Enemy getRandomEnemy(Minion[] enemies) {
        int totalRate = 0;
        for (Minion m : enemies) {
            totalRate += m.encounterRate;
        }
        int randomValue = new Random().nextInt(totalRate) + 1;

        for (Minion m : enemies) {
            randomValue -= m.encounterRate;
            if (randomValue <= 0) {
                return createFreshMinion(m);
            }
        }
        return createFreshMinion(enemies[0]);
    }

    public Minion createFreshMinion(Minion m) {
        if (m instanceof Bandit) return new Bandit();
        if (m instanceof Zombie) return new Zombie();
        if (m instanceof Witch) return new Witch();
        if (m instanceof Ghost) return new Ghost();
        return new Bandit();
    }

    // Gauntlet mode spawning and battling
    public void runGauntletOne() {
        System.out.println("\nYou've stepped into the gauntlet... You can't escape now...");
        Minion[] gauntletEnemy = {
                new Bandit(),
                new Zombie(),
                new Witch(),
                new Ghost()
        };
        int rounds = 10;

        for (int i = 0; i < rounds; i++) {
            Enemy enemy = getRandomEnemy(gauntletEnemy);
            System.out.println("\nAnother Foe has challenged you: " + enemy.getName() + "\n");
            battle(enemy);

            if (player.getHealth() <= 0) {
                slowPrint("You fell in the Gauntlet...\n");
                return;
            }

            if (i == rounds - 1) {
                System.out.println("\nLooks like you made it to the boss...");
                battle(manWithTwoDogs);
            }
        }
    }

    // Battle system
    public void battle(Enemy enemy) {
        slowPrint("Oh no! " + enemy.getName() + " appeared\n");
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
                default -> System.out.println("I guess you're going to do nothing... weird");
            }

            if (enemy.isAlive()) {
                int enemyDamage = enemy.attack();
                player.takeDamage(enemyDamage);
            }
        }

        if (player.getHealth() <= 0) {
            System.out.println("Oh what a shame.... Would you like to try again? ");
            System.out.println("A. Try again");
            System.out.println("B. Leave");
            String option = scanner.nextLine().toLowerCase();

            switch (option) {
                case "a" -> {
                    System.out.println("Very well.");
                    player.fullHealth();
                    runGauntletOne();
                }
                case "b" -> {
                    System.out.println("Smart, don't come back.");
                    System.exit(0);
                }
                default -> {
                    System.out.println("Invalid input. Exiting game.");
                    System.exit(0);
                }
            }
        } else {
            slowPrint("You defeated the " + enemy.getName() + "!\n");
            player.gainExp(enemy.getExp());
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