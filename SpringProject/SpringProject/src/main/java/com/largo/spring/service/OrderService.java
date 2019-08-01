package com.largo.spring.service;

import com.largo.spring.domain.Orders;

import java.util.List;

public interface OrderService {

    void save(Orders order);

    void delete(Orders order);

    List<Orders> getAll();

    Orders getById(Integer id);
}
