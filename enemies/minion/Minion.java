package enemies.minion;

import enemies.Enemy;
public class Minion extends Enemy {
    public int encounterRate;

    public Minion(int criticalRate, int armorValue, int dropChance, int exp,
                  int maxDamage, int health, int maxHealth, int missChances,
                  int minDamage, String name, int speed, int encounterRate) {

        super(name, criticalRate, armorValue, dropChance, exp,
                maxDamage, minDamage, health, missChances, speed);

        setMaxHealth(maxHealth);

        this.encounterRate = encounterRate;
    }
    public int getEncounterRate() {
        return encounterRate;
    }
    public void setEncounterRate(int encounterRate) {
        this.encounterRate = encounterRate;
    }
    
}