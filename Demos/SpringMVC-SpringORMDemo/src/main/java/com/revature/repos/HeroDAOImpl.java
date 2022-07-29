package com.revature.repos;


import com.revature.models.Hero;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class HeroDAOImpl implements HeroDAO{

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public int insert(Hero hero) {
        return (int) sessionFactory.getCurrentSession().save(hero);
    }

//    @SuppressWarnings("unchecked")
    @Override
    public List<Hero> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(Hero.class).list();
    }


    @Override
    public Hero findByName(String name) {
        return (Hero) sessionFactory.getCurrentSession().createCriteria(Hero.class)
                .add(Restrictions.like("name",name)).list().get(0);
    }
}
