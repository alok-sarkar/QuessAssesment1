package GameUtil;

import java.util.Scanner;

public class Validate {
    public static boolean isNotValid(char charToValidate, char[] validOptions){
        for (char character : validOptions) {
            if(character==charToValidate)
                return false;
        }
        return true;
    }
    public static char getConfirmation(String prompt){
        char[] validConfirmations =new char[]{'y','n'};
        Scanner scan=new Scanner(System.in);
        char confirmation='n';
        do {
            System.out.print(prompt);
            confirmation=scan.next().charAt(0);
            confirmation=Character.toLowerCase(confirmation);
            if (isNotValid(confirmation, validConfirmations)){
                System.out.print("Invalid Choice\nPress Enter to continue..");
                scan.nextLine();
                scan.nextLine();
            }
        }while (isNotValid(confirmation, validConfirmations));
        return confirmation;
    }
}
