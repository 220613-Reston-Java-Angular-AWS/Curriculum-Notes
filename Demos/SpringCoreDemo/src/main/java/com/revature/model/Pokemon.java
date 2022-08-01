package com.revature.model;

//introduction to Lombok

import lombok.*;

import java.util.Objects;

/**
 * Project Lombok (from now on, Lombok) is an annotation-based Java
 * library that allows you to reduce boilerplate code. Lombok offers various
 * annotations aimed at replacing Java code that is well known for being
 * boilerplate, repetitive, or tedious to write.
 */

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Pokemon {

    private int pokeId;
    private String pokeName;
    private String pokeType;
    private int attackPower;


    //Although we can use Lombok to set up our Constructors,
    //it can only give us 'no arg' or 'all arg' constructors without
    //complicating the code (project)
    //so, making our own constructors does still give us more control
    //and flexibility

    public Pokemon(){
        super();
    }

    public Pokemon(int pokeId, String pokeName, String pokeType, int attackPower) {
        this.pokeId = pokeId;
        this.pokeName = pokeName;
        this.pokeType = pokeType;
        this.attackPower = attackPower;
    }

    public Pokemon(String pokeName, String pokeType, int attackPower) {
        this.pokeName = pokeName;
        this.pokeType = pokeType;
        this.attackPower = attackPower;
    }
}
