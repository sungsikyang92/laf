package com.rocket.laf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.rocket.laf.dto.LostDto;
import com.rocket.laf.dto.PictureDto;

@Mapper
public interface LostMapper {

  // Picture AS p ON l.lBoardNo = p.boardNo
//    @Select("SELECT l.lBoardNo,p.storedFilePath,l.lTitle FROM Lost AS l INNER JOIN Picture AS p ON l.lBoardNo = p.boardNo GROUP BY p.boardNo ORDER BY l.lBoardNo DESC")
    @Select(" SELECT * FROM Lost ORDER BY boardNo DESC ")
    List<LostDto> getLostBoardList();

    @Select(" SELECT * FROM Lost WHERE category = '분실' ORDER BY boardNo DESC ")
    List<LostDto> getLostBoardLostList();

    @Select(" SELECT * FROM Lost WHERE category = '습득' ORDER BY boardNo DESC ")
    List<LostDto> getLostBoardFindList();

    @Select("SELECT * FROM Lost WHERE boardNo = #{boardNo}")
    LostDto getLostBoardOne(String boardNo);

    @Insert("INSERT INTO Lost (boardNo ,title, content, createDate, location, category, question, answers, answers1,answers2,answers3,answers4, userNo, hashNo) "
            + "VALUES (#{boardNo}, #{title}, #{content},  now(), #{location}, #{category},#{question} ,#{answers} ,#{answers1} ,#{answers2} ,#{answers3} ,#{answers4} , #{userNo}, 1) ")
    int insertLostBoard(LostDto LostDto);

    @Insert({"<script>" +
            "INSERT INTO Picture " +
            "(boardNo,originalFileName, storedFilePath, fileSize, createdDate, picExt) VALUES" +
            "<foreach collection='list' item='item' separator=','>" +
            "(" +
            "#{item.boardNo}," +
            "#{item.originalFileName}," +
            "#{item.storedFilePath}," +
            "#{item.fileSize}," +
            "NOW()," +
            "1" +
            ")" +
            "</foreach> " +
            "</script>"})
    void writelBoardFileList(List<PictureDto> list) throws Exception;

    @Update(" UPDATE Lost " +
            "SET title=#{title}, content=#{content}, modified = 1, location=#{location}, category=#{category},question=#{question}, answers=#{answers}, answers1=#{answers1},answers2=#{answers2},answers3=#{answers3},answers4=#{answers4}" +
            "WHERE boardNo = #{boardNo}")
    void updatelBoardDetail(LostDto lostDto);

    @Select(" SELECT title FROM Lost WHERE boardNo = #{boardNo} ")
    String getLostBoardTitle(String boardNo);
}
