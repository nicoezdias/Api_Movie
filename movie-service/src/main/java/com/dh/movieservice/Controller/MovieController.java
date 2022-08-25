package com.dh.movieservice.Controller;

import com.dh.movieservice.Model.Movie;
import com.dh.movieservice.Service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Value("${server.port}")
    private String port;

    private final IMovieService movieService;

    @Autowired
    public MovieController(IMovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{genre}")
    public ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre, HttpServletResponse response) {
        response.addHeader("port", port);
        return ResponseEntity.ok().body(movieService.getListByGenre(genre));
    }

    @PostMapping
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok().body(movieService.save(movie));
    }
}
