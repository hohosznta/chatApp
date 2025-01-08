package com.ll.chatApp.domain.chat.ChatAI.entity;

import com.ll.chatApp.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chatApp.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Setter
@Getter
@SuperBuilder
@ToString(callSuper = true)
@NoArgsConstructor
public class ChatAIMessage extends BaseEntity {

    private String author;

    private String content;
}