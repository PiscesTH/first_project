package com.clean.cleanssakssak.user;

import com.clean.cleanssakssak.user.model.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insUser(UserInsDto dto);
    Integer selUserByNickname(String nickname);
    UserLoginProcDto selUserLoginInfo(String uid);
    int updUserUpw(UserUbdDto dto);
    int updUserNickname(UserUbdDto dto);
    int delUser(int loginedUserId);
}