package web.client;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import web.client.model.Beer;

@SpringBootTest
class ApplicationTests {

    private WebClient webClient =
            WebClient
                    .create("http://localhost:8081");

    private WebServer webServer = new WebServer(webClient);

    @Test
    void contextLoads() {
        System.out.println(webServer.listBeer().blockFirst());
    }

}
