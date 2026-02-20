package net.ddns.adambravo79.moviehub.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.ddns.adambravo79.moviehub.client.TmdbClient;
import net.ddns.adambravo79.moviehub.dto.MovieDto;
import net.ddns.adambravo79.moviehub.dto.TmdbResponse;
import net.ddns.adambravo79.moviehub.dto.TvSeriesDto;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class TmdbController {

    private final TmdbClient tmdbClient;

    public TmdbController(TmdbClient tmdbClient) {
        this.tmdbClient = tmdbClient;
    }

    @GetMapping("/listartop10")
    public ResponseEntity<List<MovieDto>> listarTop10Filmes(
            @RequestParam(value = "page", defaultValue = "1") int page) {
        
        TmdbResponse<MovieDto> response = tmdbClient.getTopRatedMovies(page, null);
        
        // Pegar apenas os 10 primeiros
        List<MovieDto> top10 = response.getResults()
                .stream()
                .limit(10)
                .toList();
        
        return ResponseEntity.ok(top10);
    }

    @GetMapping("/listartop10series")
    public ResponseEntity<List<TvSeriesDto>> listarTop10Series(
            @RequestParam(value = "page", defaultValue = "1") int page) {
        
        TmdbResponse<TvSeriesDto> response = tmdbClient.getTopRatedTvSeries(page);
        
        // Pegar apenas os 10 primeiros
        List<TvSeriesDto> top10 = response.getResults()
                .stream()
                .limit(10)
                .toList();
        
        return ResponseEntity.ok(top10);
    }

    // Endpoints adicionais úteis
    @GetMapping("/filmes/populares")
    public ResponseEntity<List<MovieDto>> listarFilmesPopulares(
            @RequestParam(value = "page", defaultValue = "1") int page) {
        
        TmdbResponse<MovieDto> response = tmdbClient.getPopularMovies(page, null);
        return ResponseEntity.ok(response.getResults());
    }

    @GetMapping("/series/populares")
    public ResponseEntity<List<TvSeriesDto>> listarSeriesPopulares(
            @RequestParam(value = "page", defaultValue = "1") int page) {
        
        TmdbResponse<TvSeriesDto> response = tmdbClient.getPopularTvSeries(page);
        return ResponseEntity.ok(response.getResults());
    }
}
