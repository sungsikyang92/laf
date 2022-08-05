package com.rocket.laf.mapper;

import com.rocket.laf.dto.MainListDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SearchMapper {

    @Select(" SELECT * FROM Lost l INNER JOIN Picture p WHERE l.lBoardNo = p.boardNo AND (lTitle LIKE '%test%' OR lContent LIKE '%test%') GROUP BY l.lBoardNo ORDER BY l.lBoardNo DESC ")
    List<MainListDto> getSearchResult(String searchArg);
}
