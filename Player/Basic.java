package Player;

public class Basic {
    public String name;
    public int health;
    int minDamage;
    int maxDamage;
    int missChances;
    int criticalRate;
    int speed;
    int numberOfPotions;
    int runChance;
    int armorSlot;
    int weaponSlot;


    public Basic(String name, int health, int minDamage, int maxDamage, int missChances, int criticalRate, int speed, int numberOfPotions, int runChance, int armorSlot, int weaponSlot) {
        this.name = name;
        this.health = health;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.missChances = missChances;
        this.criticalRate = criticalRate;
        this.speed = speed;
        this.numberOfPotions = numberOfPotions;
        this.runChance = runChance;
        this.armorSlot = armorSlot;
        this.weaponSlot = weaponSlot;
    }
}

