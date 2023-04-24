package org.online.movies.service;

import org.online.movies.model.Permission;
import org.online.movies.model.Resource;
import org.online.movies.model.Role;
import org.online.movies.model.User;

public interface AuthorizationService {
    boolean hasPermission(User user, Permission permission, Resource resource);

    boolean hasPermission(String userName, String permissionName, String resourceName);
    boolean hasRole(User user, Role role);
}
