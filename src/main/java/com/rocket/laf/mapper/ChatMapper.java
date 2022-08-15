package com.rocket.laf.mapper;

import com.rocket.laf.dto.MessageRoom;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ChatMapper {

    @Select(" SELECT roomId FROM Message WHERE username= #{username} ")
    List<MessageRoom> getAllChatRoom(String username);

    @Insert(" INSERT INTO Message (boardNo, userNo) VALUES (boardNo=#{boardNo}, userNo=#{userNo}) ")
    MessageRoom createChatRoom(String boardNo, Long userNo);

    @Select(" SELECT roomId FROM Message WHERE userNo")
    long getRoomIdByuserNo(Long userNo);
}
