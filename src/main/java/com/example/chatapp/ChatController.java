package com.example.chatapp;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/sendMessage/{room}")
    @SendTo("/topic/{room}")
    public Message sendMessage(@DestinationVariable String room, Message message) {
        message.setRoom(room);
        return message;
    }
}
