package enemies.bosses;

public class ManWithTwoDogs extends Boss{
    public ManWithTwoDogs(int criticalRate, int armorValue, int dropChance, int exp, int maxDamage, int health, int maxHealth, int missChances, int minDamage, String name, int speed, boolean hasPhase, int phases) {
        super("Man With Two Dogs",20,20,100,100,10,5,100,10,10,true,3);
    }

    @Override
    public void nextPhase() {
       if ((double) health/getMaxHealth()  < 0.75&& getPhases()>0){
          super.nextPhase();
            System.out.println("Oh no one of my dogs");
            double boostedMinDamage = getMinDamage() *1.2;
            double boostedMaxDamage = getMaxDamage() *1.2;
            setMinDamage((int) boostedMinDamage);
            setMinDamage((int) boostedMaxDamage);


        }

    }
}
