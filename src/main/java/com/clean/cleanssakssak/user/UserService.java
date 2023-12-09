package com.clean.cleanssakssak.user;

import com.clean.cleanssakssak.common.Const;
import com.clean.cleanssakssak.common.ResVo;
import com.clean.cleanssakssak.user.model.UserInsDto;
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
        Integer checkDuplication = mapper.selUserByUid(dto);
        if (checkDuplication != null){
            return new ResVo(Const.UID_DUPLICATED);
        }
        checkDuplication = mapper.selUserByNickName(dto);
        if (checkDuplication != null){
            return new ResVo(Const.NICK_NAME_DUPLICATED);
        }
        String hashedUpw = BCrypt.hashpw(dto.getUpw(),BCrypt.gensalt());
        dto.setUpw(hashedUpw);
        int insResult = mapper.insUser(dto);
        return new ResVo(dto.getUserId());
    }
}
