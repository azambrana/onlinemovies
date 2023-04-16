package org.online.movies.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.online.movies.dto.MovieDto;
import org.online.movies.model.Movie;
import org.online.movies.service.MovieService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MoviesController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAllMovies() {
        return ResponseEntity.ok(movieService.findAll());
    }

    @PostMapping
    public ResponseEntity<MovieDto> addMovie(@RequestBody MovieDto movieDto) {
        MovieDto addedMovieDto = movieService.addMovie(movieDto);
        return ResponseEntity.created(URI.create("/movies/" + addedMovieDto.getId())).body(addedMovieDto);
    }

}
