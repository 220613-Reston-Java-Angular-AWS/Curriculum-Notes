public class DoWhile {

    // we are not taking in any params
    // we are not making this method static
    // this means we will have to make an instance if this class
    public void printValueIfTrue(){
        boolean check = false;


        do {
            //this logic will be executed because the code reads top to bottom
            //meaning that the code says to print before the condition is actually checked
            //once the condition is checked- the program sees that the boolean value 'check'
            // is false so it will not execute again
            // however if 'check' was true, it would continue to
            //print the statement over and over. which is an infinite loop
            //until we change the value of check to false
            System.out.println("The do-while statement will execute logic at least once");
        } while(check == true);
    }
}
