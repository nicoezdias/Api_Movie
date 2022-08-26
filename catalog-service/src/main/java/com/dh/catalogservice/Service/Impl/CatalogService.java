package com.dh.catalogservice.Service.Impl;

import com.dh.catalogservice.Model.CatalogDto;
import com.dh.catalogservice.Model.MovieDto;
import com.dh.catalogservice.Service.ICatalogService;
import com.dh.catalogservice.Service.MovieFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CatalogService implements ICatalogService {

    public static Logger LOG = LoggerFactory.getLogger(CatalogService.class);

    private final MovieFeignClient movieFeignClient;

    @Autowired
    public CatalogService(MovieFeignClient movieFeignClient) {
        this.movieFeignClient = movieFeignClient;
    }

    @Override
    public CatalogDto getCatalogByGenre(String genere) {
        ResponseEntity<List<MovieDto>> movieResponse = movieFeignClient.findMovieByGenre(genere);
        LOG.info("Puerto de la Instancia: " + movieResponse.getHeaders().get("port"));
        if (movieResponse.getStatusCode().is2xxSuccessful())
            return new CatalogDto(genere, movieResponse.getBody());
        return null;
    }
}
