package Enemies;


import java.util.ArrayList;
import java.util.List;

public abstract class Enemy {
    public String name;
    public int health;
    int maxHealth;
    int minDamage;
    int maxDamage;
    int missChances;
    int criticalRate;
    int speed;
    int dropChance;
    int randomChanceRate;
    int exp;
    int armorValue;
    boolean isBoss;

    public Enemy(int criticalRate, int armorValue, int dropChance, int exp, int maxDamage, int health, int maxHealth, int missChances, int minDamage, String name, int speed, int randomChanceRate, boolean isBoss) {
        this.criticalRate = criticalRate;
        this.dropChance = dropChance;
        this.exp = exp;
        this.maxDamage = maxDamage;
        this.health = health;
        this.maxHealth = maxHealth;
        this.missChances = missChances;
        this.minDamage = minDamage;
        this.name = name;
        this.speed = speed;
        this.randomChanceRate = randomChanceRate;
        this.armorValue = armorValue;
        this.isBoss = isBoss;
    }
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public int getMaxHealth() {
        return maxHealth;
    }

    protected int calculateDamage() {
        System.out.println("The " + name + "attacks!");
        if (Math.random() * 100 < missChances) {

            return 0;

        }
        int damage = (int) (Math.random() * (maxDamage - minDamage + 1)) + minDamage;
        if (Math.random() * 100 < criticalRate) {
            damage *= 2;
            System.out.println("Critical!");


        }

        return damage;
    }

    public int attack() {
        int damage = calculateDamage();
        System.out.println(name + " dealt " + damage + " damage!");
        return damage;
    }

/*
    public boolean dropLoot() {
        if (Math.random() * 100 < dropChance) {
            System.out.println(name + " dropped");
            return true;
        } else return false;
    }
*/

    public List<String> dropLoots() {
        List<String> loot = new ArrayList<>();
        if (Math.random() * 100 < dropChance) {
            System.out.println(name + " dropped");
            loot.add("potion");
        }
        if (Math.random() * 100 < dropChance / 4) {
            loot.add("rare weapon");
        }
        return loot;
    }

    public void takeDamage(int damage) {

        int reducedDamage = Math.max(damage - armorValue, 0);
        if (reducedDamage == 0) {
            reducedDamage = 1;
        }
        health -= reducedDamage;

        if (health <= 0) {
            health = 0;
            System.out.println(name + " has been slain");
            dropLoots();

        }

    }
    public boolean isAlive() {
        return health > 0;
    }

}

