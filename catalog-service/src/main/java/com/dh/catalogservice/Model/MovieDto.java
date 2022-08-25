package com.dh.catalogservice.Model;

public class MovieDto {
    private Integer id;
    private String name;
    private String genre;
    private String urlStream;

    public MovieDto() {
        //No-args constructor
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getUrlStream() {
        return urlStream;
    }

    public void setUrlStream(String urlStream) {
        this.urlStream = urlStream;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", urlStream='" + urlStream + '\'' +
                '}';
    }
}
