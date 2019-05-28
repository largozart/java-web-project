package com.largo.spring.repository;



import com.largo.spring.domain.Order;

import java.util.List;

/**
 * @author vsasaeva
 */
public interface OrderRepository {

    void save(Order order);

    void delete(Order order);

    List<Order> getAll();

    Order getById(Integer id);
}