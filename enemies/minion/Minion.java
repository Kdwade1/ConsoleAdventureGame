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
            int health,
            int maxHealth,
            int missChances,
            int speed,
            int encounterRate   // 12 (extra)
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
                maxHealth,
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