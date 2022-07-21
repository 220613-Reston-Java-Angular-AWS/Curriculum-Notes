package com.persistence;

import com.Util.HibernateUtil;
import com.models.Crime;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CrimeDAO {

    public int insert(Crime crime){

        //capture a Session
        Session ses = HibernateUtil.getSession();

        //This Transaction interface is uniwuely from Hibernate
        Transaction tx = ses.beginTransaction();

        // the save() method returns the generated primary
        int pk = (int) ses.save(crime);

        tx.commit();

        return pk;

    }









}
