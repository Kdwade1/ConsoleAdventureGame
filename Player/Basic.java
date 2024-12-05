package Player;

public class Basic extends Player {

    public Basic(String name) {
        super(name + " The fool", 25, 25, 2, 7, 30, 50, 20, 1, 75);
    }

    @Override
    public void specialAttack() {
        System.out.println(name + "  throws a bomb!");
        int damage = calculateDamage() *3;
    }
}

