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

    @Insert(" INSERT INTO Message (boardNo, userNo) VALUES (#{boardNo}, #{userNo}) ")
    void createChatRoom(String boardNo, long userNo);

    @Select(" SELECT roomId FROM Message WHERE userNo=#{userNo} and boardNo=#{boardNo} ")
    long getRoomIdByuserNo(long userNo, String boardNo);

    @Select(" SELECT COUNT(*) FROM (SELECT * FROM Message WHERE boardNo=#{boardNo} and userNo=#{userNo}) CHAT_EXIST ")
    int chkChatRoomExist(String boardNo, long userNo);

    @Select(" SELECT * FROM Message ")
    List<MessageRoom> getAllChatRoomByUser();

    @Select(" SELECT * FROM Message m INNER JOIN User u WHERE u.userNo = m.userNo and u.userName= #{userName} ")
    List<MessageRoom> getAllChatRoomByUserName(String userName);

    @Select(" SELECT roomId FROM Message WHERE roomId = #{roomId} ")
    MessageRoom getRoomByRoomId(long roomId);
}
