package com.rocket.laf.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BoardNoMapper {

    @Select(" SELECT MAX(cBoardNo) FROM BoardNo ")
    long getMaxBoardNo();

    @Insert(" INSERT INTO BoardNo (cBoardNo) VALUES (#{boardNo}) ")
    long addBoardNo(long boardNo);

    @Select(" SELECT MAX(lBoardNo) FROM BoardNo")
    long getMaxlBoardNo();

    @Insert("INSERT INTO BoardNo (lBoardNo) VALUES (#{lBoardNo})")
    long addlBoardNo(long lBoardNo);
    
    @Select(" SELECT boardNo " +
            "FROM Picture " +
            "WHERE picNo = #{picNo} ")
    String getBoardNoByPicNo(long picNo);
}