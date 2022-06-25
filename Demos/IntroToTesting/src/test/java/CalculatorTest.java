import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    // we do not need a constructor in this class
    // note we did not add a constructor to our 'Calculator' class either



    // implementing our tests


    // out additon test us testing the method 'addNumbers' from our Calculator class
    @Test
    public void additionTest(){

        Assertions.assertEquals(7,Calculator.addNumbers(3,4));
    }




    @Test
    public void isDivisibleTest(){
        Assertions.assertEquals(true,Calculator.isDivisible(100,24));
    }

}
