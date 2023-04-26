package org.online.movies.service;

import org.online.movies.dto.TvShowDto;
import org.online.movies.model.TvShow;
import org.online.movies.persistence.TvShowRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TvShowServiceImpl implements TvShowService {

    @Autowired
    private IMDBService imdbServiceStub;

    @Autowired
    private TvShowRepository tvShowRepository;

    @Override
    public TvShowDto addTvShow(TvShowDto tvShowDto) { // DTO = Data Transfer Object
        tvShowDto.setSeasons(imdbServiceStub.getSeasons(tvShowDto.getTitle()));
        tvShowDto.setEpisodes(imdbServiceStub.getEpisodes(tvShowDto.getTitle()));
        TvShow tvShow = new TvShow();
        BeanUtils.copyProperties(tvShowDto, tvShow);
        tvShowRepository.save(tvShow);

        return tvShowDto;
    }
}
