package Models;

import GameUtil.Screen;
import GameUtil.Storage;
import GameUtil.Umpire;
import Models.Player;

import static GameUtil.Validate.getConfirmation;

public class Game {
    static void play(Player player1, Player player2)  {
        Screen.clear();
        player1.choose();
        player2.choose();
        int result=Umpire.judge(player1,player2);
        if(result==1){
            player1.setScore(player1.getScore()+1);
            System.out.println(player1.getName()+" won!!");
        } else if (result==2) {
            player2.setScore(player2.getScore()+1);
            System.out.println(player2.getName()+" won!!");
        } else if (result==0) {
            System.out.println("!!Its A draw!!");
        }else {
            System.out.println("Something Went wrong");
        }
    }

    public static void start(Player player1, Player player2){
        do {
            play(player1,player2);
            System.out.println("===============\nCurrent Score\n====================");
            System.out.println(player1.getName()+": "+player1.getScore());
            System.out.println(player2.getName()+": "+player2.getScore());

        }while (getConfirmation("Do You want To play again?[y/n]: ")=='y');
        Storage.save(player1,player2);

    }
}
