package com.ll.chatApp.domain.chat.ChatAI.repository;

import com.ll.chatApp.domain.chat.ChatAI.entity.ChatAIMessage;
import com.ll.chatApp.domain.chat.chatMessage.entity.ChatMessage;
import com.ll.chatApp.domain.chat.chatRoom.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatAIRepository extends JpaRepository<ChatAIMessage, Long> {

}
