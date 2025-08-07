package player;

public abstract class Player {
    public String name;
    public int health;
    int maxHealth;
    int minDamage;
    int maxDamage;
    int missChances;
    int criticalRate;
    int speed;
    private int numberOfPotions;
    int runChance;
    int specialMeter;
    int maxSpecialMeter;
    int inventorySlot;
    int level;
    int exp;
    double expToNextLevel;
// constructor
    public Player(String name, int health, int maxHealth, int minDamage, int maxDamage,
                  int missChances, int criticalRate, int speed, int numberOfPotions, int runChance, int specialMeter, int maxSpecialMeter,int inventorySlot,double expToNextLevel) {
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
        this.level=1;
        this.exp=0;
        this.expToNextLevel=expToNextLevel;
    }

    public int getNumberOfPotions(){
        return numberOfPotions;
    }
    public void setNumberOfPotions(int numberOfPotions){
        if(numberOfPotions <0){
            this.numberOfPotions = 0;
        }else{
            this.numberOfPotions = numberOfPotions;
        }
    }
//calculate the actual damage
 protected int calculateDamage() {
        if (Math.random() * 100 < missChances) {
            System.out.println("Your attack missed!");
            return 0;

        }
        int damage = (int) (Math.random() * (maxDamage - minDamage + 1)) + minDamage;
        if (Math.random() * 100 < criticalRate) {
            damage *= 2;
            System.out.println("Critical!");


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
    public String getName(){
        return name;
    }
    public int getHealth(){
        return health;
    }
    public int getMaxHealth(){
        return maxHealth;
    }
    public void fullHealth(){
        this.health =this.maxHealth;
    }
    public void gainExp(int amount){
        System.out.println(name+" gained exp:"+ exp);
        exp+= amount;
        while (exp >= expToNextLevel){
            levelUp();
        }
    }
    public abstract void levelUp();

    public abstract void specialAttack();


}








