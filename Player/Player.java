package Player;

public abstract class Player {
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
    int specialMeter;
    int maxSpecialMeter;
    int inventorySlot;
// constructor
    public Player(String name, int health, int maxHealth, int minDamage, int maxDamage,
                  int missChances, int criticalRate, int speed, int numberOfPotions, int runChance, int specialMeter, int maxSpecialMeter,int inventorySlot) {
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
    }
//calculate the actual damage
 protected int calculateDamage() {
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
    //calculates  attack
    public int attack() {
        int damage = calculateDamage();
        System.out.println(name + " dealt " + damage + " damage!");
        return damage;
    }
//use Potion
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
//calculates getting hit
    public void takeDamage(int damage){
       if (damage <0){
           System.out.println(name + "took no damage");
           return;
       }
       health -= damage;
       if (health <= 0){
           health= 0;
       }

       }
    public void buildSpecialMeter(int amount){
        specialMeter += amount;
        if (specialMeter > maxSpecialMeter) {
            specialMeter = maxSpecialMeter;
        }
        System.out.println(name+"s special meter:"+ specialMeter +"/"+maxSpecialMeter );

    }

    public abstract void specialAttack();


}








