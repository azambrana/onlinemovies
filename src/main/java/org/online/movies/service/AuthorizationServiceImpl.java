package org.online.movies.service;

import org.online.movies.model.Permission;
import org.online.movies.model.Resource;
import org.online.movies.model.Role;
import org.online.movies.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.net.ftp.FtpDirEntry;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {
    @Autowired
    private UserService userService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private ResourceService resourceService;

    @Override
    public boolean hasPermission(User user, Permission permission, Resource resource) {
        return user.getRoles().stream().anyMatch(
                role -> role.getPermissions().stream().anyMatch(
                        permission1 -> permission1.equals(permission) && permission1.getResources().stream().anyMatch(
                                resource1 -> resource1.equals(resource)
                        )
                )
        );
    }

    @Override
    public boolean hasPermission(String userName, String permissionName, String resourceName) {
        User user = userService.getUserByUsername(userName);
        Permission permission = permissionService.getPermissionByName(permissionName);
        Resource resource = resourceService.getResourceByName(resourceName);

        if (user != null && permission != null && resource != null) {
            return hasPermission(user, permission, resource);
        }

        return false;
    }

    @Override
    public boolean hasRole(User user, Role role) {
        return false;
    }

    @Override
    public User findUserByToken(String token) {
        return userService.getUserByToken(token);
    }

    @Override
    public boolean hasAuthorization(String authorizationHeader, String permissionName, String resourceName) {
        String[] parts = authorizationHeader.split(" ");
        String token = parts[1];
        // Validate token and authorize user
        User user = this.findUserByToken(token); // Implement token validation logic

        if (user == null) {
            return false;
        }

        return this.hasPermission(user, permissionService.getPermissionByName(permissionName), resourceService.getResourceByName(resourceName));
    }
}
