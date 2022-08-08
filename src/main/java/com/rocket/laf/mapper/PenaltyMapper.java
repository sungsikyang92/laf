package com.rocket.laf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.rocket.laf.dto.PenaltyDto;

@Mapper
public interface PenaltyMapper {
    
    @Select( "select * from Penalty where pUserId=#{userId}" )
    List<PenaltyDto> getCurPenalty(String userId);

    @Delete( "delete from Penalty where pUserId=#{userId}")
    void deletePenalty(String userId);

    @Insert({"<script>" +
            "INSERT INTO Penalty " +
            "(pUserId, pBoardNo, penaltyCnt) VALUES" +
            "<foreach collection='list' item='item' separator=','>" +
            "(" +
            "#{item.pUserId}," +
            "#{item.pBoardNo}," +
            "#{item.penaltyCnt}" +
            ")" +
            "</foreach> " +
            "</script>"})
    void updatePenalty(List<PenaltyDto> list) throws Exception;
}
