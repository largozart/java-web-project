/*
 * Copyright 2018 by Solvo, LTD
 * This program is commercial software.
 * Any unauthorized use is prohibited.
 *
 * Created 20-07-2018
 */
package com.mycompany.hibernatetest.dao;

import com.mycompany.hibernatetest.Users;

/**
 *
 * @author vsasaeva
 */
public class UsersService
{
    public UsersDAOImpl dao = new UsersDAOImpl();

    public UsersService()
    {

    }

    public void saveUser(Users user)
    {
        dao.save(user);
    }

    public Users findById(int id) {
      return  dao.findById(id);
    }
}
