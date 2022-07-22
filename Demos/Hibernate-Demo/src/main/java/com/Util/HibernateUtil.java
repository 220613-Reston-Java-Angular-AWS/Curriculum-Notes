package com.Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

// this is the wrong configuration import
//import javax.security.auth.login.Configuration;

import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    /*
    The purpose of the HibernateUtil.java class (Helper file) is to handle startup (Db connection)
    and access Hibernate's SessionFactory interface to obtain a Session Object

     */

    private static Session ses; // this is like the Connection interface from JDBC

    /*
    We will use SessionFactory interface to create a configuration object which
    will call the .configure() method to establish the connection to the db based on the
    credentials we supplied in the file
     */

    private static SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

/*
The getSession() method is called in the DAO layer.
This obtains a JDBC connection which can be used to perform a transaction on our db
 */

    public static Session getSession(){  //similar to getConnection

        if(ses == null){
            ses = sf.openSession();
        }
        return ses;
    }


    public static void closeSession(){

        // when we close a session we free up that connection to return to the
        //cnnection pool. that way it is available to be used by another thread
        ses.close();
    }










}
