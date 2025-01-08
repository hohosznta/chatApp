//package com.ll.chatApp.global.initData;
//
//import com.ll.chatApp.domain.chat.chatMessage.entity.ChatMessage;
//import com.ll.chatApp.domain.chat.chatMessage.service.ChatMessageService;
//import com.ll.chatApp.domain.chat.chatRoom.entity.ChatRoom;
//import com.ll.chatApp.domain.chat.chatRoom.service.ChatRoomService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//
//import java.util.stream.IntStream;
//
//@Configuration
//@Profile("!prod")
//@RequiredArgsConstructor
//public class NotProd {
//    private final ChatRoomService chatRoomService;
//    private final ChatMessageService chatMessageService;
//
//    @Bean
//    public ApplicationRunner initNotProd(ChatRoomService chatRoomService, ChatMessageService chatMessageService) {
//        return args -> {
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
//        };
//    }
//}