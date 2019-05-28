package com.largo.spring.service;



import com.largo.spring.domain.Order;

import java.util.List;

public interface OrderService {

    void save(Order order);

    void delete(Order order);

    List<Order> getAll();

    Order getById(Integer id);
}
