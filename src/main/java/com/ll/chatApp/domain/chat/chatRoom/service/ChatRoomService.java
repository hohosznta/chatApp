package com.ll.chatApp.domain.chat.chatRoom.service;

import com.ll.chatApp.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chatApp.domain.chat.chatRoom.repository.ChatRoomRepository;
import com.ll.chatApp.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;

    public ChatRoom createChatRoom(String name) {
        ChatRoom chatroom= ChatRoom.builder()
                .name(name)
                .build();

        chatRoomRepository.save(chatroom);
        return chatroom;
    }

    public ChatRoom getId(long id) {
        return chatRoomRepository.findById(id).orElse(null);
    }

    public List<ChatRoom> getList(long id) {
        return (List<ChatRoom>) chatRoomRepository.findById(id).orElse(null);
    }

    public List<ChatRoom> getRoomList() {
        return (List<ChatRoom>) chatRoomRepository.findAll();
    }
}
