package rmcreyes.clothing_app.signin_module;

/**
 * Created by robin on 2018-05-14.
 */

public class StringChecker {

    /**
     * A function to check if a string loosely follows the conventions
     * of a standard email address
     * @param input email address in question
     * @return validity of the email address
     */
    public static boolean checkEmail(String input) {
        String[] arr = input.split("@");

        if(arr.length != 2)
            return false;
        else if(!arr[1].contains("."))
            return false;
        else
            return true;
    }

    /**
     * A function to check if a string loosely follows the conventions
     * of a standard username
     * @param input username in question
     * @return validity of the username
     */
    public static boolean checkUsername(String input) {
        return input.length() >= 3 && input.length() <= 15;
    }

    /**
     * A function to check if a string loosely follows the conventions
     * of a standard password
     * @param input password in question
     * @return validity of the username
     */
    public static boolean checkPassword(String input) {
        return input.length() >= 3;
    }
}
