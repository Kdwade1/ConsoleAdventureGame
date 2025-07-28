package enemies.bosses;

import enemies.Enemy;

public class Boss extends Enemy {
    private final boolean hasPhase;
    private int phases;
    private  boolean[] phasesTriggered;



    public Boss(String name, int criticalRate, int armorValue, int dropChance, int exp, int maxDamage, int minDamage, int health, int missChances, int speed, boolean hasPhase, int phases){
        super(name, criticalRate, armorValue, dropChance, exp, maxDamage, minDamage, health, missChances, speed);
        this.hasPhase = hasPhase;
        this.phases =phases;

        if (hasPhase && phases > 0) {
            this.phasesTriggered = new boolean[phases];
        }
    }



    public int getPhases() {
        return phases;
    }




    public void nextPhase() {
        if (hasPhase && phases > 0) {
            System.out.println("The " + getName() + " is transforming");
            phases--;
        }
    }

    public boolean isPhaseTriggered(int phaseIndex) {
        return phasesTriggered != null && phasesTriggered[phaseIndex];
    }

    public void markPhaseTriggered(int phaseIndex) {
        if (phasesTriggered != null && phaseIndex < phasesTriggered.length) {
            phasesTriggered[phaseIndex] = true;
        }
    }

}
