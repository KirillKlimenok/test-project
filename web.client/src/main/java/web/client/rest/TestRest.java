package web.client.rest;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import web.client.model.AuthReq;
import web.client.model.AuthResp;
import web.client.model.User;

@Configuration
@RestController
public class TestRest {
    private WebClient webClient = WebClient.create("http://localhost:8081/");

    @GetMapping("/login")
    public Mono<AuthResp> log(@RequestBody AuthReq authReq) {
        return webClient
                .post().uri("/login")
                .body(Mono.just(new User(authReq.getUsername(), authReq.getPassword())), User.class)
                .retrieve()
                .bodyToMono(AuthResp.class);
    }

}
