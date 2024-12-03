package Player;

public class Archer {
    public String name;
    public int health;
    int maxHealth;
    int minDamage;
    int maxDamage;
    int missChances;
    int criticalRate;
    int speed;
    int numberOfPotions;
    int runChance;
    int armorSlot;
    int weaponSlot;


   private Archer(String name) {
        this.name = name + " The Archer";
        this.health = 75;
        this.maxHealth = 75;
        this.minDamage = 5;
        this.maxDamage = 10;
        this.missChances = 30;
        this.criticalRate = 25;
        this.speed = 20;
        this.numberOfPotions = 3;
        this.runChance = 40;
        this.armorSlot = 1;
        this.weaponSlot = 1;
    }

    private int calculateDamage() {
        if (Math.random() * 100 < missChances) {
            System.out.println("Your arrows missed!");
            return 0;

        }
        int damage = (int) (Math.random() * (maxDamage - minDamage + 1)) + minDamage;
        if (Math.random() * 100 < criticalRate) {
            damage *= 2;
            System.out.println("HeadShot!");


        }


        return damage;
    }

    public int attack() {
        int damage = calculateDamage();
        System.out.println(name + " dealt " + damage + " damage!");
        return damage;
    }

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
}






