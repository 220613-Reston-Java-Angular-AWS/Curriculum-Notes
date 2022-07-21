
// we can add the @FunctionalInterface but it is not bt force
//how ever when we do mark our interface as functional we get an error
//if we in fact try to define more than one method

@FunctionalInterface
public interface FunctionalInterfaceA {



    //there are different types of Interfaces

    // 1.Normal interface - this interface has multiple methods ex:Custom CRUD
              // interface that we created and implemented when we did our jdbc

    // 2.Single Abstract Method - SAM (Functional Interface)
             // in a functional interface only one method is defined

    // 3. Marker Interface

    void show();

}
