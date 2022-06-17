package com.animal;

public class Human extends Animal{

    public Boolean homebody;


    public Human(){

    }

    //Because we are in the same package we are able to access
    //the default variable housePet on our superclass
    //we could not do this in our Lion class
    public Human(Boolean homebody, boolean housePet){
        this.homebody = homebody;
        super.housePet = housePet;
    }

    public Human(String name){
        super.name = name;
    }


    @Override
    String sayYourName() {
        return "My name is " + super.name;
    }
}
