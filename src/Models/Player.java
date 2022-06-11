package Models;

import GameUtil.Screen;

import java.util.Scanner;

import static GameUtil.Validate.isNotValid;

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
        char confirmation='n';
        char[] validChoices=new char[]{'r','s','p'};
        char[] validConfirmations =new char[]{'y','n'};
        do{
            Screen.clear();
            System.out.println("Your Options are: Rock[r],Paper[p],Scissors[s] ");
            System.out.print(name+", your choice: ");
            choice=scan.next().charAt(0);
            choice=Character.toLowerCase(choice);
            if (isNotValid(choice,validChoices)){
                System.out.print("Invalid Choice\nPress Enter to continue..");
                scan.nextLine();
                scan.nextLine();
            }else{
                do {
                    System.out.print("Are You Sure?[y/n]: ");
                    confirmation=scan.next().charAt(0);
                    confirmation=Character.toLowerCase(confirmation);
                    if (isNotValid(confirmation, validConfirmations)){
                        System.out.print("Invalid Choice\nPress Enter to continue..");
                        scan.nextLine();
                        scan.nextLine();
                    }
                }while (isNotValid(confirmation, validConfirmations));

            }

        }while (isNotValid(choice,validChoices) || confirmation=='n');
        scan.nextLine();
        System.out.println("You have chosen: "+choice);
        System.out.println("Press enter to continue....");
        scan.nextLine();
    }

}
