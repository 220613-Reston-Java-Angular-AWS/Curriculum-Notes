import java.util.List;
import java.util.Random;

public class Consumer implements Runnable{
    private List<String> buffer;

    public Consumer(List<String> buffer){
        this.buffer = buffer;
    }




    @Override
    public void run() {

        while(true){

            synchronized (buffer){

                if(buffer.isEmpty()){
                    continue;
                }

                if(buffer.get(0).equals(Main.EOF)){
                    System.out.println(Thread.currentThread().getName() + " exiting");
                    break;
                } else {

                    System.out.println(Thread.currentThread().getName() + " removed " + buffer.remove(0));

                    try {
                        Random random = new Random();
                        Thread.sleep(random.nextInt(1000));

                    } catch (Exception e){
                        System.out.println( Thread.currentThread().getName()+ " was interrupted");
                    }

                }


            }

        }


    }

}
