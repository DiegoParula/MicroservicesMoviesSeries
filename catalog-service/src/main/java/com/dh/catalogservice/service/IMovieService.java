package com.dh.catalogservice.service;

import com.dh.catalogservice.domain.model.Movie;

import java.util.List;

public interface IMovieService {
    List<Movie> getMovieByGenre (String genre);

    Movie saveMovie(Movie movie);
}
