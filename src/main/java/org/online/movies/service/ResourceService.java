package org.online.movies.service;

import org.online.movies.model.Resource;

public interface ResourceService {
    Resource getResourceByName(String resourceName);
}
