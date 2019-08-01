package com.largo.spring.service;


import com.largo.spring.config.HibernateUtil;
import com.largo.spring.domain.Orders;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author vsasaeva
 */
public class OrderServiceImpl implements OrderService {


    public void save(Orders order) {
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(order);
            tx.commit();
        }
        catch (HibernateException e){
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public void delete(Orders order) {
        Transaction tx = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.delete(order);
            tx.commit();
        }
        catch (HibernateException e){
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Orders> getAll() {
        Transaction tx = null;
        List result = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            result = session.createQuery("from Orders").list();
            for (Orders order : (List<Orders>) result) {
                System.out.println(order.getTitle());
            }
            tx.commit();
        }
        catch (HibernateException e){
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return result;
    }

    public Orders getById(Integer id) {
        Transaction tx = null;
        List result = null;
        Orders order = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            order =  session.get(Orders.class, id);
                    tx.commit();
        }
        catch (HibernateException e){
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return order;
    }
}
