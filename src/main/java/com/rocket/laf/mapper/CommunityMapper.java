package com.rocket.laf.mapper;

import com.rocket.laf.dto.CommunityDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommunityMapper {

    @Select(" SELECT * FROM Community c INNER JOIN Picture p  ON c.picNo = p.picNo INNER JOIN HashTag ht ON c.hashNo = ht.hashNo ")
    List<CommunityDto> getComBoardList();

    @Insert(" INSERT INTO Community (cTitle, cContent, cCreateDate, cLocation, cCategory, userNo, hashNo, picNo) VALUES (#{cTitle},#{cContent},now(),#{cLocation},#{cCategory},#{userNo},#{hashNo},#{picNo}) ")
    int insertComBoard(CommunityDto communityDto);

    @Select(" SELECT * FROM Community WHERE cBoardNo = #{cBoardNo}")
    CommunityDto getComBoardDetail(long cBoardNo);

    @Update(" UPDATE Community SET cTitle=#{cTitle}, cContent=#{cContent}, cIsModified=#{cIsModified} WHERE cBoardNo = #{cBoardNo} ")
    int updateComBoardDetail(CommunityDto communityDto);

    @Delete(" DELETE FROM Community WHERE cBoardNo = ${cBoardNo}")
    int deleteComBoardDetail(long cBoardNo);
}
