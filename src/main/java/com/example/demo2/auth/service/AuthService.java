package com.example.demo2.auth.service;

import com.example.demo2.auth.dto.AuthLoginRequestDto;
import com.example.demo2.auth.dto.AuthLoginResponseDto;
import com.example.demo2.auth.dto.AuthSignupRequestDto;
import com.example.demo2.member.dto.MemberResponseDto;
import com.example.demo2.member.dto.MemberSaveResponseDto;
import com.example.demo2.member.entity.Member;
import com.example.demo2.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;

    @Transactional
    public void signup(AuthSignupRequestDto dto) {
        Member member = new Member(dto.getEmail());
        memberRepository.save(member);
    }

    public AuthLoginResponseDto login(AuthLoginRequestDto dto) {
        Member member = memberRepository.findByEmail(dto.getEmail()).orElseThrow(
                () -> new IllegalArgumentException("그런 멤버 없습니다")
        );
        return new AuthLoginResponseDto(member.getId());
    }
}
