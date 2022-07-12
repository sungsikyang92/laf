package com.rocket.laf.mapper;

import com.rocket.laf.dto.CommunityDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommunityMapper {

    @Select(" SELECT * FROM Community ")
    List<CommunityDto> getComBoardList();
}
