package com.dh.catalogservice.service;

import com.dh.catalogservice.Repository.ICatalogRepository;
import com.dh.catalogservice.domain.model.Catalog;
import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.domain.model.Serie;
import org.springframework.http.HttpStatus;

import java.util.List;

/*
////////////////////////////////////////////////////////////////////
////////////////  CATALOG SERVICE INTERFACE  ///////////////////////
////////////////////////////////////////////////////////////////////
*/

public interface ICatalogService {


    /*///////No los vamos a usar
    List<Movie> getMovieByGenre (String genre);
    List<Serie> getSerieByGenre(String genre);

    Catalog getCatalogByGenre (String genre);

    Catalog saveCatalog (Catalog catalog);

    void catalogMovies (Catalog catalog,List<Movie> movies);

    void catalogSeries (Catalog catalog,List<Serie> series);

    void addMovie (String genre , Movie movie);

    void addSeries (String genre, Serie serie);

    void addMovieGeneric (Object content);

    void addSerieGeneric (Object content);

    */
    Catalog saveCatalog (Object content);


    List<Catalog> getCatalogBygGenre(String genre);


}
