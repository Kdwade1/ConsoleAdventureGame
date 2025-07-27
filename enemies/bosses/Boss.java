package enemies.bosses;

import enemies.Enemy;

public class Boss extends Enemy {
    private final boolean hasPhase;
    private int phases;

    public Boss(String name, int criticalRate, int armorValue, int dropChance, int exp, int maxDamage, int minDamage, int health, int missChances, int speed, boolean hasPhase, int phases){
        super(name, criticalRate, armorValue, dropChance, exp, maxDamage, minDamage, health, missChances, speed);
        this.hasPhase = hasPhase;
        this.phases =phases;
    }



    public int getPhases() {
        return phases;
    }


    public void nextPhase(){
        if (hasPhase && phases >0 ){
            System.out.println("The "+ getName() + " is transforming" );
            phases--;
        }
    }
}
