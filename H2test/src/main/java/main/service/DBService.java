/*
 * Copyright 2018 by Solvo, LTD
 * This program is commercial software.
 * Any unauthorized use is prohibited.
 *
 * Created 25-04-2018
 */
package main.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.h2.jdbcx.JdbcDataSource;

/**
 *
 * @author vsasaeva
 */
public class DBService
{
    String url = "jdbc:h2:./h2db";
    String name = "tully";
    String pass = "tully";

    public Connection getConnection() throws SQLException
    {

        JdbcDataSource ds = new JdbcDataSource();
        ds.setURL(url);
        ds.setUser(name);
        ds.setPassword(pass);

        Connection connection = DriverManager.getConnection(url, name, pass);

        return connection;
    }
}
