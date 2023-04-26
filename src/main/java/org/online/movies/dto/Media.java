package org.online.movies.dto;

import lombok.Data;

@Data
public class Media {
    private Long id;
    private String title;
    private String genre;
    private int year;
}
