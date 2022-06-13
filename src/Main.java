import GameUtil.Screen;

import GameUtil.Umpire;
import Models.Game;
import Models.Player;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        Player player2,player1;
        String player1Name,player2Name;
        do {
            Screen.clear();
            Umpire.giveInstructions();
            System.out.print("Player1, Enter your name: ");
            player1Name=scan.nextLine();

            System.out.print("Player2, Enter your name: ");
            player2Name=scan.nextLine();


            if(player1Name.compareTo(player2Name)==0)
                System.out.println("Both Player's name cannot be same..");


        }while (player1Name.compareTo(player2Name)==0);
        player1=new Player(player1Name);
        player2=new Player(player2Name);
        System.out.println("press enter to continue....");
        scan.nextLine();

        Game.start(player1,player2);
    }
}
