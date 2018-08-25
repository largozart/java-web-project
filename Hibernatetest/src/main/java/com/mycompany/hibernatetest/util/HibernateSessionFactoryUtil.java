/*
 * Copyright 2018 by Solvo, LTD
 * This program is commercial software.
 * Any unauthorized use is prohibited.
 *
 * Created 20-07-2018
 */
package com.mycompany.hibernatetest.util;

import org.hibernate.SessionFactory;

/**
 *
 * @author vsasaeva
 */
public class HibernateSessionFactoryUtil
{
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private HibernateSessionFactoryUtil()
    {
    }

    private static SessionFactory buildSessionFactory()
    {
        try
        {
            // Create the SessionFactory from hibernate.cfg.xml
            return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
        }
        catch(Throwable ex)
        {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

    public static void shutdown()
    {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}
