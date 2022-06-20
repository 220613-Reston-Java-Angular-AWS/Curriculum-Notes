public class ForLoops {

    // notice these are static methods
    //meaning we will not have to make an instance of this
    //'ForLoops' class n order to invoke the methods

    public static void printAssociatesNames(String[] names){

        // here we have our basic for loop

        for(int i = 0; i < names.length; i++){
            System.out.println(names[i]);
        }

    }

    public static int printTotalAssociateCount(String[] associatesArray){
        int counter = 0;

        for(String singleAssociate: associatesArray){
            //here we are adding the length or count
            // of EACH string in the string array
            //to our counter
            counter += singleAssociate.length();
        }

//        after it has completed its loop through the string array (String[])
        //it will return the total count
        return counter;
    }




}
