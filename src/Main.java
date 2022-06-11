import GameUtil.Screen;
import GameUtil.Umpire;
import Models.Player;

import java.util.Scanner;

public class Main {
    static void play(Player player1, Player player2)  {
        player1.choose();
        player2.choose();
        Umpire.judge(player1,player2);
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        Screen.clear();
        Umpire.giveInstructions();
        System.out.print("Player1, Enter your name: ");
        String player1Name=scan.nextLine();
        Player player1=new Player(player1Name);
        System.out.print("Player2, Enter your name: ");
        String player2Name=scan.nextLine();
        Player player2=new Player(player2Name);
        System.out.println("Players Registered...\npress enter to continue....");
        scan.nextLine();
        play(player1,player2);

    }
}
