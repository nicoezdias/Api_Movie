package com.dh.movieservice.Service.Impl;

import com.dh.movieservice.Model.Movie;
import com.dh.movieservice.Repository.MovieRepository;
import com.dh.movieservice.Service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieService implements IMovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getListByGenre(String genre) {
        return movieRepository.findAllByGenre(genre);
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }
}
