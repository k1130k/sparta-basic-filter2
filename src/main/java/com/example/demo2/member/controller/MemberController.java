package com.example.demo2.member.controller;

import com.example.demo2.member.dto.MemberResponseDto;
import com.example.demo2.member.dto.MemberSaveResponseDto;
import com.example.demo2.member.dto.MemberSaveRequestDto;
import com.example.demo2.member.dto.MemberUpdateRequestDto;
import com.example.demo2.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private MemberService memberService;

    @GetMapping("/members")
    public List<MemberResponseDto> getAll() {
        return memberService.findAll();
    }

    @GetMapping("/members/{memberId}")
    public ResponseEntity<MemberResponseDto> getone(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.findById(memberId));
    }

    @PutMapping("/members/{memberId}")
    public void update(@PathVariable Long memberId, @RequestBody MemberUpdateRequestDto dto) {
        memberService.update(memberId, dto);
    }

    @DeleteMapping("/members/{memberId}")
    public void delete(@PathVariable Long memberId) {
        memberService.deleteById(memberId);
    }


}
