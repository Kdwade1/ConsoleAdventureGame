package player;

public abstract class Player {
    public String name;
    public double health;
    double maxHealth;
    double minDamage;
    double maxDamage;
    double missChances;
    double criticalRate;
    double speed;
    private int numberOfPotions;
    double runChance;
    double specialMeter;
    double maxSpecialMeter;
    int inventorySlot;
    int level;
    double exp;
    double expToNextLevel;

    // constructor
    public Player(String name, double health, double maxHealth, double minDamage, double maxDamage,
                  double missChances, double criticalRate, double speed, int numberOfPotions, double runChance,
                  double specialMeter, double maxSpecialMeter, int inventorySlot, double expToNextLevel) {
        this.name = name;
        this.health = health;
        this.maxHealth = maxHealth;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.missChances = missChances;
        this.criticalRate = criticalRate;
        this.speed = speed;
        this.numberOfPotions = numberOfPotions;
        this.runChance = runChance;
        this.specialMeter = specialMeter;
        this.maxSpecialMeter = maxSpecialMeter;
        this.inventorySlot = inventorySlot;
        this.level = 1;
        this.exp = 0;
        this.expToNextLevel = expToNextLevel;
    }

    public int getNumberOfPotions() {
        return numberOfPotions;
    }

    public void setNumberOfPotions(int numberOfPotions) {
        this.numberOfPotions = Math.max(0, numberOfPotions);
    }

    // Calculate the actual damage (rounded down to int)
    protected int calculateDamage() {
        if (Math.random() * 100 < missChances) {
            System.out.println("Your attack missed!");
            return 0;
        }
        double damage = (Math.random() * (maxDamage - minDamage)) + minDamage;
        if (Math.random() * 100 < criticalRate) {
            damage *= 2;
            System.out.println("Critical!");
        }
        return (int) damage;
    }

    // Attack returns int damage dealt
    public int attack() {
        int damage = calculateDamage();
        System.out.println(name + " dealt " + damage + " damage!");
        return damage;
    }

    // Use potion restores fixed amount
    public void usePotion() {
        if (numberOfPotions > 0) {
            health += 20;
            if (health > maxHealth) {
                health = maxHealth;
            }
            numberOfPotions--;
            System.out.println(name + " used a potion. Current health: " + health);
        } else {
            System.out.println(name + " has no potions left!");
        }
    }

    // Take damage decreases health (damage is int)
    public void takeDamage(int damage) {
        if (damage < 0) {
            System.out.println(name + " took no damage");
            return;
        }
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public void buildSpecialMeter(double amount) {
        specialMeter += amount;
        if (specialMeter > maxSpecialMeter) {
            specialMeter = maxSpecialMeter;
        }
        System.out.println(name + "'s special meter: " + specialMeter + "/" + maxSpecialMeter);
    }

    public String getName() {
        return name;
    }

    // Return current health as int (rounded down)
    public int getHealth() {
        return (int) health;
    }

    // Return max health as int (rounded down)
    public int getMaxHealth() {
        return (int) maxHealth;
    }

    public void fullHealth() {
        this.health = this.maxHealth;
    }

    // Gain exp, amount is int for consistency, exp is double
    public void gainExp(int amount) {
        exp += amount;
        System.out.println(name + " gained exp: " + amount + ", total exp: " + exp);
        while (exp >= expToNextLevel) {
            levelUp();
        }
    }

    public abstract void levelUp();

    public abstract void specialAttack();
}




