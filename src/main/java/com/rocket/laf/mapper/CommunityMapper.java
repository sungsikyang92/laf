package com.rocket.laf.mapper;

import com.rocket.laf.dto.CommunityDto;
import com.rocket.laf.dto.PictureDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommunityMapper {

        @Select(" SELECT * FROM Community ORDER BY boardNo DESC ")
        List<CommunityDto> getComBoardList();

        @Insert(" INSERT INTO Community " +
                        "(boardNo, title, content, createDate, location, category, userNo, hashNo) " +
                        "VALUES (CONCAT('com', LPAD((SELECT MAX(cBoardNo) FROM BoardNo),8,'0')),#{title},#{content},now(),#{location},#{category},#{userNo},1) ")
        @Options(keyProperty = "boardNo")
        void writeComBoard(CommunityDto communityDto);

        @Select(" SELECT * " +
                        "FROM Community " +
                        "WHERE boardNo = #{boardNo} ")
        CommunityDto getComBoardDetail(String boardNo);

        @Update(" UPDATE Community " +
                        "SET title=#{title}, content=#{content}, modified=1 " +
                        "WHERE boardNo = #{boardNo} ")
        void updateComBoardDetail(CommunityDto communityDto);

        @Delete(" DELETE FROM c, p " +
                        "USING Community c " +
                        "INNER JOIN Picture p " +
                        "ON c.boardNo = p.boardNo " +
                        "WHERE p.boardNo = #{boardNo} ")
        int deleteComBoardDetail(String boardNo);

        @Select(" SELECT MAX(boardNo) FROM Community ")
        String getLastBoardNo();

        @Insert({ "<script>" +
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
                        "</script>" })
        void writeComBoardFileList(List<PictureDto> list) throws Exception;

}