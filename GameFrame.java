import Player.*;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GameFrame {
    private Player player;
    private Scanner scanner= new Scanner(System.in);






    boolean running=true;
    static void slowPrint(String output) {
        for (int i = 0; i < output.length(); i++) {
            char c = output.charAt(i);
            System.out.print(c);
            try {
                TimeUnit.MILLISECONDS.sleep(30);
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args) {


//        while(running){
//            System.out.println("------------------------------");

        }




    public void room1(){
//lol
    }
}
