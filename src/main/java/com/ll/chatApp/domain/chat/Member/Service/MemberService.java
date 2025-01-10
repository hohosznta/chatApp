package com.ll.chatApp.domain.chat.Member.Service;

import com.ll.chatApp.domain.chat.Member.Entity.Member;
import com.ll.chatApp.domain.chat.Member.Repository.MemberRepository;
import com.ll.chatApp.global.rsData.RsData;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Builder
public class MemberService {
    private final MemberRepository memberRepository;

    public RsData<Member> join(String username, String password) {
        Member member = this.memberRepository.save(Member.builder()
                .username(username)
                .password(password)
                .build());
        return RsData.of("200", "회원가입 성공", member);
    }

    public Optional<Member> findById(long l) {
        return memberRepository.findById(l);
    }
}
