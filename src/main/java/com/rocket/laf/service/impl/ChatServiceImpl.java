package com.rocket.laf.service.impl;

import com.rocket.laf.dto.MessageRoom;
import com.rocket.laf.mapper.ChatMapper;
import com.rocket.laf.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatMapper chatMapper;

    @Override
    public List<MessageRoom> getAllChatRoom(String username) {
        return chatMapper.getAllChatRoom(username);
    }

    @Transactional
    @Override
    public MessageRoom createChatRoom(String boardNo, Long userNo) {
        return chatMapper.createChatRoom(boardNo, userNo);
    }

    @Override
    public Long getRoomIdByuserNo(Long userNo) {
        return chatMapper.getRoomIdByuserNo(userNo);
    }
}
