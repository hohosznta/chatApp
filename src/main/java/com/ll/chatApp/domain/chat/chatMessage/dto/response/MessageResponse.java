package com.ll.chatApp.domain.chat.chatMessage.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MessageResponse {
     private String author;
     private String content;

}

