package Models;

import GameUtil.Screen;

import java.util.Scanner;

public class Player {
    private String name;
    private char choice;

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
        this.name = name;
    }

    public void choose(){
        Scanner scan= new Scanner(System.in);
        do{
            Screen.clear();
            System.out.println("Your Options are: Rock[r],Paper[p],Scissors[s] ");
            System.out.print(name+", your choice: ");
            choice=scan.next().charAt(0);
            choice=Character.toLowerCase(choice);
            if (choice!='r' && choice!='p' && choice!='s'){
                System.out.print("Invalid Choice\nPress Enter to continue..");
                scan.nextLine();
                scan.nextLine();
                Screen.clear();
            }

        }while (choice!='r' && choice!='p' && choice!='s');
    }
}
