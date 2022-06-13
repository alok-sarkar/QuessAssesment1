package Models;

import GameUtil.Screen;
import GameUtil.Umpire;

import java.util.Scanner;

import static GameUtil.Validate.getConfirmation;
import static GameUtil.Validate.isNotValid;

public class Player {
    private String name;
    private char choice;

    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getChoice() {
        return choice;
    }

    public void setChoice(char choice) {
        this.choice = choice;
    }

    public Player(String name) {
        this(name,0);
    }

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public void choose(){
        Scanner scan= new Scanner(System.in);
        char[] validChoices=new char[]{'r','s','p'};
        do{
            Screen.clear();
            System.out.println(String.format("%c[%d;%df",0x1B,2,25)+"Your Options are: Rock[r],Paper[p],Scissors[s] ");
//            System.out.println("Your Options are: Rock[r],Paper[p],Scissors[s] ");
            System.out.print(name+", your choice: ");
            choice=scan.next().charAt(0);
            choice=Character.toLowerCase(choice);
            if (isNotValid(choice,validChoices)){
                System.out.print("Invalid Choice\nPress Enter to continue..");
                scan.nextLine();
                scan.nextLine();
            }
        }while (isNotValid(choice,validChoices) || getConfirmation("Are You Sure?[y/n]: ")=='n');
        scan.nextLine();
        System.out.println("You have chosen: "+ Umpire.moveNames.get(choice));
        System.out.println("Press enter to continue....");
        scan.nextLine();
    }

}
