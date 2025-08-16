package player;

public class Knight extends Player {

    public Knight(String name) {
        super(name,
                30,
                110,
                5,
                10,
                10,
                20,
                5,
                3,
                40,
                4,
                8,
                5,
                60);
    }

    @Override
    public void levelUp() {
        maxHealth += 10;
        minDamage+= 10;
        maxDamage += 10;
        fullHealth();
        level++;
        expToNextLevel *=1.5;
        System.out.println("💪 " + name + " leveled up to level " + level + "! Stats increased!");
    }

    @Override
    public void specialAttack() {
        System.out.println(name +" slammed his sword");
        int damage= calculateDamage() * 2;
        System.out.println(" it did "+ damage + " damage");

    }
}
