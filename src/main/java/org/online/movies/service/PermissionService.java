package org.online.movies.service;

import org.online.movies.model.Permission;

public interface PermissionService {
    Permission getPermissionByName(String permissionName);
}
