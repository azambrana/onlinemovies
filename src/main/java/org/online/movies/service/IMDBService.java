package org.online.movies.service;

public interface IMDBService {
    int getEpisodes(String title);

    int getSeasons(String title);
}
