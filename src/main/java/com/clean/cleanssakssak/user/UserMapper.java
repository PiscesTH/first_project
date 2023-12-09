package com.clean.cleanssakssak.user;

import com.clean.cleanssakssak.user.model.UserInsDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insUser(UserInsDto dto);
    Integer selUserByUid(UserInsDto dto);
    Integer selUserByNickName(UserInsDto dto);
}