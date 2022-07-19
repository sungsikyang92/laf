package com.rocket.laf.mapper;

import com.rocket.laf.dto.CommunityDto;
import com.rocket.laf.dto.PictureDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommunityMapper {

    @Select("SELECT c.cBoardNo, c.cTitle, c.cContent, c.cCreateDate, c.cIsModified, c.cLocation, c.cCategory, c.userNo FROM Community c ORDER BY c.cBoardNo DESC")
    List<CommunityDto> getComBoardList();

    @Insert(" INSERT INTO Community " +
            "(cBoardNo, cTitle, cContent, cCreateDate, cLocation, cCategory, userNo, hashNo) " +
            "VALUES (CONCAT('com', LPAD((SELECT MAX(cBoardNo) FROM BoardNo),8,'0')),#{cTitle},#{cContent},now(),#{cLocation},#{cCategory},1,1) ")
    @Options(keyProperty = "cBoardNo")
    void writeComBoard(CommunityDto communityDto);

    @Select(" SELECT * FROM Community " +
            "WHERE cBoardNo = #{cBoardNo}")
    CommunityDto getComBoardDetail(String cBoardNo);

    @Update(" UPDATE Community " +
            "SET cTitle=#{cTitle}, cContent=#{cContent}, cIsModified=#{cIsModified} " +
            "WHERE cBoardNo = #{cBoardNo} ")
    int updateComBoardDetail(CommunityDto communityDto);

    @Delete(" DELETE FROM Community " +
            "WHERE cBoardNo = #{cBoardNo}")
    int deleteComBoardDetail(String cBoardNo);

    @Select(" SELECT MAX(cBoardNo) FROM Community ")
    String getLastCBoardNo();

    @Insert({"<script>" +
            "INSERT INTO Picture " +
            "(boardNo,originalFileName, storedFilePath, fileSize, createdDate) VALUES" +
            "<foreach collection='list' item='item' separator=','>" +
            "(" +
            "#{item.boardNo}," +
            "#{item.originalFileName}," +
            "#{item.storedFilePath}," +
            "#{item.fileSize}," +
            "NOW()" +
            ")" +
            "</foreach> " +
            "</script>"})
    void writeComBoardFileList(List<PictureDto> list) throws Exception;

}


