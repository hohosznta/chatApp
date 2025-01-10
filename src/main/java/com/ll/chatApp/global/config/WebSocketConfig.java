package com.ll.chatApp.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
@CrossOrigin(origins = "*")
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // 클라이언트가 구독할 엔드포인트를 설정
        config.enableSimpleBroker("/subscribe"); // 클라이언트가 구독할 메시지 브로커 경로
        config.setApplicationDestinationPrefixes("/publish"); // 클라이언트가 메시지를 보낼 경로
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // WebSocket 엔드포인트 등록 및 SockJS 지원
        registry.addEndpoint("/ws")
                .setAllowedOriginPatterns("*"); // CORS 허용
//                .withSockJS(); // SockJS를 사용하는 클라이언트를 지원
    }
}

