package net.ddns.adambravo79.moviehub.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class MovieDto {
    private Long id;
    private String title;
    
    @JsonProperty("original_title")
    private String originalTitle;
    
    private String overview;
    
    @JsonProperty("poster_path")
    private String posterPath;
    
    @JsonProperty("backdrop_path")
    private String backdropPath;
    
    @JsonProperty("release_date")
    private LocalDate releaseDate;
    
    @JsonProperty("vote_average")
    private Double voteAverage;
    
    @JsonProperty("vote_count")
    private Integer voteCount;
    
    private Double popularity;
    
    @JsonProperty("genre_ids")
    private List<Integer> genreIds;
    
    private Boolean adult;
    
    @JsonProperty("original_language")
    private String originalLanguage;
    
    private String posterUrl;
    private String backdropUrl;
    
    // Métodos utilitários para construir URLs completos das imagens
    public String getPosterUrl() {
        return posterPath != null ? "https://image.tmdb.org/t/p/w500" + posterPath : null;
    }
    
    public String getBackdropUrl() {
        return backdropPath != null ? "https://image.tmdb.org/t/p/original" + backdropPath : null;
    }
}
