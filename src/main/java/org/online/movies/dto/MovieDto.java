package org.online.movies.dto;

import lombok.Data;

@Data
public class MovieDto {
    private Long id;
    private String title;
    private String genre;
    private int year;
}
