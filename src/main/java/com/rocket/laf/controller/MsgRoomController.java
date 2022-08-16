package com.rocket.laf.controller;

import com.rocket.laf.dto.LostDto;
import com.rocket.laf.dto.MessageRoom;
import com.rocket.laf.service.impl.ChatServiceImpl;
import com.rocket.laf.service.impl.LostServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comm")
public class MsgRoomController {

    private final ChatServiceImpl chatService;
    private final LostServiceImpl lostService;

    @GetMapping("/room/enter/{roomId}")
    public String roomEnter(Model model, @PathVariable String roomId) {
        model.addAttribute("roomId", roomId);
        return "/chat/chatDetail";
    }

    @ResponseBody
    @GetMapping("/room/{roomId}")
    public MessageRoom roomInfo(@PathVariable String roomId) {
        long roomId_to_long = Long.parseLong(roomId);
        MessageRoom msg = chatService.getRoomByRoomId(roomId_to_long);
        System.out.println(msg.getRoomId());
        System.out.println(msg.getUserNo());
        return msg;
    }

    @GetMapping("/chat/rooms/{userNo}")
    public String getAllChatRoomByUser(@PathVariable long userNo, Model model, Authentication authentication) {
        List<MessageRoom> messageRooms = chatService.getAllChatRoomByUser(userNo);
        for (MessageRoom messageRoom : messageRooms) {
            String title = lostService.getLostBoardTitle(messageRoom.getBoardNo());
            messageRoom.setTitle(title);
        }
        model.addAttribute("roomList", messageRooms);
        return "/chat/roomList";
    }
//    @ResponseBody
//    @GetMapping("/rooms")
//    public String getAllChatRoomByUser(Model model) {
//        System.out.println(userNo+"시작");
//        long userNo_long = Long.parseLong(userNo);
//        System.out.println(userNo_long+"후");
//        List<MessageRoom> messageRooms = chatServiceImpl.getAllChatRoomByUser();
//        System.out.println(messageRooms+"chk");
//        model.addAttribute("roomList", messageRooms);
//        return "/chat/roomList";
//    }
//    @GetMapping("/chat/rooms")
//    public List<MessageRoom> getAllChatRoomByUser(Model model, Authentication authentication) {
//        String username = authentication.getName();
//        UserDto userDto = userServiceImpl.getUserInfoById(username);
//        List<MessageRoom> messageRooms = chatServiceImpl.getAllChatRoomByUser(userDto.getUserNo());
//        model.addAttribute("roomList", messageRooms);
//        return messageRooms;
//    }
}
