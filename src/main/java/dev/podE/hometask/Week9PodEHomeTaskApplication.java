package dev.podE.hometask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class Week9PodEHomeTaskApplication {

    @Bean
    public WebClient.Builder getBuilder(){
        return WebClient.builder();
    }

    public static void main(String[] args) {
        SpringApplication.run(Week9PodEHomeTaskApplication.class, args);
    }

}
