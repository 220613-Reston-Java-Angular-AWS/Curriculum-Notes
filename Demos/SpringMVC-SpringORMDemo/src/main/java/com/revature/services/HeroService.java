package com.revature.services;

import com.revature.models.Hero;

import java.util.List;

public interface HeroService {
    boolean registerHero(Hero hero);
    List<Hero> getAllHeroes();
    Hero getHero(String name);
}
