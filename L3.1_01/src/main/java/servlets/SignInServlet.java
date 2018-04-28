/*
 * Copyright 2018 by Solvo, LTD
 * This program is commercial software.
 * Any unauthorized use is prohibited.
 *
 * Created 10-04-2018
 */
package servlets;

import accounts.AccountService;
import dbService.DBException;
import dbService.dataSets.UserProfile;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vsasaeva
 */
public class SignInServlet extends HttpServlet
{
    private final AccountService accountService;

    public SignInServlet(AccountService accountService)
    {
        this.accountService = accountService;
    }

    //sign in
    public void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException
    {
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        if(login == null || pass == null)
        {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        UserProfile profile=null;
        try
        {
            profile = accountService.getUserByLogin(login);
        }
        catch(DBException ex)
        {
            Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        if(profile == null)
        {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("Unauthorized");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }

        else
        {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("Authorized: " + login);
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }

}
