import GameUtil.Screen;
import GameUtil.Umpire;
import Models.Player;

import java.util.Scanner;

import static GameUtil.Validate.getConfirmation;
import static GameUtil.Validate.isNotValid;

public class Game {
    static void play(Player player1, Player player2)  {
        player1.choose();
        player2.choose();
        Umpire.judge(player1,player2);
    }

    static void start(Player player1,Player player2){

        do {
            play(player1,player2);

        }while (getConfirmation("Do You want To play again?[y/n]: ")=='y');
    }
}
