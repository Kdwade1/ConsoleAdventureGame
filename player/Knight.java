package player;

public class Knight extends Player {

    public Knight(String name) {
        super(name, 30,35, 5, 10, 10, 20,5, 3, 40, 4, 8, 5);
    }

    @Override
    public void specialAttack() {
        System.out.println(name +" slammed his sword");
        int damage= calculateDamage() * 2;
        System.out.println(" it did "+ damage + " damage");

    }
}
