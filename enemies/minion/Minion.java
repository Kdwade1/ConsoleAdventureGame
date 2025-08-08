package enemies.minion;

import enemies.Enemy;

public class Minion extends Enemy {
    public int encounterRate;

    public Minion(
            String name,           // 1
            int criticalRate,      // 2
            int armorValue,        // 3
            int dropChance,        // 4
            int exp,               // 5
            int maxDamage,         // 6
            int minDamage,         // 7
            int health,            // 8
            int missChances,       // 9
            int speed,             // 10
            int maxHealth,         // 11 (extra)
            int encounterRate      // 12 (extra)
    ) {
        super(
                name,
                criticalRate,
                armorValue,
                dropChance,
                exp,
                maxDamage,
                minDamage,
                health,
                missChances,
                speed
        );

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