package Player;

public class Hero extends Player {
    private  boolean isCharging; /// using
    private int chargeDamage;


    public Hero(String name) {
        super(name + " the Hero", 200, 200, 20, 100, 10, 50, 50, 5, 0);
        this.isCharging = false;
        this.chargeDamage=0;

    }

    @Override
    public void specialAttack() {
        if(isCharging){
            System.out.println(name + "is preparing a devastating attack.");

        }

    }
}
