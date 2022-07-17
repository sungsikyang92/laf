package com.rocket.laf.mapper;

import com.rocket.laf.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select(" SELECT * FROM User WHERE userNo = #{userNo} ")
    UserDto getUserById(long userNo);
}
