package com.rocket.laf.mapper;

import com.rocket.laf.dto.CommunityDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommunityMapper {

    @Select(" SELECT * FROM Community ")
    List<CommunityDto> getComBoardList();

    @Insert(" INSERT INTO Community (cTitle, cContent, cCreateDate, cLocation, cCategory, userNo, hashNo, picNo) VALUES (#{cTitle},#{cContent},now(),#{cLocation},#{cCategory},#{userNo},#{hashNo},#{picNo}) ")
    int insertComBoard(CommunityDto communityDto);
}
