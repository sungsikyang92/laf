package com.rocket.laf.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.rocket.laf.dto.MypageDto;
import com.rocket.laf.dto.UserDto;

@Mapper
public interface MypageMapper {

    //회원가입 시 기입한 아이디, 이름, 지역
    @Select ( "SELECT * FROM User WHERE UserId = #{userId} and UserName = #{userName} and UserLocation = #{userLocation} and UserNo = #{userNo}")
    MypageDto userinfo(MypageDto mypageDto);
    
    //회원가입 시 선택한 프로필 사진
    @Select ("SELECT * FROM Picture Where picNo = #{picNo}")
    MypageDto selectOneforPicture(long picNo);

    //프로필 사진 수정
    @Insert( "INSERT INTO Picture(picNo)VALUE = #{picNo}")
    String uploadPic(long picNo);

    //동네설정
    @Insert( "INSERT INTO User(userLocation) VALUE = #{userLocation}")
    UserDto selectOneforLocation(String userLocation);

    @Select(" SELECT * FROM User WHERE UserNo = #{userno}")
    MypageDto selectOne(long userNo);

    @Update(" UPDATE User SET UserID = #{userId}, UserName = #{userName} WHERE UserNo = #{userNo}")
    int update(MypageDto dto);
}
