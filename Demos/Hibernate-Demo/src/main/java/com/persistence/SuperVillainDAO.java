package com.persistence;

/*
* 3 different ways to write complex queries
* HQL - Hibernate Query Language
* Criteria API
* Native SQL
* */


import com.Util.HibernateUtil;
import com.models.SuperVillain;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class SuperVillainDAO {
    //insert
    public int insert(SuperVillain svill) {

        Session ses = HibernateUtil.getSession();
        Transaction tx = ses.beginTransaction();

        int pk = (int) ses.save(svill);

        tx.commit();
        return pk;
    }

    //selectAll
    public List<SuperVillain> selectAll() {
        //HQL - Hibernate Query Language
        //Combo of SQL & OOP

        Session ses = HibernateUtil.getSession();

        List<SuperVillain> villains = ses.createQuery("from SuperVillain", SuperVillain.class).list();
        //Hibernate will return instances of the SuperVillain class

        return villains;
    }

    public SuperVillain selectByName(String name) {

        Session ses = HibernateUtil.getSession();

        //Native SQL querying

//        SuperVillain villain = (SuperVillain)  ses.createNativeQuery("SELECT * FROM super_villains " +
//                "WHERE svill_name ='"+name+"'",SuperVillain.class).getSingleResult();


        //--------------------------------------------------------------------------------------------------//


        // Criteria API

//        SuperVillain villain = (SuperVillain) ses.createCriteria(SuperVillain.class).add(Restrictions.like("svillName",name)).uniqueResult();

        //-----------------------------------------------------------------------------------------------------//

        //Hibernate Query Language
        SuperVillain villain = ses.createQuery("from SuperVillain WHERE svillName = '" + name + "'", SuperVillain.class).getSingleResult();

        return villain;
    }


    public void update(SuperVillain villain){
        Session ses = HibernateUtil.getSession();
        Transaction tx = ses.beginTransaction();


        ses.update(villain);

        tx.commit();
    }


    public void delete(SuperVillain villain){
        Session ses = HibernateUtil.getSession();
        Transaction tx = ses.beginTransaction();

        ses.delete(villain);
        tx.commit();
    }
}