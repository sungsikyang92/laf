package com.rocket.laf.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BoardNoMapper {

    @Select(" SELECT MAX(cBoardNO) FROM BoardNo ")
    long getMaxBoardNo();

    @Insert(" ")
    long addBoardNo(long numbering);
}