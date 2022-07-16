package com.rocket.laf.mapper;

import com.rocket.laf.dto.ComPicTestDto;
import com.rocket.laf.dto.CommunityDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommunityMapper {

    @Select(" SELECT * FROM Community c " +
            "INNER JOIN Picture p  ON c.picNo = p.picNo " +
            "INNER JOIN HashTag ht ON c.hashNo = ht.hashNo " +
            "ORDER BY cBoardNo DESC")
    List<CommunityDto> getComBoardList();

    @Insert(" INSERT INTO Community " +
            "(cTitle, cContent, cCreateDate, cLocation, cCategory, userNo, hashNo, picNo) " +
            "VALUES (#{cTitle},#{cContent},now(),#{cLocation},#{cCategory},1,1,1) ")
    @Options(useGeneratedKeys = true, keyProperty = "cBoardNo")
    void writeComBoard(CommunityDto communityDto);

    @Select(" SELECT * FROM Community " +
            "WHERE cBoardNo = #{cBoardNo}")
    CommunityDto getComBoardDetail(long cBoardNo);

    @Update(" UPDATE Community " +
            "SET cTitle=#{cTitle}, cContent=#{cContent}, cIsModified=#{cIsModified} " +
            "WHERE cBoardNo = #{cBoardNo} ")
    int updateComBoardDetail(CommunityDto communityDto);

    @Delete(" DELETE FROM Community " +
            "WHERE cBoardNo = ${cBoardNo}")
    int deleteComBoardDetail(long cBoardNo);

    @Select(" SELECT MAX(cBoardNo) FROM Community ")
    long getLastCBoardNo();

    @Insert({"<script>" +
            "INSERT INTO PicFile " +
            "(cBoardNo,originalFileName, storedFilePath, fileSize, userName, cCreateDate) VALUES" +
            "<foreach collection='list' item='item' separator=','>" +
            "(" +
            "#{item.cBoardNo}," +
            "#{item.originalFileName}," +
            "#{item.storedFilePath}," +
            "#{item.fileSize}," +
            "'test'," +
            "NOW()" +
            ")" +
            "</foreach> " +
            "</script>"})
    void writeComBoardFileList(List<ComPicTestDto> list) throws Exception;
}
