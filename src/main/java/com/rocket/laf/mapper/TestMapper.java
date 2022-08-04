package com.rocket.laf.mapper;

import com.rocket.laf.dto.TestDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestMapper {

    @Select(" select * from Community c INNER JOIN Picture p WHERE c.boardNo = p.boardNo GROUP BY c.boardNo ORDER BY boardNo DESC ")
    List<TestDto> getTestComBoardList();
}