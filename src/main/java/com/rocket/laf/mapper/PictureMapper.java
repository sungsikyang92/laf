package com.rocket.laf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.rocket.laf.dto.PictureDto;

@Mapper
public interface PictureMapper {


    @Select(" SELECT * FROM Picture WHERE boardNo = #{boardNo} and picRmd = 0 ORDER BY picNo DESC ")
    List<PictureDto> getAllPictureByBoardNo(String boardNo);

    @Select(" SELECT * FROM Picture AS p Right Outer Join (SELECT MAX(picNo) AS picNos FROM Picture WHERE LOCATE('com', boardNo) GROUP BY boardNo) AS f ON p.picNo = f.picNos ORDER BY picNo DESC ")
    List<PictureDto> getMainPictureForCom();

    
    @Select(" SELECT * FROM Picture WHERE LOCATE('l', boardNo) GROUP BY boardNo ORDER BY picNo DESC ")
    List<PictureDto> getMainPictureForLost();

    @Update(" UPDATE Picture Set picRmd = 1, picExt = 0 WHERE picNo = #{picNo} ")
    void deleteSelectedPic(long picNo);

    @Insert(" INSERT INTO Picture (picNo, boardNo, createdDate) VALUES (null, #{boardNo}, now()) ")
    void insertPicBoardNo(String boardNo);

    @Delete(" DELETE FROM Picture WHERE picNo = #{picNo} ")
    void deleteNullPic(long picNo);
}