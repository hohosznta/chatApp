package com.ll.chatApp.domain.chat.chatMessage.controller;

import com.ll.chatApp.domain.chat.chatMessage.dto.request.MessageRequest;
import com.ll.chatApp.domain.chat.chatMessage.dto.response.MessageResponse;
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
//@CrossOrigin(origins = "*")
public class ApiV1ChatMessageController {
    private final ChatMessageService chatmessageservice;
    private final ChatRoomService chatRoomService;

    @MessageMapping("/chat.{chatRoomId}") // WebSocket 경로
    @SendTo("/subscribe/chat.{chatRoomId}") // 구독 경로
    public MessageResponse sendMessage(MessageRequest request, @DestinationVariable int chatRoomId) {
        System.out.println(chatRoomId);
        return new MessageResponse(request.getAuthor(), request.getContent());
    }



    @GetMapping("/api/v1/chat/rooms/{id}/messages")
    public List<ChatMessage> getUserById(@PathVariable("id") int id) {
        ChatRoom chatroom = chatRoomService.getId(id);
        List<ChatMessage> chatlist= chatmessageservice.getAllChatMessageList(chatroom);
        return chatlist;
    }


    @PostMapping("/api/v1/chat/rooms/{id}/messages")
    public String PostMessage(@PathVariable("id") int id,@RequestBody MessageRequest messageRequest) {
        ChatRoom chatroom = chatRoomService.getId(id);

        String author = messageRequest.getAuthor();
        String content = messageRequest.getContent();
        chatmessageservice.createChatMessage(author, content ,chatroom);
        return "채팅 생성 완료";
    }
}
