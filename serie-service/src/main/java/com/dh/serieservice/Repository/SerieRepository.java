package com.dh.serieservice.Repository;

import com.dh.serieservice.Model.Serie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends MongoRepository<Serie, Integer> {

    List<Serie> findAllByGenre(String genre);
}
