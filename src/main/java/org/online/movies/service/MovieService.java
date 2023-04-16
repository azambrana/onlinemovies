package org.online.movies.service;

import org.modelmapper.ModelMapper;
import org.online.movies.dto.MovieDto;
import org.online.movies.model.Movie;
import org.online.movies.persistence.MovieRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ModelMapper modelMapper;

    public MovieDto addMovie(MovieDto movieDto) {
        Movie movieEntity = new Movie();
        BeanUtils.copyProperties(movieDto, movieEntity);
        Movie savedMovieEntity = movieRepository.save(movieEntity);
        MovieDto savedMovieDto = new MovieDto();
        BeanUtils.copyProperties(savedMovieEntity, savedMovieDto);

        return savedMovieDto;
    }

    public List<MovieDto> findAll() {
        List<Movie> allMovies = movieRepository.findAll();
        return allMovies.stream().map(movie -> modelMapper.map(movie, MovieDto.class)).collect(Collectors.toList());
    }
}
