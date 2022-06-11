import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  throws IOException, InterruptedException {
        Scanner scan=new Scanner(System.in);
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("This is two player game");

        System.out.print("Player1, Enter your name: ");
        String player1Name=scan.nextLine();
        System.out.print("Player2, Enter your name: ");
        String player2Name=scan.nextLine();
        System.out.println("Registered player names...\npress enter to continue....");
        scan.nextLine();
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        System.out.println("Your Options are: Rock[r],Paper[p],Scissors[s] ");
        System.out.print(player1Name+", Enter your choice: ");
        char player1choice=scan.next().charAt(0);

        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

        System.out.println("Your Options are: Rock[r],Paper[p],Scissors[s] ");
        System.out.print(player2Name+", Enter your choice: ");
        char player2choice=scan.next().charAt(0);
        umpire(player1Name,player2Name,player1choice,player2choice);


    }
    static void umpire(String player1,String player2, char player1Choice, char player2Choice){
        System.out.println("========RESULT=========");
        if(player1Choice==player2Choice){
            System.out.println("Its A draw!!");
        }else {
            System.out.println(player1+" Chose: "+player1Choice);
            System.out.println(player2+" Chose: "+player2Choice);
            if(player1Choice=='r'){
                if (player2Choice=='p')
                    System.out.println(player2+" won!!");
                else
                    System.out.println(player1+" won!!");
            } else if (player1Choice=='p') {
                if (player2Choice=='s')
                    System.out.println(player2+" won!!");
                else
                    System.out.println(player1+" won!!");
            }else {
                if (player2Choice=='r')
                    System.out.println(player2+" won!!");
                else
                    System.out.println(player1+" won!!");
            }
        }
    }
}
