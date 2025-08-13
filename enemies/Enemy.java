package enemies;


import java.util.ArrayList;
import java.util.List;

public abstract class Enemy {
    public String name;
    public int minHealth;
    int maxHealth;
    int currentHealth;
    int minDamage;
    int maxDamage;
    int missChances;
    int criticalRate;
    int speed;
    int dropChance;
    int exp;
    int armorValue;


    public Enemy(String name,int criticalRate, int armorValue, int dropChance, int exp, int maxDamage,int minDamage, int minHealth,int maxHealth,int currentHealth,  int missChances,  int speed) {
       this.name = name;
       this.criticalRate = criticalRate;
       this.armorValue = armorValue;
       this.dropChance = dropChance;
       this.exp = exp;
       this.maxDamage = maxDamage;
       this.minDamage = minDamage;
       this.minHealth = minHealth;
       this.maxHealth = maxHealth;
       this.currentHealth = currentHealth;
       this.missChances = missChances;
       this.speed = speed;

    }
    public String getName() {
        return name;
    }
    public int getMinHealth() {
        return minHealth;
    }
    public int getMaxHealth() {
        return maxHealth;
    }
    public int getMinDamage() {return minDamage;}
    public int getMaxDamage() {return maxDamage;}
    public int getExp() {return exp;}


    public void setHealth(int health) {
        this.minHealth = health;
    }
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }
    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }
    public void setExp(int exp) {this.exp= exp;}

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



    public List<String> dropLoots() {
        List<String> loot = new ArrayList<>();
        if (Math.random() * 100 < dropChance) {
            System.out.println(name + " dropped");
            loot.add("potion");
        }
        if (Math.random() * 100 < (double) dropChance / 4) {
            loot.add("rare weapon");
        }
        return loot;
    }

    public void takeDamage(int damage) {

        int reducedDamage = Math.max(damage - armorValue, 0);
        if (reducedDamage == 0) {
            reducedDamage = 1;
        }
        currentHealth -= reducedDamage;

        if (currentHealth <= 0) {
            currentHealth = 0;
            System.out.println(name + " has been slain");
            dropLoots();

        }

    }
    public boolean isAlive() {
        return currentHealth > 0;
    }
//    public int getEncounterChance() {
//        return encounterChance;
//    }



}

