package com.example.demo2.auth.dto;

import lombok.Getter;

@Getter
public class AuthLoginResponseDto {

    private final Long memberId;

    public AuthLoginResponseDto(Long memberId) {
        this.memberId = memberId;
    }
}
