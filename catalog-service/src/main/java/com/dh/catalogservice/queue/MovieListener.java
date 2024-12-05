package com.dh.catalogservice.queue;

import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.service.ICatalogService;
import com.dh.catalogservice.service.impl.CatalogService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MovieListener {
//    private final ICatalogService catalogService;

      private final CatalogService catalogService;

    public MovieListener(CatalogService catalogService) {
        this.catalogService = catalogService;
    }
  /*  public MovieListener(ICatalogService catalogService) {
        this.catalogService = catalogService;
    }*/

    @RabbitListener(queues = "movie-queue")
    public void listen(Movie movie) {

        //catalogService.addMovie(movie.genre(), movie);
        //catalogService.addMovieGeneric(movie);
        //catalogService.saveCatalog(movie);
        catalogService.saveCatalog(movie);
    }
}
