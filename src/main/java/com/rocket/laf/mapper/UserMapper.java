package com.rocket.laf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.rocket.laf.dto.UserDto;

@Mapper
public interface UserMapper {

    @Select(" SELECT * FROM USER")
    List<UserDto> selectlist();
}
