package com.dh.catalogservice.feing;

import com.dh.catalogservice.domain.model.Movie;
import com.dh.catalogservice.domain.model.Serie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "serie-service")
public interface SerieRepository {

    @GetMapping("/api/v1/series")
    List<Serie> getAll();

    @GetMapping("/api/v1/series/{genre}")
    List<Serie> getSerieByGenre(@PathVariable String genre);

    @PostMapping("/api/v1/series")
    @ResponseStatus(HttpStatus.CREATED)
    String create(@RequestBody Serie serie);
}
