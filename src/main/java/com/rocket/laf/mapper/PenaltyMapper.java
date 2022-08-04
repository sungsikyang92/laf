package com.rocket.laf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.rocket.laf.dto.PenaltyDto;

@Mapper
public interface PenaltyMapper {
    
    @Select( "select * from Penalty where pUserId=#{userId}" )
    List<PenaltyDto> getCurPenalty(String userId);
}
