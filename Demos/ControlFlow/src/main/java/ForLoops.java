public class ForLoops {

    public ForLoops() {

    }

    public static void printAssociatesNames(String[] names) {

        // Basic ForLoop
        for (int i = 1; i < 4; i++) {
            System.out.println(names[i]);

        }
    }

    public static int printTotalAssociatesNamesCount(String[] associatesArray) {

        int counter = 0;

        // Enhanced ForLoop
        for (String singleAssociate: associatesArray) {

            /*
            We are adding the length (count) of EACH string in the string array to our counter.
             */
            counter += singleAssociate.length();
        }

        // After going through the entire array, we will return the counter.
        return counter;
    }




}