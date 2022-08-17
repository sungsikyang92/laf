package com.rocket.laf.controller;

import com.rocket.laf.dto.Message;
import com.rocket.laf.dto.MessageRoom;

import com.rocket.laf.service.impl.ChatServiceImpl;
import com.rocket.laf.service.impl.LostServiceImpl;
import com.rocket.laf.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Slf4j
//@RestController
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MsgController {


    private static ChatServiceImpl chatServiceImpl;
    private static UserServiceImpl userServiceImpl;
    private static LostServiceImpl lostServiceImpl;
    private final SimpMessageSendingOperations sendingOperations;

    @MessageMapping("/comm/message")
    public void sendMessage(Message message, MessageRoom messageRoom) {
//        return message;
        sendingOperations.convertAndSend("/sub/comm/room/" + messageRoom.getRoomId(), message);
    }

//    @RequestMapping("/chat/rooms")
//    public List<MessageRoom> getAllChatRoom(@RequestParam String username) {
//        return chatServiceImpl.getAllChatRoom(username);
//    }
//
//    @PostMapping("")
//    public MessageRoom createChatRoom(@RequestParam String loginUserName, @RequestParam String boardNo) {
//        MessageRoom messageRoom = new MessageRoom();
//        UserDto userInfo = userServiceImpl.getUserInfoById(loginUserName);
//        Long userNo = userServiceImpl.getUserNoById(loginUserName);
//        LostDto boardInfo = lostServiceImpl.getLostBoardOne(boardNo);
//        chatServiceImpl.createChatRoom(boardNo, userNo);
//        System.out.println("test1");
//        long roomId = chatServiceImpl.getRoomIdByuserNo(userNo, boardNo);
//        System.out.println("test2");
//        messageRoom.setRoomId(roomId);
//        messageRoom.setUserNo(userNo);
//        messageRoom.setBoardNo(boardNo);
//        messageRoom.setUserInfo(userInfo);
//        messageRoom.setBoardInfo(boardInfo);
//        System.out.println("test3");
//        List<MessageRoom> messageRooms = chatServiceImpl.getAllChatRoomByUser();
//        System.out.println("test4");
//        System.out.println(messageRooms+"메세지룸");
//        System.out.println("test5");
//        return messageRoom;
//    }

//    @GetMapping("/chat/rooms/{userNo}")
//    public String getAllChatRoomByUser(@PathVariable long userNo, Model model, Authentication authentication) {
//        List<MessageRoom> messageRooms = chatServiceImpl.getAllChatRoomByUser(userNo);
//        model.addAttribute("roomList", messageRooms);
//        return "/chat/roomList";
//    }
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
