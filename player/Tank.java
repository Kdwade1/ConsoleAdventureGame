
package player;

import player.Player;

public class Tank extends Player {


    public Tank(String name) {
        super(name,40,70,4,5,30,30,5,6,70,2,6,8,50);
    }

    @Override
    public void levelUp() {
        maxHealth += 20;
        minDamage+= 5;
        maxDamage += 5;
        fullHealth();
        expToNextLevel *=1.5;
        System.out.println("💪 " + name + " leveled up to level " + level + "! Stats increased!");

    }

    @Override
    public void specialAttack() {

    }
}
