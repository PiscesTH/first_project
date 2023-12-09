package com.clean.cleanssakssak.user;

import com.clean.cleanssakssak.common.ResVo;
import com.clean.cleanssakssak.user.model.UserInsDto;
import com.clean.cleanssakssak.user.model.UserLoginDto;
import com.clean.cleanssakssak.user.model.UserLoginVo;
import com.clean.cleanssakssak.user.model.UserUbdDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;

    @Operation(summary = "회원 가입", description = """
            result = userId pk값 : 회원가입 성공<br>
            result = -1 : 아이디 중복<br>
            result = -2 : 닉네임 중복
            """)
    @PostMapping("/api/signup")
    public ResVo postSignup(UserInsDto dto) {
        return service.postSignup(dto);
    }

    @Operation(summary = "로그인 처리", description = """
            result = 1 : 로그인 성공<br>
            result = 2 : 비밀번호 틀림<br>
            result = 3 : 아이디 없음
            """)
    @PostMapping("/api/signin")
    public UserLoginVo postSignin(UserLoginDto dto) {
        return service.postSignin(dto);
    }

    @PatchMapping("/profile")
    public ResVo patchProfile(UserUbdDto dto){
        return service.patchProfile(dto);
    }

}
