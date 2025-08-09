package player;

public class Hero extends Player {
    private boolean isCharging; /// using
    private int chargeDamage;


    public Hero(String name) {
        super(name + " the Hero", 200, 200, 20, 100, 10, 50, 50, 5, 0,1,1,1,200);
        this.isCharging = false;
        this.chargeDamage = 0;

    }

    @Override
    public void specialAttack() {
        if (isCharging) {
            System.out.println(name + " is preparing a devastating attack.");
            int damage = calculateDamage() * 4; // Use the stored charge damage
            System.out.println(name + " dealt " + damage + " damage");
            isCharging = false;// Reset charging state
            chargeDamage = 0;// Reset charge damage
        }else{
            System.out.println(name + " is charging.");
            chargeDamage = calculateDamage();// Calculate and store base damage
            isCharging = true;// Set the hero to charging state
        }

    }

    @Override
    public void takeDamage(int damage) {
        if(isCharging){
            double chargeDamageMultiplier = 1.5;
            int amplifiedDamage = (int) (chargeDamage * chargeDamageMultiplier);
            System.out.println("Hero is vulnerable. Hero takes " + damage + " damage");
            damage += amplifiedDamage;
        }
        super.takeDamage(damage);
    }

    @Override
    public void levelUp() {
        maxHealth += 20;
        minDamage+= 10;
        maxDamage+=10;
        fullHealth();
        expToNextLevel*=1.5;
        level++;
        System.out.println("💪 " + name + " leveled up to level " + level + "! Stats increased!");
    }
}
