package org.online.movies.dto;

import lombok.Data;

@Data
public class TvShowDto extends Media {
    private int seasons;
    private int episodes;
}
