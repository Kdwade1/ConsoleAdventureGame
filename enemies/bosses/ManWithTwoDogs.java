package enemies.bosses;

public class ManWithTwoDogs extends Boss{
    public ManWithTwoDogs() {
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
            setMaxDamage((int) boostedMaxDamage);


        }
       if((double)health/ getMaxHealth() <0.50&&getPhases()>0){
           super.nextPhase();
           System.out.println("My DOGS!!!");
           double boostedMinDamage = getMinDamage() *2;
           double boostedMaxDamage = getMaxDamage() *2;
           setMinDamage((int) boostedMinDamage);
           setMaxDamage((int) boostedMaxDamage);
       }

    }
}
