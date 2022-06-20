public class Main {

    public static void main(String[] args) {
        /*
                                        If Else
 */

        IfElse ifElseClass = new IfElse();

        System.out.println(ifElseClass.printTStringsOnly("Tiffany"));
        System.out.println(ifElseClass.checkStringLength("Tiffany Obi"));

        /*
                                        For Loops
 */


        //notice we didnt have to make an instance of the
        //'ForLoops' class in order to invoke this method

        //one way to create an array for a method param
        ForLoops.printAssociatesNames(new String[] {"JoJo","CJ","DeeAnne","David","Shane"});

        // the other way is to declare the array first
        // and assign it to a variable
        // then use the variable
        String[] associates = {"Shaquanna","Mark","Tyler","Eric","Janga","Li"};
        System.out.println(ForLoops.printTotalAssociateCount(associates));

        /*
                                        While Loop
 */
        // here we are using the associates array we created above
        //again, we are accessing this method on the class itself
        // because it is a static method
            WhileLoops.printFirst3Indexes(associates);


        /*
                                        Do-While
 */
        DoWhile doWhileClass = new DoWhile();

        //here we had to make an instance if the doWhile class
        //in order for us to invoke this method
        //Also not the method returns void
        //so, we are not using a System.out.println here
        //however we'll still see a print message because
        // there is a System.out.println in the actual method
        doWhileClass.printValueIfTrue();





        /*
                                       Switch Statements
 */

    SwitchStatements switchStatements = new SwitchStatements();
    switchStatements.switchStatement(80);

    }

}
