package org.scoula.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic"); // 구독시 사용할 토픽 접두어
        // 클라이언트가 발행 시 사용해야하는 접두어
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat-app") // 접속 엔드포인트, ws://localhost:8080/chat-app
                .setAllowedOrigins("*"); // CORS 허용

                // *보안 주의: 운영환경에서는 구체적인 도메인 지정 권장
                // .setAllowedOrigins("https://yourdomain.com", "https://anotherdomain.com");

                // *SockJS 지원 (WebSocket을 지원하지 않는 브라우저 대응)
                // .withSockJS(); // 필요시 추가
    }
}