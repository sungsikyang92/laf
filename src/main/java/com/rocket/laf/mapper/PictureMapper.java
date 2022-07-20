package com.rocket.laf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.rocket.laf.dto.PictureDto;

@Mapper
public interface PictureMapper {

    @Select("SELECT * FROM Picture WHERE picNo = #{picNo}")
    List<PictureDto> getAllPicture(String picNo);

    @Select("SELECT mainPicLoc FROM Picture WHERE picNo = #{picNo}")
    String getMainPicLoc(long picNo);

    @Select(" SELECT * FROM Picture WHERE boardNo = #{boardNo} ")
    List<PictureDto> getAllPictureByBoardNo(String boardNo);

}
