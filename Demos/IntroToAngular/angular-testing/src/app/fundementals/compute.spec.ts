
//Step 1
import { compute } from "./compute";

// we use Jasmine as our testing framework
// the two most popular methods we use are
    // describe() -> refers to a suite of tests (a group of related tests)
    //it() -> refers to a specific unit test (defined as a spec or test)

// Functional Testing - a black box technique in which output is validated against the input provided to the application
    //1 Unit Testing - testing the smallest functional testable unit
    //2 Integration Testing - 2 or more unit tested components of software are integrated together
             //3 Interface Testing -
    //4 System Testing
    //5 Regression TEsting
    //6 Smoke Testing
    //7 Sanity Testing
    //8 Acceptance Testing

    //Step 2
    // we will call the suite 'compute' because what we are testing is the compute method
    describe('compute', () => {


        //Step 3
        //here we name the test itself -> we want to be relatively specificso we know exactly what the test is doing
        it('should return 0 if input is negative', ()=> {
            const result = compute(-1);

            // we need to assert (check or see) that the value will be what we are looking
            //there are a bunch of methods that can be used on this expect() - it all depends on what you need to test
            expect(result).toBe(0)
           
        })

        it('should increment if input is positive', ()=> {
            const result = compute(0);

            // we need to assert (check or see) that the value will be what we are looking
            //there are a bunch of methods that can be used on this expect() - it all depends on what you need to test
            expect(result).toBe(1)
           
        })






    })
