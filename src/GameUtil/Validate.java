package GameUtil;

public class Validate {
    public static boolean isNotValid(char charToValidate, char[] validOptions){
        for (char character : validOptions) {
            if(character==charToValidate)
                return false;
        }
        return true;
    }
}
