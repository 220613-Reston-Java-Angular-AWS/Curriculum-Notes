package com.wildanimals;

import com.animal.Animal;

public class Lion extends Animal {

    //note we have to variables in this class

    public Lion(){

    }

    // note we can only cause the super keyword
    // to inherit the name and age variable
    // why? -
    public Lion(String name, int age){
        super.name = name;
        super.age = age;
    }

    //we cannot access housePet becuase this Lion
    //class is not in the same package as our Animal Class
//    public Lion(boolean housePet){
//        super.housePet;
//    }

    @Override
    public String getOwner() {


        return "we are over-ridding the getter from our Animal super class";
    }

    @Override
    protected void setOwner(String owner) {
        super.setOwner("we can override our protected setter -  "+ owner);
    }
}
