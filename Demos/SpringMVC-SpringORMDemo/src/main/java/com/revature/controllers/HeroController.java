package com.revature.controllers;

import com.revature.models.ClientMessage;
import com.revature.models.Hero;

import java.util.List;

public interface HeroController {

    ClientMessage registerHero(Hero hero);

    List<Hero> findAllHeroes();

    Hero findHero(String name);
}
