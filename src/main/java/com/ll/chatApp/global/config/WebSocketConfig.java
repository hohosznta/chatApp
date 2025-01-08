package com.ll.chatApp.global.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;
@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer {

    private final ChatWebSocketHandler chatWebSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // 핸들러 등록 경로 수정
        registry.addHandler(chatWebSocketHandler, "/ws/chat/{roomId}")
                .setAllowedOrigins("*");  // CORS 설정 (필요한 경우)
    }
}
