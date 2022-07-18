public class Calculator {

    //add
    public static int addNumbers(int firstNum, int secondNum){
//        int sum = firstNum + secondNum;
//        return sum;
        return firstNum + secondNum;
    }


    //subtract
    public static int subtract(int firstNum, int secondNum){

        return firstNum - secondNum;
    }


    //multiply

    public static int multiply(int firstNum, int secondNum){

        return firstNum * secondNum;
    }



    //divide
    public static boolean isDivisible(int firstNum, int secondNum){

        //this logic is saying that if the remainder
        if((firstNum % secondNum) == 0){

            return true;
        }

        return false;
    }




}
