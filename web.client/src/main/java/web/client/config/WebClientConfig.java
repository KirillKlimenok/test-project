package web.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    public static final String BASE_LINK = "http://localhost:8081";

    @Bean
    public WebClient webClient() {
        return WebClient.create(BASE_LINK);
    }

}
