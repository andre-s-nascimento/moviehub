package net.ddns.adambravo79.moviehub.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class TvSeriesDto {
    private Long id;
    private String name;
    
    @JsonProperty("original_name")
    private String originalName;
    
    private String overview;
    
    @JsonProperty("poster_path")
    private String posterPath;
    
    @JsonProperty("backdrop_path")
    private String backdropPath;
    
    @JsonProperty("first_air_date")
    private LocalDate firstAirDate;
    
    @JsonProperty("vote_average")
    private Double voteAverage;
    
    @JsonProperty("vote_count")
    private Integer voteCount;
    
    private Double popularity;
    
    @JsonProperty("genre_ids")
    private List<Integer> genreIds;
    
    @JsonProperty("original_language")
    private String originalLanguage;
    
    @JsonProperty("origin_country")
    private List<String> originCountry;
    
    private String posterUrl;
    private String backdropUrl;
    
    public String getPosterUrl() {
        return posterPath != null ? "https://image.tmdb.org/t/p/w500" + posterPath : null;
    }
    
    public String getBackdropUrl() {
        return backdropPath != null ? "https://image.tmdb.org/t/p/original" + backdropPath : null;
    }
}
