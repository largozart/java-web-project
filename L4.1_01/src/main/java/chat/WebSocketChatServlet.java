/*
 * Copyright 2018 by Solvo, LTD
 * This program is commercial software.
 * Any unauthorized use is prohibited.
 *
 * Created 20-06-2018
 */
package chat;

import javax.servlet.annotation.WebServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

/**
 *
 * @author vsasaeva
 */
@WebServlet(name = "WebSocketChatServlet", urlPatterns =
{
    "/chat"
})
public class WebSocketChatServlet extends WebSocketServlet
{
    private final static int LOGOUT_TIME = 10 * 60 * 1000;
    private final ChatService chatService;

    public WebSocketChatServlet()
    {
        this.chatService = new ChatService();
    }

    @Override
    public void configure(WebSocketServletFactory factory)
    {
       factory.getPolicy().setIdleTimeout(LOGOUT_TIME);
       factory.setCreator((req, resp) -> new ChatWebSocket(chatService));
    }
}
