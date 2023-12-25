package com.clean.cleanssakssak.user;

import com.clean.cleanssakssak.common.Const;
import com.clean.cleanssakssak.common.ResVo;
import com.clean.cleanssakssak.diary.DiaryMapper;
import com.clean.cleanssakssak.todo.TodoMapper;
import com.clean.cleanssakssak.user.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final TodoMapper todoMappermapper;
    private final DiaryMapper diaryMappermapper;

    //유저 회원가입 처리
    public ResVo postSignup(UserInsDto dto) {
//        if (dto.getUid() == null || dto.getUid().isBlank() || dto.getUid().contains(" ")) {
//            return new ResVo(Const.NOT_ALLOWED_UID);
//        }
//        if (dto.getUpw() == null || dto.getUpw().isBlank() || dto.getUpw().contains(" ")) {
//            return new ResVo(Const.NOT_ALLOWED_PASSWORD);
//        }
//        if (dto.getNickname() == null || dto.getNickname().isBlank()) {
//            return new ResVo(Const.NOT_ALLOWED_NICKNAME);
//        }
        UserLoginProcDto checkUid = userMapper.selUserLoginInfo(dto.getUid());
        if (checkUid != null) {
            return new ResVo(Const.UID_DUPLICATED);
        }
        Integer checkNickname = userMapper.selUserByNickname(dto.getNickname());
        if (checkNickname != null) {
            return new ResVo(Const.NICKNAME_DUPLICATED);
        }
        String hashedUpw = BCrypt.hashpw(dto.getUpw(), BCrypt.gensalt());
        dto.setUpw(hashedUpw);
        int insResult = userMapper.insUser(dto);
        return new ResVo(dto.getUserId());

    }

    //유저 로그인 처리
    public UserLoginVo postSignin(UserLoginDto dto) {
        if (dto.getUid() == null || dto.getUid().isBlank()
                || dto.getUpw() == null || dto.getUpw().isBlank()) {
            return null;
        }
        UserLoginProcDto pDto = userMapper.selUserLoginInfo(dto.getUid());
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
                    .nickname(pDto.getNickname())
                    .result(Const.LOGIN_SUCCESS)
                    .build();
        }
        return resultVo;
    }

    //유저 회원정보(비밀번호, 닉네임) 변경 처리
    public ResVo patchProfile(UserUbdDto dto) {
        if (dto.getUpw() != null && dto.getUpw().contains(" ")) {
            return new ResVo(Const.NOT_ALLOWED_PASSWORD);
        }
        int updResult = 0;
        if (dto.getUpw() != null && !dto.getUpw().isBlank()) {
            String hashedUpw = BCrypt.hashpw(dto.getUpw(), BCrypt.gensalt());
            dto.setUpw(hashedUpw);
            updResult += userMapper.updUserUpw(dto);
        }
        if (dto.getNickname() == null) {
            return new ResVo(updResult);
        }
        Integer nicknameCheck = userMapper.selUserByNickname(dto.getNickname());
        if (nicknameCheck == null && dto.getNickname() != null && !dto.getNickname().isBlank()) {
            updResult += userMapper.updUserNickname(dto);
        }
        return new ResVo(updResult);
    }

    public ResVo delProfile(int loginedUserId) {
        int delTodoResult = todoMappermapper.delTodoForUnregister(loginedUserId);
        int delDiaryResult = diaryMappermapper.delDiaryForUnregister(loginedUserId);
        int delDiaryPicResult = diaryMappermapper.delDiaryPicForUnregister(loginedUserId);
        int delResult = userMapper.delUser(loginedUserId);
        return new ResVo(delResult);
    }
}
