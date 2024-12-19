package game;

import Player.Basic;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GameFrame {
    private Basic player; // Use Basic directly for testing
    private Scanner scanner = new Scanner(System.in);
    private boolean running = true;

    public static void slowPrint(String output) {
        for (int i = 0; i < output.length(); i++) {
            char c = output.charAt(i);
            System.out.print(c);
            try {
                TimeUnit.MILLISECONDS.sleep(30);
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
        player = new Basic(name);

        slowPrint("You are now " + player.name + " with " + player.health + " health!\n");

        // Simulate actions with Basic player
        player.usePotion();
        player.takeDamage(15);

        System.out.println("Shall you enter?...(Y/N)");
        String confirm = in.nextLine().toLowerCase();

        switch (confirm) {
            case "y" -> {
                slowPrint("Fine...Be that way.......\n");
            }
            case "n" -> {
                System.out.println("Thank you for listening!");
                System.exit(0);

            }
            default -> {
                System.out.println("Funny guy eh....");
                player.setNumberOfPotions(0 ) ;
                System.out.println("There you get no potions!");

            }


        }
    }
}
