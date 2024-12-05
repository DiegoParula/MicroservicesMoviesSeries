package com.dh.catalogservice.service.impl;

import com.dh.catalogservice.Repository.ICatalogRepository;
import com.dh.catalogservice.domain.model.Catalog;
import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.domain.model.Serie;
import com.dh.catalogservice.service.ICatalogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CatalogService implements ICatalogService {

    private final MovieService movieService;
    //private final ICatalogService catalogService;
    private final SerieService serieService;
    private final ICatalogRepository catalogRepository;

    /* //////////////////no los vamos a usar por el momento
    @Override
    public List<Movie> getMovieByGenre(String genre) {
        //List<Movie> response =
        return catalogService.getMovieByGenre(genre);
    }

    @Override
    public List<Serie> getSerieByGenre(String genre) {
        return catalogService.getSerieByGenre(genre);
    }

    @Override
    public Catalog getCatalogByGenre(String genre) {
        return catalogService.getCatalogByGenre(genre);

        Catalog catalog = catalogService.getCatalogByGenre(genre);//obtrengo el catalogo para ese genero
        if (catalog != null){//si el catalgo existe
            if(catalog.getMovies() == null){//verifico la lista de peliculas
                   catalogMovies(catalog, movieService.getMovieByGenre(genre));//actualizo llamando a microservicio
            }//actualizar cuando tebnga series
            if(catalog.getSeries() == null){
                catalogSeries(catalog, serieService.getSerieByGenre(genre));
            }
            return catalog;
        }else{//si no existe catalogo para el genero, creo uno nuevo
            Catalog newCatalog = new Catalog();
            newCatalog.setGenre(genre);
            newCatalog.setMovies(movieService.getMovieByGenre(genre));
            newCatalog.setSeries(serieService.getSerieByGenre(genre));
            return this.saveCatalog(newCatalog);
        }


    }



    @Override
    public void catalogMovies(Catalog catalog, List<Movie> movies) {
        //Catalog catalog = getCatalogByGenre()
    }

    @Override
    public void catalogSeries(Catalog catalog, List<Serie> series) {

    }

    @Override//chequear
    public void addMovie(String genre, Movie movie) {
        return;
        Catalog catalog = this.getCatalogByGenre(genre);
        List<Movie> movies = catalog.getMovies();
        movies.add(movie);
        catalogService.saveCatalog(catalog);
   }

    @Override//chequear
    public void addSeries(String genre, Serie serie) {
        return;

        Catalog catalog = this.getCatalogByGenre(genre);
        List<Serie> series = catalog.getSeries();
        series.add(serie);
        catalogService.saveCatalog(catalog);

    }

     @Override
    public void addMovieGeneric(Object content) {
        catalogService.saveCatalog((Catalog) content);
    }

    @Override
    public void addSerieGeneric(Object content) {
        catalogService.saveCatalog((Catalog) content);

    }

    */


    ///////////////////////////Vamos a usar estos usando la nueva clase de catalog con object//////////////////////////////////

    @Override//asi podemos guardar movie o serie del listener
    public Catalog saveCatalog(Object content) {
        Catalog newCatalog = new Catalog();
        newCatalog.setContent(content);
        return catalogRepository.save(newCatalog);
    }



    @Override
    public List<Catalog> getCatalogBygGenre(String genre) {
        return catalogRepository.findByGenre(genre);
    }



    /*@Override
    public void addMovieGeneric(Movie movie) {
        catalogService.saveCatalog(movie);
    }*/


}




