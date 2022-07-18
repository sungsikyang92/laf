package com.rocket.laf.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.rocket.laf.dto.UserDto;

@Mapper
public interface UserMapper {

    @Select( "select * from User where userId=#{userId} and userPw=#{userPw}" )
    UserDto login(UserDto userDto);

    @Insert( "insert into User values ( null, #{userName}, #{userId}, #{userEmail}, #{userPw}, #{userPhone}, #{userSex}, #{userAcc}, #{userLocation}, #{userTicket}, #{userKeyword}, null )")
    int register(UserDto dto);
    //리턴타입 매퍼함수이름(매개변수타입 사용할매개변수명)



    @Select(" SELECT * FROM User WHERE userNo = #{userNo} ")
    UserDto getUserById(long userNo);
}
