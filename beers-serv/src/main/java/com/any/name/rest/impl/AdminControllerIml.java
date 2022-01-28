package com.any.name.rest.impl;

import com.any.name.config.JwtUtil;
import com.any.name.rest.AdminController;
import com.any.name.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RequiredArgsConstructor
public class AdminControllerIml implements AdminController {
    private final UserService userService;
    private final JwtUtil jwtUtil;

    @Override
    public ResponseEntity adminAction(ServerHttpRequest serverHttpRequest) {
        String token = serverHttpRequest.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

        if (token == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } else {
            token = token.substring(7);

            if (!jwtUtil.validateToken(token)) {
                System.out.println(
                        jwtUtil
                                .getClaims(token)
                                .getSubject()
                );
                String token2 = token;
                return ResponseEntity
                        .ok()
                        .headers(httpHeaders ->
                                httpHeaders
                                        .setBearerAuth(token2)
                        )
                        .body("admin action");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        }
    }
}
