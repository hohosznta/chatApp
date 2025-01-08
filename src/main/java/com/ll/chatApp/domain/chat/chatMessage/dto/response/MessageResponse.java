package com.ll.chatApp.domain.chat.chatMessage.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageResponse {
     private String author;
     private String content;
     private int RoomId;
}

