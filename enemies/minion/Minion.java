package enemies.minion;

import enemies.Enemy;

public class Minion extends Enemy {
    private final int encounterRate;
    private int maxHealth;

    public Minion(int criticalRate, int armorValue, int dropChance, int exp, int maxDamage, int health, int maxHealth, int missChances, int minDamage, String name, int speed,int encounterRate) {
        super(criticalRate, armorValue, dropChance, exp, maxDamage, health, maxHealth, missChances, minDamage, name, speed);
        this.encounterRate = encounterRate;
        this.maxHealth = maxHealth;
    }
    public int getEncounterRate() {
        return encounterRate;
    }

    @Override
    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }
}
