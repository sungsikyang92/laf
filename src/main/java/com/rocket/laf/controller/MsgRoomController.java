package com.rocket.laf.controller;

import com.rocket.laf.dto.MessageRoom;
import com.rocket.laf.service.impl.ChatServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comm")
public class MsgRoomController {

    private final ChatServiceImpl chatService;

    @GetMapping("/room/enter/{roomId}")
    public String roomEnter(Model model, @PathVariable String roomId) {
        model.addAttribute("roomId", roomId);
        return "/chat/chatDetail";
    }

    @GetMapping("/room/{roomId}")
    public MessageRoom roomInfo(@PathVariable String roomId) {
        long roomId_to_long = Long.parseLong(roomId);
        return chatService.getRoomByRoomId(roomId_to_long);
    }
}
