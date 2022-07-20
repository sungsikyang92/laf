package com.rocket.laf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.rocket.laf.dto.PictureDto;

@Mapper
public interface PictureMapper {


    @Select(" SELECT * FROM Picture WHERE boardNo = #{boardNo} ")
    List<PictureDto> getAllPictureByBoardNo(String boardNo);

    @Select("SELECT * FROM Picture WHERE picNo = (SELECT MIN(picNo) FROM Picture WHERE boardNo = #{boardNo})")
    List<PictureDto> getMainPictureByBoardNo(String boardNo);
}
