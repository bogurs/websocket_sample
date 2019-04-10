package com.example.navy.websocketexercise.hello;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /**
     * gs-guide-websocket 엔드포인트를 통해 소켓에 연결하게 된다.
     * static/app.js 에서 SockJS('gs-guide-websocket')을 통해 연결.
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/gs-guide-websocket").withSockJS();
    }

    /**
     * /topic/** 에 대해 메시지 구독 브로커 서비스를 제공한다. Controller에 /topic/**에 대한 로직이 있다.
     * /app/** 에 대해 클라이언트 앱의 목적지를 제공한다.
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/app");
    }
}
