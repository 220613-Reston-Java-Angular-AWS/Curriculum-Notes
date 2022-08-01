package com.revature.service;

import com.revature.dao.PokemonDAO;
import com.revature.model.Pokemon;

import java.util.List;

// Note the 'heavy lifting' of communicating with the db will be done in the dao only!
//here we should onlyyy be calling the methods from the dao itself
// aka strictly business logic - no lower level logic
public class PokemonServiceImpl implements PokemonService{

    private PokemonDAO pokedao;

    //here we are using dependency injection
    // to set our PokemonDAO

    public PokemonServiceImpl(PokemonDAO pokedao){

        this.pokedao = pokedao;
    }



    @Override
    public List<Pokemon> catchEmAll() {

        return pokedao.getAllPokemon();
    }
}
