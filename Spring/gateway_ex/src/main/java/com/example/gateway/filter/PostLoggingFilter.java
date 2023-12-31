package com.example.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.time.Instant;

@Slf4j
@Component
public class PostLoggingFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return chain.filter(exchange)
                .then(Mono.fromRunnable(() -> {
                    ServerHttpRequest httpRequest = exchange.getRequest();
                    // PreLoggingFilter header 값 받아오기
                    String requestId = httpRequest.getHeaders()
                            .getFirst("x-gateway-request-id");
                    String requestTimeString = httpRequest.getHeaders()
                            .getFirst("x-gateway-request-time");

                    // PreLoggingFilter time - now
                    long timeEnd = Instant.now().toEpochMilli();
                    long timeStart = Long.parseLong(requestTimeString);
                    log.info("Execution Time id: {}, timediff(ms): {}",
                            requestId, timeEnd - timeStart);
                }));
    }
}
