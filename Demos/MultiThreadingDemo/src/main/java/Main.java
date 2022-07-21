import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final String EOF = "EOF";

    public static void main(String[] args) throws Exception {


//        IntroToMultiThreading thread1 = new IntroToMultiThreading();
//        IntroToMultiThreading thread2 = new IntroToMultiThreading();



        // if we can the .run() method on a thread it will run, but it will not start a new thread
//        thread1.run();

//        thread1.run();
//        thread2.run();

//        thread1.join();
//        thread2.join();


//        for(int i = 1; i<=5;i++){
//
//            IntroToMultiThreading newThread = new IntroToMultiThreading(i);
//
//                    newThread.start();
//
//        }


        Counter counter = new Counter();

//      for( int i = 1 ; i<10;i++){
//          counter.increment();
//      }

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i = 1; i<=1000;i++){
                    counter.increment();
                }

            }
        });


        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i = 1; i<=1000;i++){
                    counter.increment();
                }

            }
        });

        thread3.start();
        thread4.start();

        thread3.join();
        thread4.join();



//        System.out.println(counter.count);

        // here is the intro to how we can solve the producer - consumer problem

        List<String> buffer = new ArrayList<>();

        Thread producerThread = new Thread( new Producer(buffer));
        producerThread.setName(" - Producer Thread");

        Thread consumerThread = new Thread( new Consumer(buffer));
        consumerThread.setName(" - Consumer 1 Thread");

        Thread consumerThread2 = new Thread( new Consumer(buffer));
        consumerThread2.setName(" - Consumer 2 Thread");

        producerThread.start();
        consumerThread.start();
        consumerThread2.start();







    }



}
