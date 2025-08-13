package player;

import player.Player;

public class Warrior extends Player {

    public Warrior(String name) {
        super(" The Warrior ", 100,200, 10, 20, 20, 20, 40, 2, 50, 3, 7, 5, 100);
    }

    @Override
    public void levelUp() {

        maxHealth += 10;
        minDamage+= 10;
        maxDamage += 10;
        fullHealth();
        speed+= 10;
        level++;
        expToNextLevel *=1.5;
        System.out.println("💪 " + name + " leveled up to level " + level + "! Stats increased!");
    }

    @Override
    public void specialAttack() {

    }
}

