package com.animal;

import com.animal.Animal;
import com.wildanimals.Lion;

public class Main {

    public static void main(String[] args) {


        Animal animalNoArgsConstructor = new Animal();

        Animal animalPublicFieldConstructor = new Animal("ParentAnimal");

        Animal animalAllNonPrivateFieldsConstructor = new Animal("ParentClassAnimal",3,true,"Tiffany");

        //this will print nil because we have not set the name
        System.out.println(animalNoArgsConstructor.name);

        // this will print ParentAnimal
        System.out.println(animalPublicFieldConstructor.name);

        //this will print Tiffany
        System.out.println(animalAllNonPrivateFieldsConstructor.getOwner() +
                " " + animalAllNonPrivateFieldsConstructor.housePet +
                " " + animalAllNonPrivateFieldsConstructor.name +
                " " + animalAllNonPrivateFieldsConstructor.age);

        //note :: because we have public getters and setter,
        // we are still able to get and set our private variable
        animalNoArgsConstructor.setOwner("New Owner");
        //this will print New Owner
        System.out.println(animalNoArgsConstructor.getOwner());


        //this will print null
        Lion noArgsLion = new Lion();
        System.out.println(noArgsLion.name);

        //here we invoked the constructor we created by implementing the
        //fields from the super class
        Lion usingSuperOnly = new Lion("Lion", 5);
        System.out.println(usingSuperOnly.age);

        //this will print the logic from our over-ridding method
        System.out.println(usingSuperOnly.getOwner());


        //note that because the human class is in the same
        //package as the animal class it can access the default
        //variable housePet
        Human human = new Human(true,false);
        System.out.println("Humans can be house pets - "+ human.housePet);
        System.out.println("Humans can be home bodies - " +human.homebody);

        //we can also override the default method in the Animal class
        //note this will print My name is null
        //null because we used super.name and super.name is null
        //with the constructor we invoked
        System.out.println(human.sayYourName());

        Human humanWithName = new Human("Maxwell");
        System.out.println(humanWithName.sayYourName());

        //note the different default values
        //of boolean and Boolean
        System.out.println(humanWithName.housePet +" - "+ humanWithName.homebody);

    }
}
