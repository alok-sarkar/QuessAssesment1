package GameUtil;

import Models.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Umpire{
    static HashMap<Character,String> moveNames= new HashMap<>();
    static {
        moveNames.put('r',"Rock");moveNames.put('p',"Paper");moveNames.put('s',"Scissor");
    }
    public static void giveInstructions(){
        System.out.println("This is two player game");
    }
    public static int judge(Player player1, Player player2){
        int result=-1;
        Screen.clear();
        System.out.println("========RESULT=========");
        System.out.println(player1.getName()+" Chose: "+moveNames.get(player1.getChoice()));
        System.out.println(player2.getName()+" Chose: "+moveNames.get(player2.getChoice()));

        if(player1.getChoice()==player2.getChoice()){
            result=0;
        }
        else if(player1.getChoice()=='r'){
                result= (player2.getChoice()=='p') ? 2:1;

            }
        else if (player1.getChoice()=='p') {
                result= (player2.getChoice()=='s') ? 2:1;
            }
        else {
                result= (player2.getChoice()=='r') ? 2:1;
            }
    return result;
    }
}