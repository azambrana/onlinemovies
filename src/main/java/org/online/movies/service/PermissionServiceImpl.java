package org.online.movies.service;

import org.online.movies.model.Permission;
import org.online.movies.persistence.PermissionRepository;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {
    private final PermissionRepository permissionRepository;

    public PermissionServiceImpl(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    @Override
    public Permission getPermissionByName(String permissionName) {
        return permissionRepository.findByName(permissionName);
    }
}
