package com.rocket.laf.mapper;

import com.rocket.laf.dto.MainListDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SearchMapper {

//    @Select(" SELECT * FROM Lost l INNER JOIN Picture p WHERE l.boardNo = p.boardNo AND (l.title LIKE CONCAT('%',#{searchArg},'%')) GROUP BY l.boardNo ORDER BY l.boardNo DESC ")
    @Select(" SELECT * FROM Lost l INNER JOIN Picture p WHERE l.boardNo = p.boardNo AND (l.title LIKE '%${searchArg}%') GROUP BY l.boardNo ORDER BY l.boardNo DESC ")
    List<MainListDto> getSearchResult(String searchArg);
}
