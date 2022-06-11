import GameUtil.Screen;
import GameUtil.Storage;
import GameUtil.Umpire;
import Models.Game;
import Models.Player;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        HashMap<String,String> leaderoard=new HashMap<>();
        Screen.clear();
        String[] usersScores=Storage.loadData();
        String[] highestScorer=usersScores[0].split("->");
        System.out.println("Highest Score: "+highestScorer[0]);
        Umpire.giveInstructions();
        System.out.print("Player1, Enter your name: ");
        String player1Name=scan.nextLine();

        Player player1=new Player(player1Name);
        System.out.print("Player2, Enter your name: ");
        String player2Name=scan.nextLine();
        Player player2=new Player(player2Name);

        System.out.println("Players Registered...\npress enter to continue....");

        scan.nextLine();

        Game.start(player1,player2);
    }
}
