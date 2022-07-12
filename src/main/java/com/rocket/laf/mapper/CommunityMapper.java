package com.rocket.laf.mapper;

import com.rocket.laf.dto.CommunityDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommunityMapper {

    @Select(" SELECT cBoardNo,cTitle,cContent,cCreateDate,cIsModified,cLocation,cCategory,userNo,hashNo,picNo FROM Community ")
    List<CommunityDto> getComBoardList();
}
