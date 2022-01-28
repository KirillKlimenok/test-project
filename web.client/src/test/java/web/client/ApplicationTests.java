package web.client;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import web.client.model.Beer;
import web.client.model.User;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@SpringBootTest
class ApplicationTests {

    private WebClient webClient = WebClient.create("http://localhost:8081/");
    private WebServer webServer = new WebServer(webClient);

    @Test
    void contextLoads() {
        System.out.println(webServer.listBeer().blockFirst());
    }

    @Test
    public void auth() throws InterruptedException {
        System.out.println(webClient
                .post().uri("/login")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(new User("user", "user")), User.class)
                .retrieve());
    }

    @Test
    public void test(){
//        new BC
    }


}
