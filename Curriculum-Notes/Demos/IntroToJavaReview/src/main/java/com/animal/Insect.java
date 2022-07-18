package com.animal;

public class Insect {

    Animal animal = new Animal("Fellow life form",100,false,"God");


    //in our constructor we are just printing the params
    // from the animal instance we just created
    // note we are able to access protected and public variables/methods
    //because we are in the same package
   public Insect(){
       System.out.println(animal.name);
       System.out.println(animal.age);
       System.out.println(animal.housePet);

       //note if we didint have the getOwner method,
       // we could give it a value when instantiating the object
       // but we wouldnt be able to access it afterword
       System.out.println(animal.getOwner());


   }


   //note although we did not extend the animal class,
    //we are still able to access its default method
    //because we are int the same package
   public String callSayYourNameMethod(){
       return animal.sayYourName();
   }

}
