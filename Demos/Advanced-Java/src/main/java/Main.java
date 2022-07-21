public class Main {

    public static void main(String[] args) {

        // example 1 - this is how we would usually call a method

        FunctionalInterfaceA funcIntA = new FunctionalInterfaceA() {
            public void show() {
                System.out.println("I'm almost a full stack developer");
            }
        };

//        funcIntA.show();

        // here we are using a Lambda expression
        //note that a Lambda expression can only be used with a functional interface

        //eliminates extra boiler plate code as incorporates well as SOLID/DRY principals

        FunctionalInterfaceA funcIntAB = () -> {
            System.out.println(" Here is me using my first Lambda expression");
            System.out.println(" I have to use brackets because there is more than one line of code");
        };

//        funcIntAB.show();


        // example 2 -

        Notification notificationClass = new Notification();
        //first way

//        notificationClass.message();


        //second

        printNotification(notificationClass);


        // third - we are only going to give our printNotification() the implementation
        //of our functional interface

        printNotification( () -> {
            System.out.println("Wow! We just finished our Functional Interfaces / Lambda demo");
            System.out.println("I just love Advanced Java");
        });


    }



    static void printNotification(NotifyMe notifyMe){
        
        notifyMe.message();
    }





}
