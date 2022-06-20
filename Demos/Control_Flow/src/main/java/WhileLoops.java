public class WhileLoops {

    public static void printFirst3Indexes(String[] associates){
        //note we are setting count to 2 because we will decrement
        // and 2 is the third index
        int count = 2;

        while(count>=0){
            System.out.println(associates[count]);
            count--;
        }

        // the other way to do this if we wanted to keep the order
        // comment the code above and uncomment the code below
//       int count = 0;
//
//        while(count<3){
//             System.out.println(associates[count]);
//             count++;
//        }
    }

}
