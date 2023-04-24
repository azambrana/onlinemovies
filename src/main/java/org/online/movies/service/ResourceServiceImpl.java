package org.online.movies.service;

import org.online.movies.model.Permission;
import org.online.movies.model.Resource;
import org.online.movies.persistence.PermissionRepository;
import org.online.movies.persistence.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public Resource getResourceByName(String resourceName) {
        return resourceRepository.findByName(resourceName);
    }
}
