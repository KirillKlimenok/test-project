package web.client;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import web.client.model.Beer;

@Component
@RequiredArgsConstructor
public class WebServer {
    private final WebClient webClient;

    public static final String LINK_TO_BEER_CONTROLLER = "/beers";

    public Flux<Beer> listBeer() {
        return webClient.get().uri(LINK_TO_BEER_CONTROLLER)
                .header(HttpHeaders.AUTHORIZATION, "Bearer eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjpbIlJPTEVfQURNSU4iXSwic3ViIjoiYWRtaW4iLCJpYXQiOjE2NDMzNTQ0NTEsImV4cCI6MTY0MzM4MjQ1MX0.YJxpu8XkU7k5pLyFy-NDRClhZNllm0Xq4XnWyTIFOV4")
                .retrieve()
                .bodyToFlux(Beer.class);
    }

}
