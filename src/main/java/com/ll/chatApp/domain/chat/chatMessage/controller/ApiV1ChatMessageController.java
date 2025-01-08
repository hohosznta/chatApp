package com.ll.chatApp.domain.chat.chatMessage.controller;

import com.ll.chatApp.domain.chat.chatMessage.dto.request.MessageRequest;
import com.ll.chatApp.domain.chat.chatMessage.entity.ChatMessage;
import com.ll.chatApp.domain.chat.chatMessage.service.ChatMessageService;
import com.ll.chatApp.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chatApp.domain.chat.chatRoom.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "https://cdpn.io/")
public class ApiV1ChatMessageController {
    private final ChatMessageService chatmessageservice;
    private final ChatRoomService chatRoomService;

//    @GetMapping("/{id}/messages")
//    public List<ChatMessage> getUserByIdAfter(@PathVariable("id") int id, @RequestParam String afterChatMessageId) {
//        ChatRoom chatroom = chatRoomService.getId(id);
//        List<ChatMessage> chatlist= chatmessageservice.getChatMessageList(chatroom, Integer.parseInt(afterChatMessageId));
//        return chatlist;
//    }

    @GetMapping("/api/v1/chat/rooms/{id}/messages")
    public List<ChatMessage> getUserById(@PathVariable("id") int id) {
        ChatRoom chatroom = chatRoomService.getId(id);
        List<ChatMessage> chatlist= chatmessageservice.getAllChatMessageList(chatroom);
        return chatlist;
    }

//    @MessageMapping("/chat/{roomId}")  // 클라이언트가 보낸 메시지를 받을 경로
//    @SendTo("/topic/{roomId}")  // 구독자가 받게 될 메시지 경로
//    public String sendMessage(ChatMessage message, @DestinationVariable String roomId) {
//        // roomId를 기반으로 메시지 처리
//        System.out.println("Received message in room " + roomId + ": " + message.getContent());
//        String response=message.getContent();
//        // 클라이언트로 보낼 응답 메시지
//        return response;
//    }

    @PostMapping("/api/v1/chat/rooms/{id}/messages")
    public String PostMessage(@PathVariable("id") int id,@RequestBody MessageRequest messageRequest) {
        ChatRoom chatroom = chatRoomService.getId(id);

        String author = messageRequest.getAuthor();
        String content = messageRequest.getContent();
        chatmessageservice.createChatMessage(author, content ,chatroom);
        return "채팅 생성 완료";
    }
}
