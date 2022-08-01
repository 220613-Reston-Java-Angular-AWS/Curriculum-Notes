package com.revature.dao;

import com.revature.model.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class PokemonDAOImpl implements PokemonDAO{

    @Override
    public List<Pokemon> getAllPokemon() {
        List<Pokemon> pokemon = new ArrayList<>();

        Pokemon pikachu = new Pokemon(25,"Pikachu","electric",90);
        Pokemon snorlax = new Pokemon(143,"Snorlax","normal",60);
        Pokemon squirtle = new Pokemon(7,"Squirtle","water",50);

        pokemon.add(pikachu);
        pokemon.add(snorlax);
        pokemon.add(squirtle);

        return pokemon;
    }
}
