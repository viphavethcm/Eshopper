package com.nhatduy.core.common.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();
    private static SessionFactory buildSessionFactory(){
        try{
            return new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex){
            System.out.println("ERROR");
            throw new ExceptionInInitializerError();
        }
    }

    public static SessionFactory getSessionFactory(){
        return SESSION_FACTORY;
    }

}
