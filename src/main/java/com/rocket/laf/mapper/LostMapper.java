package com.rocket.laf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.rocket.laf.dto.LostDto;
import com.rocket.laf.dto.PictureDto;

@Mapper
public interface LostMapper {

  // Picture AS p ON l.lBoardNo = p.boardNo
    @Select("SELECT l.lBoardNo,p.storedFilePath,l.lTitle FROM Lost AS l INNER JOIN Picture AS p ON l.lBoardNo = p.boardNo GROUP BY p.boardNo")
    List<LostDto> getLostBoardList();

    @Select("SELECT * FROM Lost WHERE lBoardNo = #{lBoardNo}")
    LostDto getLostBoardOne(String lBoardNo);

    @Insert("INSERT INTO Lost (lBoardNo ,lTitle, lContent, lCreateDate, lLocation, lCategory, lQuestion, lAnswers, lAnswers1,lAnswers2,lAnswers3,lAnswers4, userNo, hashNo) "
            + "VALUES (#{lBoardNo}, #{lTitle}, #{lContent},  now(), #{lLocation}, #{lCategory},#{lQuestion} ,#{lAnswers} ,#{lAnswers1} ,#{lAnswers2} ,#{lAnswers3} ,#{lAnswers4} , #{userNo}, 1) ")
    int insertLostBoard(LostDto LostDto);

    @Insert({"<script>" +
            "INSERT INTO Picture " +
            "(boardNo,originalFileName, storedFilePath, fileSize, createdDate, picExt) VALUES" +
            "<foreach collection='list' item='item' separator=','>" +
            "(" +
            "#{item.boardNo}," +
            "#{item.originalFileName}," +
            "#{item.storedFilePath}," +
            "#{item.fileSize}," +
            "NOW()," +
            "1" +
            ")" +
            "</foreach> " +
            "</script>"})
    void writelBoardFileList(List<PictureDto> list) throws Exception;

    @Update(" UPDATE Lost " +
            "SET lTitle=#{lTitle}, lContent=#{lContent}, lIsModified = 1, lLocation=#{lLocation}, lCategory=#{lCategory},lQuestion=#{lQuestion}, lAnswers=#{lAnswers}, lAnswers1=#{lAnswers1},lAnswers2=#{lAnswers2},lAnswers3=#{lAnswers3},lAnswers4=#{lAnswers4}" +
            "WHERE lBoardNo = #{lBoardNo}")
    void updatelBoardDetail(LostDto lostDto);

}
