/*
 * Copyright 2018 by Solvo, LTD
 * This program is commercial software.
 * Any unauthorized use is prohibited.
 *
 * Created 20-06-2018
 */
package main;
import chat.WebSocketChatServlet;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 *
 * @author vsasaeva
 */
public class Main
{
    public static void main(String[] args) throws Exception
    {
        //Создаем сервер
        Server server = new Server(8088);
        //Указываем параметры, которые свяжут путь строки запроса с созданным выше сервлетом
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new WebSocketChatServlet()), "/chat");

        //указание ресурса
        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setDirectoriesListed(true);
        resource_handler.setResourceBase("public_html");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resource_handler, context});
        server.setHandler(handlers);

        System.out.println("Server started");
        
        server.start();
        server.join();
    }
}
