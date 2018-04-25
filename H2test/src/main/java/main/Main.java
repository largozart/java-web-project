/*
 * Copyright 2018 by Solvo, LTD
 * This program is commercial software.
 * Any unauthorized use is prohibited.
 *
 * Created 25-04-2018
 */
package main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import main.service.DBService;
import main.service.Executor;

/**
 *
 * @author vsasaeva
 */
public class Main
{
    /*выделение абстракций обслужвание базы, исполнение запросов*/
    public static void main(String[] args)
    {
        try
        {
            DBService db = new DBService();
            Connection connection = db.getConnection();
            Executor executor = new Executor(connection);
            executor.execUpdate("drop table users");
            executor.execUpdate("create table if not exists users (id bigint auto_increment, user_name varchar(256), primary key (id))");
            executor.execUpdate("insert into users (user_name) values ('VALERIA')");
            ResultSet rs = executor.execQuery("select * from users");
            while(rs.next())
            {
                System.out.println(rs.getString("user_name"));

            }
        }
            catch(SQLException e)
        {
            e.printStackTrace();
        }

        }

    }
