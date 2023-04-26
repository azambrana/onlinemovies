package org.online.movies.service;

import org.springframework.stereotype.Service;

@Service
public class IMDBServiceStub implements IMDBService {
    @Override
    public int getEpisodes(String title) {
        return 24;
    }

    @Override
    public int getSeasons(String title) {
        return 2;
    }
}
