package Player;

public class Archer extends Player{
    public Archer(String name) {
        super(name + " The Archer", 75, 75, 5, 10, 30,40, 30, 3, 65,1,4,5);
    }

    @Override
    public void specialAttack() {
        System.out.println(name+ "fires a powerful shot");
       int damage = calculateDamage() * 2;
    }
}