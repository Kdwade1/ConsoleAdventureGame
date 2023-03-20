package Enemies;

public class Zombie {
    String name;
    int Health;
    int minDps;
    int maxDps;
    int maxSpeed;
    int minSpeed;
    int exp;
    int randomChanceRate;
    int potionDropRate;
    int missChances;
    int criticalRate;

    public Zombie( String name ,int Health, int minDps, int maxDps, int maxSpeed, int minSpeed ,int exp ,int randomChanceRate,int potionDropRate, int missChances ,int criticalRate){

        this.name=name;
        this.Health =Health;
        this.minDps=minDps;
        this.maxDps=maxDps;
        this.criticalRate=criticalRate;
        this.exp=exp;
        this.maxSpeed=maxSpeed;
        this.minSpeed=minSpeed;
        this.randomChanceRate=randomChanceRate;
        this.potionDropRate= potionDropRate;
        this.missChances= missChances;

    }

    @Override
    public String toString() {
        return "enemy{" +
                "name='" + name + '\'' +
                ", Health=" + Health +
                '}';
    }

    public Zombie() {
    }
}
