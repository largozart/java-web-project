/*
 * Copyright 2018 by Solvo, LTD
 * This program is commercial software.
 * Any unauthorized use is prohibited.
 *
 * Created 20-07-2018
 */
package com.mycompany.hibernatetest.dao;

import com.mycompany.hibernatetest.Users;
import com.mycompany.hibernatetest.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author vsasaeva
 */
public class UsersDAOImpl implements UsersDAO
{
    @Override
    public void save(Users user)
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

}
