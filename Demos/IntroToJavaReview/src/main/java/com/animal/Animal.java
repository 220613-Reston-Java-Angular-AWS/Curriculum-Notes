package com.animal;

public class Animal {

    /*
                                         VARIABLE(s)
    // here we declare our variables or fields
    // these are considered the state of the class
     */


    //    public - Available anywhere
    public String name;

    //    protected - Within the same package, and this class' sub-classes
    protected int age;

    //    default (meaning, there is no access modifier given) -  Within the same package
    boolean housePet;

    //    private - Only within the same class
    private String owner;




/*
                                         CONSTRUCTOR(s)
    // after the declared variables is where we add our constructor(s)

 */

    // if we do not define one ourselves , the compiler will inject a "default" constructor for us
    // the default constructor is the "no args" constructor
    // this means that it does not take in any arguments

    public Animal(){

    }

    public Animal(String name){
    this.name = name;

    }

    //we can have multiple constructors = this is an example of method overloading
    // here is an "all-args" constructor
    // meaning all above fields are included as args or parameters.

    Animal(String name, int age, boolean housePet, String owner){
        this.name = name;
        this.age = age;
        this.housePet = housePet;
        this.owner = owner;
    }

    // here we are going to create a constructor that uses
    // all the fields that are not private

    Animal(String name, int age, boolean housePet){
        this.name = name;
        this.age = age;
        this.housePet = housePet;
    }



/*
                                            METHODS
 */

    //here is where we put our methods.
    //methods are considered the behavior

    //first we'll start off with getter and setter methods
    //this way we can practice encapsulation and access our private variable "owner"

    public String getOwner() {
        return owner;
    }

    protected void setOwner(String owner) {
        this.owner = owner;
    }

    String sayYourName(){
        return "";
    }
}
