package Enemies;


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

        public Enemy(int criticalRate ,int armorValue, int dropChance, int exp, int maxDamage, int health, int maxHealth, int missChances, int minDamage, String name, int speed, int randomChanceRate) {
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
        }
    }

