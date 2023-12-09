package com.clean.cleanssakssak.user;

import com.clean.cleanssakssak.user.model.UserInsDto;
import com.clean.cleanssakssak.user.model.UserLoginDto;
import com.clean.cleanssakssak.user.model.UserLoginProcDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insUser(UserInsDto dto);
    Integer selUserByUid(UserInsDto dto);
    Integer selUserByNickName(UserInsDto dto);
    UserLoginProcDto selUserLoginInfo(UserLoginDto dto);
}