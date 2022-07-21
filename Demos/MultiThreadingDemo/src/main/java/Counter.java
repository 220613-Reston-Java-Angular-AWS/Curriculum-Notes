public class Counter {
    //Synchronization is the ability to control the access
    // of multiple threads to a shared resource

    //'synchronized' keyword:
      //enforced that only one thread can access a resource at any given time

    int count;

    // when printing in the main : we can get the expected outcome the first time
    //but it is not consistent
    // when using the synchronized we see that there is no inconsistency with the expected outcome
    //for 2000


     public synchronized void increment(){
        count++;
    }



}
