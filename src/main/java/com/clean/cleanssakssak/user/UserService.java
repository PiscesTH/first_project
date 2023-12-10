package com.clean.cleanssakssak.user;

import com.clean.cleanssakssak.common.Const;
import com.clean.cleanssakssak.common.ResVo;
import com.clean.cleanssakssak.user.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;

    public ResVo postSignup(UserInsDto dto) {
        UserLoginProcDto checkUid = mapper.selUserLoginInfo(dto.getUid());
        if (checkUid != null) {
            return new ResVo(Const.UID_DUPLICATED);
        }
        Integer checkDuplication = mapper.selUserByNickName(dto);
        if (checkDuplication != null) {
            return new ResVo(Const.NICK_NAME_DUPLICATED);
        }
        String hashedUpw = BCrypt.hashpw(dto.getUpw(), BCrypt.gensalt());
        dto.setUpw(hashedUpw);
        int insResult = mapper.insUser(dto);
        return new ResVo(dto.getUserId());
    }

    public UserLoginVo postSignin(UserLoginDto dto) {
        UserLoginProcDto pDto = mapper.selUserLoginInfo(dto.getUid());
        UserLoginVo resultVo = UserLoginVo.builder()
                .result(Const.UPW_INCORRECT)
                .build();
        if (pDto == null) {
            resultVo.setResult(Const.UID_NOT_EXIST);
            return resultVo;
        }
        if (BCrypt.checkpw(dto.getUpw(), pDto.getUpw())) {
            return UserLoginVo.builder()
                    .userId(pDto.getUserId())
                    .nickName(pDto.getNickName())
                    .result(Const.LOGIN_SUCCESS)
                    .build();
        }
        return resultVo;
    }

    public ResVo patchProfile(UserUbdDto dto){
        return null;
    }

}
