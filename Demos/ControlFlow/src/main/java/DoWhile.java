public class DoWhile {

    // No constructor added to show that the program will create a default, no-args constructor for us.

    public void printValueIfTrue() {

        boolean check = false;

        do {

            /*
            This logic will be executed because the code reads from top to bottom, meaning that the code says to print before the condition is actually checked.
            Once the condition is checked, the program sees that the boolean value 'check' is false, so it will not execute again. However, if 'check' was true,
            it would continue to print the statement over and over, which is an infinite loop, until we change the value of 'check' to false.
            */

            System.out.println("The do-while statement will always execute at least once.");

        } while (check == true);
    }
}