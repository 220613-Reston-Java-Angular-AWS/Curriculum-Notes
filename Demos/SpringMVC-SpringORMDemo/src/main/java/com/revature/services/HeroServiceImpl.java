package com.revature.services;

import com.revature.models.Hero;
import com.revature.repos.HeroDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroServiceImpl implements HeroService {

    @Autowired
    HeroDAO heroDAO;


    @Override
    public boolean registerHero(Hero hero) {
        int pk = heroDAO.insert(hero);
        return (pk > 0) ? true: false;
    }

    @Override
    public List<Hero> getAllHeroes() {
        return heroDAO.findAll();
    }

    @Override
    public Hero getHero(String name) {
        return heroDAO.findByName(name);
    }
}
