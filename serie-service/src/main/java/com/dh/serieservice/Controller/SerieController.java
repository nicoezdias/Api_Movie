package com.dh.serieservice.Controller;

import com.dh.serieservice.Model.Serie;
import com.dh.serieservice.Service.ISerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/Serie")
public class SerieController {

    @Value("${server.port}")
    private String port;

    private final ISerieService serieService;

    @Autowired
    public SerieController(ISerieService serieService) {
        this.serieService = serieService;
    }

    @GetMapping("/{genre}")
    public ResponseEntity<List<Serie>> getSerieByGenre(@PathVariable String genre, HttpServletResponse response) {
        response.addHeader("port", port);
        return ResponseEntity.ok().body(serieService.getListByGenre(genre));
    }

    @PostMapping
    public ResponseEntity<Serie> saveSerie(@RequestBody Serie serie) {
        return ResponseEntity.ok().body(serieService.save(serie));
    }
}
