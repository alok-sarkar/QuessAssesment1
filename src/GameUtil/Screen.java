package GameUtil;

import java.io.IOException;

public class Screen {
    public static void clear(){
        try{
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.println(String.format("%c[%d;%df",0x1B,1,40)+"Highest Score: "+Storage.getHighestScore()+" "+Storage.getHighestScorer());
//            System.out.println("Highest Score: "+Storage.getHighestScore());
        }catch (IOException e){
            System.out.println("IO Exception occurred While cleaning Screen");
        }catch (InterruptedException e){
            System.out.println("Interrupted Exception occurred While cleaning Screen");
        }
//
    }
}
