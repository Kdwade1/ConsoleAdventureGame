
package player;

public class Archer extends Player{
    public Archer(String name) {
        super(name + " The Archer", 25, 50, 5, 10, 30,40, 30, 3, 65,1,4,5,50);
    }

    @Override
    public void levelUp() {
        maxHealth += 5;
        minDamage+= 5;
        maxDamage += 5;
        fullHealth();
        expToNextLevel *=1.5;
        System.out.println("💪 " + name + " leveled up to level " + level + "! Stats increased!");
    }

    @Override
    public void specialAttack() {
        System.out.println(name+ "fires a powerful shot");
       int damage = calculateDamage() * 2;
    }
}