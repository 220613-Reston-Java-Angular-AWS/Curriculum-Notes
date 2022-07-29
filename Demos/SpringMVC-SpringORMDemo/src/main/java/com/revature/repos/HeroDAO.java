package com.revature.repos;

import com.revature.models.Hero;

import java.util.List;

public interface HeroDAO {

    int insert(Hero hero);

    List<Hero> findAll();

    Hero findByName(String name);

}