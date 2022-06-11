package GameUtil;

import Models.Player;

public class Umpire{
    public static void giveInstructions(){
        System.out.println("This is two player game");
    }
    public static void judge(Player player1, Player player2){
        System.out.println("========RESULT=========");
        System.out.println(player1.getName()+" Chose: "+player1.getChoice());
        System.out.println(player2.getName()+" Chose: "+player2.getChoice());

        if(player1.getChoice()==player2.getChoice()){
            System.out.println("Its A draw!!");
        }else if(player1.getChoice()=='r'){
                if (player2.getChoice()=='p')
                    System.out.println(player2.getName()+" won!!");
                else
                    System.out.println(player1.getName()+" won!!");
            } else if (player1.getChoice()=='p') {
                if (player2.getChoice()=='s')
                    System.out.println(player2.getName()+" won!!");
                else
                    System.out.println(player1.getName()+" won!!");
            }else {
                if (player2.getChoice()=='r')
                    System.out.println(player2.getName()+" won!!");
                else
                    System.out.println(player1.getName()+" won!!");
            }

    }
}