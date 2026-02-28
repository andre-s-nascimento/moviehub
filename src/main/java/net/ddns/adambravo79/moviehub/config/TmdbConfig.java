package net.ddns.adambravo79.moviehub.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
@Configuration
@ConfigurationProperties(prefix = "tmdb.api")
public class TmdbConfig {
    private String key;
    private String baseUrl;
    private String language;
    private String imageBaseUrl;
    
    // Método para validar se a configuração está carregada
    public void validate() {
        if (key == null || key.isEmpty() || "SUA_CHAVE_AQUI".equals(key)) {
            throw new IllegalStateException(
                "TMDB API Key não configurada! " +
                "Configure no arquivo: config/tmdb-config.yml"
            );
        }
    }
}
