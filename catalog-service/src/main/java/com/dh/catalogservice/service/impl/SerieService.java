package com.dh.catalogservice.service.impl;

import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.domain.model.Serie;
import com.dh.catalogservice.feing.SerieRepository;
import com.dh.catalogservice.service.ISerieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SerieService implements ISerieService {

    private final SerieRepository serieRepository;

    @Autowired
    public SerieService(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }


   // @Override

    public List<Serie> getAll() {
          return serieRepository.getAll();
//        ResponseEntity<List<Serie>> response = serieRepository.getAll();
  //      return response.getBody();
        //return serieRepository.getAll();
    }

   // @Override
    public List<Serie> getSerieByGenre(String genre) {
        return serieRepository.getSerieByGenre(genre);

        //ResponseEntity<List<Serie>> response = serieRepository.getSerieByGenre(genre);
        //return response.getBody();
//        return serieRepository.getSerieByGenre(genre);
        /*List<Serie> response = serieRepository.getSerieByGenre(genre);
        return response;*/
    }

   // @Override
    public String createSerie(Serie serie) {
        return serieRepository.create(serie);
//        ResponseEntity<String> response = serieRepository.create(serie);
  //      return response.getBody();
//        return serieRepository.create(serie);
    }


}
