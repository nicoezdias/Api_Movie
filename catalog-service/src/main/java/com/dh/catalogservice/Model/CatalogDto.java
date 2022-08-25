package com.dh.catalogservice.Model;

import java.util.List;

public class CatalogDto {
    private String genre;
    private List<MovieDto> movies;

    public CatalogDto() {
        //No-args constructor
    }

    public CatalogDto(String genre, List<MovieDto> movies) {
        this.genre = genre;
        this.movies = movies;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<MovieDto> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieDto> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "CatalogDto{" +
                "genre='" + genre + '\'' +
                ", movies=" + movies +
                '}';
    }
}
