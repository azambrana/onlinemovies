package org.online.movies.controller;

import org.online.movies.dto.TvShowDto;
import org.online.movies.service.AuthorizationService;
import org.online.movies.service.TvShowService;
import org.online.movies.service.TvShowServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/tvshows")
public class TvShowController {

    @Autowired
    private TvShowService tvShowService;

    @Autowired
    private AuthorizationService authorizationService;
    @PostMapping
    private ResponseEntity<TvShowDto> addTvShow(@RequestHeader("Authorization") String authorizationHeader, @RequestBody TvShowDto tvShowDto) {
        /**
         if ( authorizationService.hasAuthorization(authorizationHeader, "CREATE_TVSHOW", "TVSHOW")) {
                    TvShowDto addedTvShowDto = tvShowService.addTvShow(tvShowDto);
                    return ResponseEntity.created(URI.create("/tvshows/" + addedTvShowDto.getId())).body(addedTvShowDto);
                }
        */
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }
}
