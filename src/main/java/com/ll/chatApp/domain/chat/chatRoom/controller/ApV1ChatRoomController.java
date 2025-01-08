package com.ll.chatApp.domain.chat.chatRoom.controller;

import com.ll.chatApp.domain.chat.chatRoom.dto.RequestCreateRoom;
import com.ll.chatApp.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chatApp.domain.chat.chatRoom.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/chat/rooms")
@RequiredArgsConstructor
@CrossOrigin(origins = "https://cdpn.io/")
public class ApV1ChatRoomController {
    private final ChatRoomService  chatroomservice;

    @GetMapping("/{id}")
    public List<ChatRoom> getRoomList2(@PathVariable("id") int id) {
        List<ChatRoom> chatroomlist= chatroomservice.getList(id);
        return chatroomlist;
    }

    @GetMapping("")
    public List<ChatRoom> getRoomList() {
        List<ChatRoom> chatroomlist= chatroomservice.getRoomList();
        return chatroomlist;
    }

    @PostMapping("")
    public ChatRoom PostRooms(@RequestBody RequestCreateRoom requestCreateRoom) {
        ChatRoom chatroom = chatroomservice.createChatRoom(requestCreateRoom.getName());
        return chatroom;
    }
}
