package org.online.movies.controller;

import java.net.URI;
import java.util.List;

import org.online.movies.dto.MovieDto;
import org.online.movies.model.User;
import org.online.movies.service.AuthenticationService;
import org.online.movies.service.AuthorizationService;
import org.online.movies.service.AuthorizationServiceImpl;
import org.online.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/movies")
public class MoviesController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private AuthorizationService authorizationService;

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAllMovies(@RequestHeader("Authorization") String authorizationHeader) {
        if ( authorizationService.hasAuthorization(authorizationHeader, "READ_MOVIE", "MOVIE")) {
            // Process request for authenticated user
            return ResponseEntity.ok(movieService.findAll());
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @PostMapping
    public ResponseEntity<MovieDto> addMovie(@RequestHeader("Authorization") String authorizationHeader, @RequestBody MovieDto movieDto) {
        if ( authorizationService.hasAuthorization(authorizationHeader, "CREATE_MOVIE", "MOVIE")) {
            MovieDto addedMovieDto = movieService.addMovie(movieDto);
            return ResponseEntity.created(URI.create("/movies/" + addedMovieDto.getId())).body(addedMovieDto);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }

}
