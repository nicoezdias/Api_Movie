package com.dh.catalogservice.Service;

import com.dh.catalogservice.Model.MovieDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@FeignClient(name = "movie-service")
public interface MovieFeignClient {

    @GetMapping("/movies/{genre}")
    ResponseEntity<List<MovieDto>> findMovieByGenre(@PathVariable("genre") String genre);
}
