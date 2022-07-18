public class IfElse {

    public boolean checkStringLength(String input){

        // the condition here says that if the length of the
        // incoming String 'input' is greater than 7
        // meaning there are more than 7 character in the string
        //it will return the boolean value of true
        if(input.length() > 7){
            return true;

            //else - meaning 'otherwise'
            //return the boolean value of false
        } else {
           return false;
        }

        // note that we do not need a return statement at the
        // of this method . this is because all possible conditions are
        // already counted for
    }


    public String printTStringsOnly(String input){

        //here we made a variable equal to the
        //first character of any String thats is put into the method
        char firstLetter = input.charAt(0);
        boolean check;
        // the || operator  is how we say "OR"
        // we are saying if the word starts with a capital or lowercase 't'
        // we want to print this statement

        if(String.valueOf(firstLetter).equals("T") || String.valueOf(firstLetter).equals("t") ){

            return input + " begins with the letter 't' !" ;
        } else {

            check = false;
        }
        return "Did this word begin with the letter t ? : " + check ;
    }







}
