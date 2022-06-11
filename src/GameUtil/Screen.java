package GameUtil;

import java.io.IOException;

public class Screen {
    public static void clear(){
        try{
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }catch (IOException e){
            System.out.println("IO Exception occurred While cleaning Screen");
        }catch (InterruptedException e){
            System.out.println("Interrupted Exception occurred While cleaning Screen");
        }
    }
}
