package com.ll.chatApp.global.initData;

import com.ll.chatApp.domain.article.entity.Article;
import com.ll.chatApp.domain.article.service.ArticleService;
import com.ll.chatApp.domain.chat.Member.Entity.Member;
import com.ll.chatApp.domain.chat.Member.Service.MemberService;
import com.ll.chatApp.domain.chat.chatMessage.entity.ChatMessage;
import com.ll.chatApp.domain.chat.chatMessage.service.ChatMessageService;
import com.ll.chatApp.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chatApp.domain.chat.chatRoom.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.stream.IntStream;

@Configuration
@Profile("!prod")
@RequiredArgsConstructor
public class NotProd {
    private final ChatRoomService chatRoomService;
    private final ChatMessageService chatMessageService;

    @Bean
    public ApplicationRunner initNotProd(ChatRoomService chatRoomService, ChatMessageService chatMessageService, MemberService memberService, ArticleService articleService) {
        return args -> {
//            ChatRoom chatRoom1=chatRoomService.createChatRoom("room1");
//            ChatRoom chatRoom2=chatRoomService.createChatRoom("room2");
//            ChatRoom chatRoom3=chatRoomService.createChatRoom("room3");
//
//            IntStream.rangeClosed(1, 100).forEach(i -> {
//                chatMessageService.createChatMessage("user1", "user1", chatRoom1);
//            });
//            IntStream.rangeClosed(1, 100).forEach(i -> {
//                chatMessageService.createChatMessage("user1", "user1", chatRoom2);
//            });
//            IntStream.rangeClosed(1, 100).forEach(i -> {
//                chatMessageService.createChatMessage("user1", "user1", chatRoom3);
//            });
            Member member1 = memberService.join("user1", "1234").getData();
            Member member2 = memberService.join("user2", "1234").getData();
            Member member3 = memberService.join("user3", "1234").getData();

            Article article1 = articleService.write(member1.getId(), "제목1", "내용1").getData();
            Article article2 = articleService.write(member1.getId(), "제목2", "내용2").getData();

            Article article3 = articleService.write(member2.getId(), "제목3", "내용3").getData();
            Article article4 = articleService.write(member2.getId(), "제목4", "내용4").getData();

            article1.addComment(member1, "댓글1");
            article1.addComment(member1, "댓글2");

            article2.addComment(member1, "댓글3");
            article2.addComment(member1, "댓글4");
            article2.addComment(member1, "댓글5");

            article3.addComment(member1, "댓글5");
            article3.addComment(member1, "댓글6");
            article3.addComment(member1, "댓글7");
            article3.addComment(member1, "댓글8");
            article3.addComment(member1, "댓글9");
            article3.addComment(member1, "댓글10");
            article3.addComment(member1, "댓글11");
            article3.addComment(member1, "댓글12");
        };
    }
}