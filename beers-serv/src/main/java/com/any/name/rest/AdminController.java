package com.any.name.rest;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RestController
public interface AdminController {

    @GetMapping("/admin")
     ResponseEntity adminAction(ServerHttpRequest serverHttpRequest);
}
