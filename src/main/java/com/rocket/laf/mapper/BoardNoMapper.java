package com.rocket.laf.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BoardNoMapper {

    @Select(" SELECT MAX(cBoardNO) FROM BoardNo ")
    long getMaxBoardNo();

    @Insert(" INSERT INTO BoardNo (cBoardNo) VALUES (#{cBoardNo}) ")
    long addBoardNo(long cBoardNo);

    @Select(" SELECT MAX(lBoardNo) FROM BoardNo")
    long getMaxlBoardNo();

    @Insert("INSERT INTO BoardNo (lBoardNo) VALUES (#{lBoardNo})")
    long addlBoardNo(long lBoardNo);
}