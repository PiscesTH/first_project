package com.clean.cleanssakssak.user;

import com.clean.cleanssakssak.common.ResVo;
import com.clean.cleanssakssak.user.model.UserInsDto;
import com.clean.cleanssakssak.user.model.UserLoginDto;
import com.clean.cleanssakssak.user.model.UserLoginVo;
import com.clean.cleanssakssak.user.model.UserUbdDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;

    @Operation(summary = "회원 가입", description = """
            result = userId pk값 : 회원가입 성공<br>
            result = -1 : 아이디 중복<br>
            result = -2 : 닉네임 중복<br>
            result = -3 : 허용되지 않는 아이디<br>
            result = -4 : 허용되지 않는 비밀번호<br>
            result = -5 : 허용되지 않는 닉네임
            """)
    @PostMapping("/api/signup")
    public ResVo postSignup(@Valid @RequestBody UserInsDto dto) {
        return service.postSignup(dto);
    }

    @Operation(summary = "로그인 처리", description = """
            result = 1 : 로그인 성공<br>
            result = 2 : 비밀번호 틀림<br>
            result = 3 : 아이디 없음
            """)
    @PostMapping("/api/signin")
    public UserLoginVo postSignin(@Valid @RequestBody UserLoginDto dto) {
        return service.postSignin(dto);
    }

    @Operation(summary = "유저의 비밀번호/닉네임 변경 처리", description = """
            result = 0 : 변경 실패<br>
            result > 0 : 변경 성공<br>
            result = -4 : 허용되지 않는 비밀번호
            """)
    @PatchMapping("/profile")
    public ResVo patchProfile(@Valid @RequestBody UserUbdDto dto){
        return service.patchProfile(dto);
    }

    @Operation(summary = "회원 탈퇴 처리", description = """
            result = 1 : 회원 탈퇴 성공<br>
            result = 0 : 회원 탈퇴 실패
            """)
    @DeleteMapping("/profile")
    public ResVo delProfile(@RequestParam("logined_user_id") int loginedUserId){
        return service.delProfile(loginedUserId);
    }
}
