package dev.cigana.teste_dws.clients;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ClientConfig {

    @Bean
    public WebClient jsonPlaceholderWebClient() {
        return WebClient.builder()
                .baseUrl("https://bands-api.vercel.app")
                .build();
    }

}
