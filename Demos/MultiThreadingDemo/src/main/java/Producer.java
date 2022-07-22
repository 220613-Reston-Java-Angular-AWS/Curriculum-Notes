import java.util.List;
import java.util.Random;

public class Producer implements Runnable{

    private List<String> buffer;


    public Producer(List<String> buffer){
        this.buffer = buffer;
    }


    @Override
    public void run() {

        String[] numbers = {"1","2","3"};


        for(String number: numbers) {

            synchronized (buffer) {
                buffer.add(number);

                try {
                    Random random = new Random();
                    Thread.sleep(random.nextInt(2000));

                } catch (Exception e) {
                    System.out.println(Thread.currentThread().getName() + " was interrupted");
                }
            }
            System.out.println(Thread.currentThread().getName() + " added " + number);
        }

        System.out.println(Thread.currentThread().getName() + " added " + Main.EOF);

            synchronized (buffer){
                buffer.add(Main.EOF);

            }

        }

    }

