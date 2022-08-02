// package com.rocket.laf.controller;

// import com.rocket.laf.dto.ChatRoom;
// import com.rocket.laf.repository.ChatRoomRepository;
// import lombok.RequiredArgsConstructor;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RequiredArgsConstructor
// @Controller
// @RequestMapping("/chat")
// public class ChatRoomController {

//     private final ChatRoomRepository chatRoomRepository;

//     // 채팅 리스트 화면
//     @GetMapping("")
//     public String room(Model model) {
//         List<ChatRoom> chatRoomList = chatRoomRepository.findAllRoom();
//         model.addAttribute("chatRoomList", chatRoomList);
//         return "/chat/roomList";
//     }

//     // 모든 채티방 목록
//     @GetMapping("/rooms")
//     public List<ChatRoom> rooms() {
//         return chatRoomRepository.findAllRoom();
//     }

//     // 채팅방 생성
//     @PostMapping("/room")
//     @ResponseBody
//     public ChatRoom createRoom(@RequestParam String name) {
//         return chatRoomRepository.createChatRoom(name);
//     }

//     // 채팅방 입장 화면
//     @GetMapping("/room/enter/{roomId}")
//     public String roomDetail(Model model, @PathVariable String roomId) {
//         model.addAttribute("roomId", roomId);
//         return "/chat/roomdetail";
//     }

//     // 특정 채팅방 조회
//     @GetMapping("/room/{roomId}")
//     @ResponseBody
//     public ChatRoom roomInfo(@PathVariable String roomId) {
//         return chatRoomRepository.findRoomById(roomId);
//     }
// }
