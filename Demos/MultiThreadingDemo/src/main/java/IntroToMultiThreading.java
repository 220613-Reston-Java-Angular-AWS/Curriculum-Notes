public class IntroToMultiThreading extends Thread {

    // Concurrency: refers to breaking up a task into different parts that
    // can be executed independently, out of order, or in partial order without
    // affecting the final outcome. One way - of achieving concurrency
    // is using multiple threads in the same program


    //Multithreading: extends the idea of multitasking into applications
    //whee you can subdivide operations in a single application into individual
    //parallel threads.  Each thread can have its own task to perform

    //one way to add multithreading into your application is by extending the Thread Class

    public int threadNumber;

    public IntroToMultiThreading(int threadNumber){
        this.threadNumber = threadNumber;
    }




    @Override
    public void run() {
//        super.run();
        // this is just to test threads

        for(int i = 1 ;i <=5;i++){

            // note if we have an error on one of our threads it
            // does not interrupt any of the other threads

//            if (threadNumber == 3){
//                throw new RuntimeException();
//            }



            System.out.println(i + " this is thread: " + Thread.currentThread().getName());

            // here were going to tell the thread to sleep for one second sp
            //we can see the number print one by one
            //must surround the sleep method with a try catch

            try {
                Thread.sleep(1000);
            }catch (Exception e){

            }
        }
    }
}
