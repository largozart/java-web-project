/*
 * Copyright 2018 by Solvo, LTD
 * This program is commercial software.
 * Any unauthorized use is prohibited.
 *
 * Created 20-06-2018
 */
package chat;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author vsasaeva
 */

public class ChatService
{
    private Set<ChatWebSocket> webSockets;

    ChatService()
    {
         this.webSockets = Collections.newSetFromMap(new ConcurrentHashMap<>());
    }

    public void sendMessage(String data){
        for (ChatWebSocket user : webSockets) {
            try {
                user.sendString(data);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void add(ChatWebSocket webSocket){
        webSockets.add(webSocket);
    }

    public void remove(ChatWebSocket webSocket){
        webSockets.remove(webSocket);
    }
}
