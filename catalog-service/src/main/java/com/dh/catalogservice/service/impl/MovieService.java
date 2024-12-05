package com.dh.catalogservice.service.impl;

import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.feing.MovieRepository;
import com.dh.catalogservice.service.IMovieService;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Slf4j
public class MovieService implements IMovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Override //Se ha integrado el circuit breaker en el servicio de listado por género para detectar la falta de operatividad del mismo, porque consideramos que trata de una
    // aplicacion de streaming en la q se destacaria la alta demanda de este servicio para los usuarios
    @CircuitBreaker(name= "movie", fallbackMethod = "messageFallbackMethod")//va el nombre movie en yml
    public List<Movie> getMovieByGenre(String genre) {
        ResponseEntity<List<Movie>> response = movieRepository.getMovieByGenre(genre);
        return response.getBody();
    }



    @Override
    @CircuitBreaker(name= "movie", fallbackMethod = "messageFallbackMethod")
    public Movie saveMovie(Movie movie) {
        return movieRepository.saveMovie(movie).getBody();
    }

    private List<Movie> messageFallbackMethod(CallNotPermittedException e){
        return new ArrayList<>();
    }

}
