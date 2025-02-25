package com.example.demo2.auth.controller;

import com.example.demo2.auth.dto.AuthLoginRequestDto;
import com.example.demo2.auth.dto.AuthLoginResponseDto;
import com.example.demo2.auth.dto.AuthSignupRequestDto;
import com.example.demo2.auth.service.AuthService;
import com.example.demo2.common.consts.Const;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public void signup(@RequestBody AuthSignupRequestDto dto) {
          authService.signup(dto);
    }

    @PostMapping("/login")
    public void login(@RequestBody AuthLoginRequestDto dto, HttpServletRequest request) {
        AuthLoginResponseDto result = authService.login(dto);

        HttpSession session = request.getSession();
        session.setAttribute(Const.LOGIN_USER, result.getMemberId());
    }
}
