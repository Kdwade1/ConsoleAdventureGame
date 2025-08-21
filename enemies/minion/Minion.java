package enemies.minion;

import enemies.Enemy;

public class Minion extends Enemy {
    public int encounterRate;

    public Minion(
            String name,
            int criticalRate,
            int armorValue,
            int dropChance,
            int exp,
            int maxDamage,
            int minDamage,
            int minHealth,
            int maxHealth,
            int currentHealth,
            int missChances,
            int speed,
            int encounterRate
    ) {
        super(
                name,
                criticalRate,
                armorValue,
                dropChance,
                exp,
                maxDamage,
                minDamage,
                minHealth,   // ✅ correct order
                maxHealth,
                currentHealth,
                missChances,
                speed
        );

        this.encounterRate = encounterRate;
    }

    public int getEncounterRate() {
        return encounterRate;
    }

    public void setEncounterRate(int encounterRate) {
        this.encounterRate = encounterRate;
    }
}