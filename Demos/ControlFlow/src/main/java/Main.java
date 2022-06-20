public class Main {

    public static void main(String[] args) {

        /* If-Else */
        IfElse ifelse = new IfElse();

        String newString = "Hello World";
        System.out.println(ifelse.checkStringLength("Tiffany"));
        System.out.println(ifelse.printTStringsOnly(newString));


        /* For Loops */

        // Do not have to instantiate "ForLoops" class because the method is STATIC

        // OPTION 1: Create String array in the parameters of the method
        ForLoops.printAssociatesNames(new String[] {"Jo Jo", "CJ", "DeeAnne", "David", "Shane"});

        // OPTION 2: Declare array first, assign to variable, use variable in method parameter
        String[] associates = {"Shaquanna ", "Mark ", "Tyler ", "Eric ", "Janga ", "Li "};
        System.out.println(ForLoops.printTotalAssociatesNamesCount(associates));


        /* While Loops */
        WhileLoops.printFirst3Indexes(associates);


        /* Do-While Loop */
        DoWhile doWhile = new DoWhile();
        doWhile.printValueIfTrue();


        /* Switch Statement */
        SwitchStatement switchStatement = new SwitchStatement();
        switchStatement.gradeCalculator(95);

    }
}