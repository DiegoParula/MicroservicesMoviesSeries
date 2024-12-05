package com.dh.movieservice.controller;

import com.dh.movieservice.Queue.MovieSender;
import com.dh.movieservice.model.Movie;
import com.dh.movieservice.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RefreshScope
@RestController
@RequiredArgsConstructor//chequear o inyectar directo
@RequestMapping("/api/v1/movies")
public class MovieController {
    private final MovieService movieService;
    private final MovieSender sender;


/*    @Value("${server.port}")
    private int serverPort;
*/


    @GetMapping("/{genre}")
    ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) {
        return ResponseEntity.ok().body(movieService.findByGenre(genre));
    }

    @PostMapping("/save")
    ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
        sender.send(movie);//
        return ResponseEntity.ok().body(movieService.save(movie));
    }
}
