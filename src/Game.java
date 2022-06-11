import GameUtil.Screen;
import GameUtil.Umpire;
import Models.Player;

import java.util.Scanner;

import static GameUtil.Validate.isNotValid;

public class Game {
    static void play(Player player1, Player player2)  {
        player1.choose();
        player2.choose();
        Umpire.judge(player1,player2);
    }
    static void start(Player player1,Player player2){
        char[] validConfirmations =new char[]{'y','n'};
        Scanner scan=new Scanner(System.in);
        char confirmation='n';
        do {
            play(player1,player2);
            do {
                System.out.print("Do You want To play again?[y/n]: ");
                confirmation=scan.next().charAt(0);
                confirmation=Character.toLowerCase(confirmation);
                if (isNotValid(confirmation, validConfirmations)){
                    System.out.print("Invalid Choice\nPress Enter to continue..");
                    scan.nextLine();
                    scan.nextLine();
                }
            }while (isNotValid(confirmation, validConfirmations));
        }while (confirmation=='y');
    }
}
