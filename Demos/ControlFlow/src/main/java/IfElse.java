public class IfElse {

    // No Args
    public IfElse() {

    }

    public boolean checkStringLength(String input) {

        if (input.length() > 7) {
            return true;
        } else {

        return false;
        }

    }

    public String printTStringsOnly(String input) {

        char firstLetter = input.charAt(0);
        boolean check;

        if (String.valueOf(firstLetter).equals("T") || String.valueOf(firstLetter).equals("t")) {

            return input + " begins with the letter 't' !";
        } else {
             check = false;
        }

        return "Did this word begin with the letter 't'? : " + check;
    }






}