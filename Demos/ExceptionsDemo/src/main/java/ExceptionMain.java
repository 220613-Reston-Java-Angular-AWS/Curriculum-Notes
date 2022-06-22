import com.customException.MyCustomException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ExceptionMain {

    public static void checkAge(int age){

        if(age < 21){
            // using the 'throws' keyword allows you to throw a specific error

            throw new ArithmeticException("Access Denied- You must be 21 years old or older");
        } else {
            System.out.println("Access Granted- You are old enough");
        }

    }

    public static void useCustomException(String name) throws MyCustomException{

        if(name.length()<2){
            throw new MyCustomException("Name has to have more than one letter");
        }
    }


    public static String useIOResource() throws Exception {
        BufferedReader br = null;

            String userInput = "";
            br = new BufferedReader( new InputStreamReader(System.in));
            userInput = br.readLine();
            return "Hello " + userInput ;
    }



    public static void main(String[] args) throws Exception {

        int[] intArray = {1,2,3,4,5};

        //System.out.println(intArray[10]);

        // this gives us an error - specifically a runtime error
        // we know it's an error because our program could not recover from it




        // now were going to put this logic in a try block
        try {
            System.out.println(intArray[10]);
        } catch(Exception e){ //here is our catch block
            System.out.println("This is our catch block - Something went wrong in our 'try'");
        } finally { //our finally block is going to execute regardless of the try and catch
            System.out.println("Code in our finally block executes anyway");
        }


        // in this method we showed how we can throw a specific error
//        checkAge(15);

        // in this example we are putting the method in a try catch because we know that its possible
        //that this method can throw an error
     try {
         checkAge(15);
     } catch (Exception e){
         System.out.println("still used catch block to catch exception we know we threw");
     }




            // note, we do not always need a catch block
            // it is possible to try code in the 'try' block -
            // and not catch the error
            // the 'finally' block will still run


                try {
//                    System.out.println(intArray[10]);
                } finally {
                    System.out.println("The program will still end but the finally block is still executed");
                }




// here we want to handle our custom exception

        try {
            useCustomException("i");
        } catch (MyCustomException mce){
            System.out.println(mce.getMessage());
        }


        //this is where we would be able to use the reader without a try catch because we make the
        //main method signature tell the compiler that it can possibly throw an Exception
        //also showing how we would have to close it .

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String input = br.readLine();
//        System.out.println(input.length());
//        br.close();





        //since Java 7 we do not need to close the resource
        //here we want to try catch with resources
        // the resource we are going to use in BufferedReader which takes input from a user inn the counsel
        try {
            System.out.println(useIOResource());
        } catch (Exception e){
            e.getLocalizedMessage();
        }



    }






}
