/*
 * Copyright 2018 by Solvo, LTD
 * This program is commercial software.
 * Any unauthorized use is prohibited.
 *
 * Created 25-04-2018
 */
package main.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author vsasaeva
 */
public class Executor
{
    Connection connection;

    public Executor(Connection connection)
    {
        this.connection = connection;
    }

    public void execUpdate(String query) throws SQLException
    {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(query);
        stmt.close();
    }

    public  ResultSet execQuery(String query) throws SQLException
    {
        Statement stmt = connection.createStatement();
        stmt.execute(query);
        ResultSet rs = stmt.getResultSet();
        return rs;
    }
}
