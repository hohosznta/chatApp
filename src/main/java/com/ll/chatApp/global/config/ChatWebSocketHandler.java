package com.ll.chatApp.global.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ll.chatApp.domain.chat.chatMessage.dto.response.MessageResponse;
import com.ll.chatApp.domain.chat.chatMessage.service.ChatMessageService;
import com.ll.chatApp.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chatApp.domain.chat.chatRoom.repository.ChatRoomRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ChatWebSocketHandler extends TextWebSocketHandler {
    private final ChatMessageService chatmessageservice;
    private final ChatRoomRepository chatRoomRepository;
    private final ObjectMapper objectMapper = new ObjectMapper(); // JSON 변환용
    private final List<WebSocketSession> sessions = new ArrayList<>();

    // 생성자에서 ChatRoomRepository도 주입
    public ChatWebSocketHandler(ChatMessageService chatmessageservice, ChatRoomRepository chatRoomRepository) {
        this.chatmessageservice = chatmessageservice;
        this.chatRoomRepository = chatRoomRepository;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);  // 새로운 클라이언트 연결 시 세션 추가
    }

    // 메시지를 받을 때마다 호출되는 메소드
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 받은 메시지 출력 (메시지는 JSON 형태일 것으로 예상)
        System.out.println("Received message: " + message.getPayload());

        // 메시지 페이로드를 JSON 객체로 변환
        String payload = message.getPayload();  // 텍스트 메시지 (예: JSON 문자열)
        MessageResponse chatMessage = objectMapper.readValue(payload, MessageResponse.class); // JSON -> 객체로 변환

        // roomId로 ChatRoom을 조회
        int roomId = chatMessage.getRoomId();
        Optional<ChatRoom> chatRoomOptional = chatRoomRepository.findById((long) roomId);
        ChatRoom chatRoom = chatRoomOptional.orElseThrow(() -> new RuntimeException("ChatRoom not found"));

        String author = chatMessage.getAuthor();
        String content = chatMessage.getContent();

        // 채팅 메시지 저장
        chatmessageservice.createChatMessage(author, content, chatRoom);

        for (WebSocketSession wsSession : sessions) {
            if (wsSession.isOpen() && !wsSession.equals(session)) {
                wsSession.sendMessage(new TextMessage(message.getPayload()));  // 클라이언트에게 메시지 전송
            }
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);  // 클라이언트 연결 종료 시 세션 제거
    }
}



