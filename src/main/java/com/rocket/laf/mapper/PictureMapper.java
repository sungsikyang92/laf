package com.rocket.laf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.rocket.laf.dto.PictureDto;

@Mapper
public interface PictureMapper {

    @Select("SELECT * FROM Picture")
    List<PictureDto> getAllPictuer();

    @Select("SELECT mainPicLoc FROM Picture When picNo = #{picNo}")
    String getMainPicLoc(long picNo);

}
