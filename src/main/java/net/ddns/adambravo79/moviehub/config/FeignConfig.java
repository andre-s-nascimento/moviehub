package net.ddns.adambravo79.moviehub.config;

import feign.Logger;
import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Value("${tmdb.api.key}")
    private String apiKey;

    @Bean
    public RequestInterceptor apiKeyInterceptor() {
        return requestTemplate -> requestTemplate
            .query("api_key", apiKey)
            .query("language", "pt-BR");
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return (methodKey, response) -> {
            String errorMessage = String.format(
                "Erro na chamada à API TMDb. Status: %s, Method: %s",
                response.status(), methodKey
            );
            return new RuntimeException(errorMessage);
        };
    }
}