package net.ddns.adambravo79.moviehub.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.ddns.adambravo79.moviehub.config.FeignConfig;
import net.ddns.adambravo79.moviehub.dto.MovieDto;
import net.ddns.adambravo79.moviehub.dto.TmdbResponse;
import net.ddns.adambravo79.moviehub.dto.TvSeriesDto;

@FeignClient(
    name = "tmdbClient",
    url = "${tmdb.api.base-url}",
    configuration = FeignConfig.class
)
public interface TmdbClient {

    @GetMapping("/movie/top_rated")
    TmdbResponse<MovieDto> getTopRatedMovies(
        @RequestParam(value = "page", defaultValue = "1") int page,
        @RequestParam(value = "region", required = false) String region
    );

    @GetMapping("/movie/popular")
    TmdbResponse<MovieDto> getPopularMovies(
        @RequestParam(value = "page", defaultValue = "1") int page,
        @RequestParam(value = "region", required = false) String region
    );

    @GetMapping("/tv/top_rated")
    TmdbResponse<TvSeriesDto> getTopRatedTvSeries(
        @RequestParam(value = "page", defaultValue = "1") int page
    );

    @GetMapping("/tv/popular")
    TmdbResponse<TvSeriesDto> getPopularTvSeries(
        @RequestParam(value = "page", defaultValue = "1") int page
    );
}
