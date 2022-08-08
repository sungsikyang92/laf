package com.rocket.laf.controller;

import com.rocket.laf.dto.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @MessageMapping("/hello")
    @SendTo("/topic/roomId")
    public Message sendMessage(Message message) {
        return message;
    }
}
