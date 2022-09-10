package com.dh.serieservice.Service.Impl;

import com.dh.serieservice.Model.Serie;
import com.dh.serieservice.Repository.SerieRepository;
import com.dh.serieservice.Service.ISerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService implements ISerieService {

    private final SerieRepository serieRepository;

    @Autowired
    public SerieService(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    @Override
    public List<Serie> getListByGenre(String genre) {
        return serieRepository.findAllByGenre(genre);
    }

    @Override
    public Serie save(Serie serie) {
        return serieRepository.save(serie);
    }
}
