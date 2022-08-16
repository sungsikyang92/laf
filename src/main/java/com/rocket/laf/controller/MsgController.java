package com.rocket.laf.controller;

import com.rocket.laf.dto.LostDto;
import com.rocket.laf.dto.Message;
import com.rocket.laf.dto.MessageRoom;
import com.rocket.laf.dto.UserDto;
import com.rocket.laf.service.ChatService;
import com.rocket.laf.service.impl.ChatServiceImpl;
import com.rocket.laf.service.impl.LostServiceImpl;
import com.rocket.laf.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
//@RestController
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MsgController {

    private static ChatServiceImpl chatService;
    //private static UserServiceImpl userService;
    private static LostServiceImpl lostService;

    @Autowired
    private UserServiceImpl userService;


    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/{roomId}")
    public Message sendMessage(@RequestParam String roomId, Message message) {
        return message;
    }

    @RequestMapping("/chat/rooms")
    public List<MessageRoom> getAllChatRoom(@RequestParam String username) {
        return chatService.getAllChatRoom(username);
    }

    @PostMapping("/chat")
    //public MessageRoom createChatRoom(@RequestParam("loginUserName") String loginUserName, @RequestParam("boardNo") String boardNo) {
    public MessageRoom createChatRoom(@RequestParam("loginUserName") String loginUserName, @RequestParam("boardNo") String boardNo) {
        log.info("________________________ createChatRoom 실행  " + loginUserName + "   " + boardNo);
        //log.info("________________________ createChatRoom 실행  " );
        MessageRoom messageRoom = new MessageRoom();
        UserDto userInfo = userService.getUserInfoById(loginUserName);
        System.out.println(userInfo);
        Long userNo = userService.getUserNoById(loginUserName);
        LostDto boardInfo = lostService.getLostBoardOne(boardNo);
        MessageRoom msg = chatService.createChatRoom(boardNo, userNo);
        messageRoom.setRoomId(msg.getRoomId());
        messageRoom.setUserNo(userNo);
        messageRoom.setBoardNo(boardNo);
        return messageRoom;
    }
}
