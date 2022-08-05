package com.rocket.laf.mapper;

import com.rocket.laf.dto.MainListDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MainListMapper {

    @Select(" select * from Community c INNER JOIN Picture p WHERE c.boardNo = p.boardNo GROUP BY c.boardNo ORDER BY c.boardNo DESC ")
    List<MainListDto> getTestComBoardList();

    @Select(" SELECT * FROM Lost l INNER JOIN Picture p WHERE l.boardNo = p.boardNo AND l.category = #{category} GROUP BY l.boardNo ORDER BY l.boardNo DESC ")
    List<MainListDto> getBoardListByCategory(String category);
}