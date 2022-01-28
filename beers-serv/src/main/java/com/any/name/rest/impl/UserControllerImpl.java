package com.any.name.rest.impl;

import com.any.name.config.JwtUtil;
import com.any.name.model.AuthReq;
import com.any.name.model.AuthResp;
import com.any.name.model.RegRequest;
import com.any.name.model.User;
import com.any.name.rest.UserController;
import com.any.name.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {
    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public static final ResponseEntity<Object> UNAUTHORIZED
            = ResponseEntity
            .status(HttpStatus.UNAUTHORIZED)
            .build();


    @Override
    public Mono<AuthResp> login(AuthReq authReq) {

        log.info("password code: {}", passwordEncoder.encode(authReq.getPassword()));
        log.info("password no encoded: {}", authReq.getPassword());

        return userService
                .findByUsername(authReq.getUsername())
                .cast(User.class)
                .map(user -> {
                    if (passwordEncoder.matches(authReq.getPassword(), user.getPassword())) {
                        return new AuthResp(jwtUtil.generateToken(user));
                    } else {
                        return new AuthResp(null);
                    }
                });
    }

}
