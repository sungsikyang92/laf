package com.rocket.laf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.rocket.laf.dto.PictureDto;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface PictureMapper {

    @Select(" SELECT * FROM Picture WHERE boardNo = #{boardNo} and isDeleted = 0 ")
    List<PictureDto> getAllPictureByBoardNo(String boardNo);

    @Select(" SELECT * FROM Picture " +
            "WHERE boardNo = #{boardNo} " +
            "GROUP BY boardNo " +
            "ORDER BY picNo DESC ")
    PictureDto getMainPictureByBoardNo(String boardNo);

    @Update(" UPDATE Picture Set isDeleted = 1 WHERE picNo = #{picNo} ")
    void deleteSelectedPic(long picNo);
}
