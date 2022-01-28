package web.client.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import web.client.model.AuthReq;
import web.client.model.AuthResp;
import web.client.model.User;

@Configuration
@RestController
@RequiredArgsConstructor
public class TestRest {
    private final WebClient webClient;

    @GetMapping("/login")
    public Mono<AuthResp> log(@RequestBody(required = false)
                                      AuthReq authReq) {
        return webClient
                .post().uri("/login")
                .body(Mono.just(new User(authReq.getUsername(), authReq.getPassword())), User.class)
                .retrieve()
                .bodyToMono(AuthResp.class);
    }

}
