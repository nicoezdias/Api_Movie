package com.dh.movieservice.Service;

import com.dh.movieservice.Model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IMovieService {
    List<Movie> getListByGenre(String genre);
    Movie save(Movie movie);
}
