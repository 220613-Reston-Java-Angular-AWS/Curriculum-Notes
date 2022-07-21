package com.persistence;

import com.Util.HibernateUtil;
import com.models.SuperPrison;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SuperPrisonDAO {

    public int insert(SuperPrison superPrison){
        Session ses = HibernateUtil.getSession();
        Transaction tx = ses.beginTransaction();

        int pk = (int) ses.save(superPrison);

        tx.commit();
        return pk;
    }

    //selecting by id
    public SuperPrison selectById(int id){
        // we dont need a transaction because we are just querying the database

        Session ses = HibernateUtil.getSession();

        //HQL
        // here we are doing a simple query to return an object of type SuperPrison using the pk 'id'
        SuperPrison superPrison = ses.get(SuperPrison.class, id);

        return superPrison;
    }


    public List<SuperPrison> selectAll(){
        Session ses = HibernateUtil.getSession();

        //HQL
        List<SuperPrison> prisonList = ses.createQuery("from SuperPrison", SuperPrison.class).list();

        return prisonList;
    }

}
