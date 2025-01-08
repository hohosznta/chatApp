package com.ll.chatApp.domain.chat.chatMessage.service;

import com.ll.chatApp.domain.chat.chatMessage.entity.ChatMessage;
import com.ll.chatApp.domain.chat.chatMessage.repository.ChatMessageRepository;
import com.ll.chatApp.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chatApp.domain.chat.chatRoom.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;

    // 채팅방에 있는 채팅 내역 가져오기
    public List<ChatMessage> getChatMessageList(ChatRoom chatRoom, int id) {
        return this.chatMessageRepository.findAllByChatRoomAndIdGreaterThan(chatRoom,id);
    }
    // 채팅방에 있는 채팅 내역 전부 다 가져오기
    public List<ChatMessage> getAllChatMessageList(ChatRoom chatRoom) {
        return this.chatMessageRepository.findAllByChatRoom(chatRoom);
    }

    // 채팅 출력
    public ChatMessage createChatMessage(String author, String content,ChatRoom chatRoom) {
        ChatMessage chatmessage= ChatMessage.builder()
                .author(author)
                .content(content)
                .chatRoom(chatRoom)
                .build();

        this.chatMessageRepository.save(chatmessage);
        return chatmessage;
    }

}
