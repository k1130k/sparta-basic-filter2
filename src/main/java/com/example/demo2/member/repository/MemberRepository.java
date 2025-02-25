package com.example.demo2.member.repository;

import com.example.demo2.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository <Member, Long> {
}
