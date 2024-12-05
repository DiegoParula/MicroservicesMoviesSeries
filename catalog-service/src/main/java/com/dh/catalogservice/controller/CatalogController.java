package com.dh.catalogservice.controller;

import com.dh.catalogservice.domain.model.Catalog;
import com.dh.catalogservice.domain.model.Serie;
import com.dh.catalogservice.feing.MovieRepository;
import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.service.impl.CatalogService;
import com.dh.catalogservice.service.impl.MovieService;
import com.dh.catalogservice.service.impl.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
////////////////////////////////////////////////////////////////////
///////////////////    CATALOG CONTROLLER    ///////////////////////
////////////////////////////////////////////////////////////////////
*/

@RefreshScope
@RestController
@RequestMapping("/catalog")
class CatalogController {


    private final MovieService movieService;
    private final SerieService serieService;

    private final CatalogService catalogService;

    @Autowired
    CatalogController(MovieService movieService, SerieService serieService, CatalogService catalogService) {
        this.movieService = movieService;
        this.serieService = serieService;
        this.catalogService = catalogService;
    }


    @GetMapping("/movie/{genre}")
    ResponseEntity<List<Movie>> getGenre(@PathVariable String genre) {

        return ResponseEntity.ok().body(movieService.getMovieByGenre(genre));
    }


    @PostMapping("/movie/save")
    ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {

        return ResponseEntity.ok().body(movieService.saveMovie(movie));

    }


    //////////////////SERIE//////////////////////////////////////
    @GetMapping("/serie")
    ResponseEntity< List<Serie>> getAll() {
        return ResponseEntity.ok().body(serieService.getAll());
    }

    @GetMapping("/serie/{genre}")
    ResponseEntity< List<Serie>> getSerieByGenre(@PathVariable String genre) {
        return ResponseEntity.ok().body(serieService.getSerieByGenre(genre));
    }

    @PostMapping("/serie")
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody Serie serie) {
        serieService.createSerie(serie);
        return serie.id();//chequear el id por getid como es record la clase?
    }


    //////////////////CATALOG GENERAL///////////////////////////
    @GetMapping("/{genre}")
    ResponseEntity<List<Catalog>> getGenreGeneral(@PathVariable String genre) {

        return ResponseEntity.ok().body(catalogService.getCatalogBygGenre(genre));
    }

}
