package com.clean.cleanssakssak.user;

import com.clean.cleanssakssak.common.ResVo;
import com.clean.cleanssakssak.user.model.UserInsDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;

    @Operation(summary = "회원 가입", description = "회원 가입 성공 : userId pk값 리턴<br>" +
            "아이디 중복 : -1<br>" +
            "닉네임 중복 : -2")
    @PostMapping("/api/signup")
    public ResVo postSignup(UserInsDto dto) {
        return service.postSignup(dto);
    }
}
