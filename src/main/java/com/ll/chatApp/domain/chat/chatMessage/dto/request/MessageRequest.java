package com.ll.chatApp.domain.chat.chatMessage.dto.request;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MessageRequest {
    private String author;
    private String content;

}
