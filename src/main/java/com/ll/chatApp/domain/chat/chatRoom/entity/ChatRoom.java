package com.ll.chatApp.domain.chat.chatRoom.entity;

import com.ll.chatApp.domain.chat.chatMessage.entity.ChatMessage;
import com.ll.chatApp.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
public class ChatRoom  extends BaseEntity {

    private String name;

    @OneToMany
    private List<ChatMessage> chatMessageList;
}
