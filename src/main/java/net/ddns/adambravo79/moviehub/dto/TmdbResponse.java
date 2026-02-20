package net.ddns.adambravo79.moviehub.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TmdbResponse<T> {
    private int page;
    
    @JsonProperty("total_pages")
    private int totalPages;
    
    @JsonProperty("total_results")
    private int totalResults;
    
    private List<T> results;
}