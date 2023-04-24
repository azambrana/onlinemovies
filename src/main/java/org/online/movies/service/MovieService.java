package org.online.movies.service;

import org.online.movies.dto.MovieDto;

import java.util.List;

public interface MovieService {
    MovieDto addMovie(MovieDto movieDto);

    List<MovieDto> findAll();

    boolean movieExists(String title);
}
