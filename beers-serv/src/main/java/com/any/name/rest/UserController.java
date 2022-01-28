package com.any.name.rest;

import com.any.name.model.AuthReq;
import com.any.name.model.AuthResp;
import com.any.name.model.RegRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@RestController
public interface UserController {

    @PostMapping("login")
    Mono<AuthResp> login(@RequestBody AuthReq authReq);
}
