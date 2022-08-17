package com.rocket.laf.service;

import com.rocket.laf.dto.MessageRoom;

import java.util.List;

public interface ChatService {
    List<MessageRoom> getAllChatRoom(String username);

    MessageRoom createChatRoom(String username, Long boardNo);

    Long getRoomIdByuserNo(Long userNo);
}
