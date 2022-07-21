package com.rocket.laf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.rocket.laf.dto.LostDto;

@Mapper
public interface LostMapper {

    // Picture AS p ON l.lBoardNo = p.boardNo
    @Select("SELECT l.lBoardNo,p.storedFilePath,l.lTitle,p.picNo  FROM Lost AS l INNER JOIN Picture AS p ON l.lBoardNo = p.boardNo GROUP BY p.boardNo")
    List<LostDto> getLostBoardList();

    @Select("SELECT * FROM Lost WHERE lBoardNo = #{lBoardNo}")
    List<LostDto> getLostBoardOne(String lBoardNo);

    @Insert(" INSERT INTO Lost(lTitle, lContent, lCreateDate, lLocation, lCategory, lQuestion, lAnswers, userNo, hashNo, picNo)VALUES(#{lTitle}, #{lContent}, #{lCreateDate}, #{lLocation}, #{lCategory}, #{lQuestion}, #{lAnswers},#{userNo},#{hashNo},#{picNo})")
    int insertLostBoard(LostDto LostDto);

}
