/*
 * Copyright 2018 by Solvo, LTD
 * This program is commercial software.
 * Any unauthorized use is prohibited.
 *
 * Created 20-07-2018
 */
package com.mycompany.hibernatetest.main;

import com.mycompany.hibernatetest.Users;
import com.mycompany.hibernatetest.dao.UsersService;

/**
 *
 * @author vsasaeva
 */
public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Maven + Hibernate + Oracle");

        UsersService service = new UsersService();

        Users user = new Users();

        user.setId(1);
        user.setName("wonderwoman");

        service.saveUser(user);
    }
}
