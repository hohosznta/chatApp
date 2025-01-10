package com.ll.chatApp.domain.chat.Member.Repository;

import com.ll.chatApp.domain.chat.Member.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
