package org.online.movies;

import org.modelmapper.ModelMapper;
import org.online.movies.model.Permission;
import org.online.movies.model.Resource;
import org.online.movies.persistence.ResourceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}