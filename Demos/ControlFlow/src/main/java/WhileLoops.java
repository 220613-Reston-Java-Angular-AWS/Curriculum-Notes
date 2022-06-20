public class WhileLoops {

    public WhileLoops() {

    }

    public static void printFirst3Indexes(String[] associates) {

        // NOTE: Counter is starting at 2. (2 is the 3rd index in the array.)
//        int count = 2;
//
//        while (count >= 0) {
//            System.out.println(associates[count]);
//            count--;
//        }


        // OPTION 2: Keep the same order.
        int count = 0;

        while (count < 3) {
            System.out.println(associates[count]);
            count++;
        }


    }
}