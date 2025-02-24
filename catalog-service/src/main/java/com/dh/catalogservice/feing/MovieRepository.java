package com.dh.catalogservice.feing;

import com.dh.catalogservice.configuration.CustomRandomLoadBalancer;
import com.dh.catalogservice.domain.model.Movie;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/*
////////////////////////////////////////////////////////////////////
///////////////////////  MOVIE SERVICE  ////////////////////////////
////////////////////////////////////////////////////////////////////
*/

@FeignClient(name = "movie-service")
//@LoadBalancerClient(name = "movie-service", configuration = CustomRandomLoadBalancer.class)
public interface MovieRepository {

    @GetMapping("/api/v1/movies/{genre}")
    ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable(value = "genre") String genre);

    @PostMapping("/api/v1/movies/save")
    ResponseEntity<Movie> saveMovie(@RequestBody Movie movie);
}
