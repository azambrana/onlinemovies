package org.online.movies;

import org.online.movies.model.Permission;
import org.online.movies.model.Resource;
import org.online.movies.model.Role;
import org.online.movies.persistence.RoleRepository;
import org.online.movies.model.User;
import org.online.movies.persistence.PermissionRepository;
import org.online.movies.persistence.ResourceRepository;
import org.online.movies.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitializer {
    @Autowired
    ResourceRepository resourceRepository;

    @Autowired
    PermissionRepository permissionRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void initData() {
        Resource userResource = new Resource(1L, "USER");
        resourceRepository.save(userResource);
        Resource movieResource = new Resource(2L, "MOVIE");
        resourceRepository.save(movieResource);

        Permission createUserPermission = new Permission(1L, "CREATE_USER", Collections.singleton(userResource));
        Permission readMoviePermission = new Permission(2L, "READ_MOVIE", Collections.singleton(movieResource));
        Permission createMoviePermission = new Permission(3L, "CREATE_MOVIE", Collections.singleton(movieResource));
        permissionRepository.save(readMoviePermission);
        permissionRepository.save(createMoviePermission);

        Role anonymousRole = new Role();
        anonymousRole.setId(1L);
        anonymousRole.setName("ROLE_ANONYMOUS");
        anonymousRole.setPermissions(Collections.singleton(createUserPermission));

        Role userRole = new Role();
        userRole.setId(2L);
        userRole.setName("ROLE_USER");

        Set<Permission> permissionSet = new HashSet<>();
        permissionSet.add(readMoviePermission);
        permissionSet.add(createMoviePermission);

        userRole.setPermissions(permissionSet);

        Role savedAnonymousRole = roleRepository.save(anonymousRole);
        Role savedUserRole = roleRepository.save(userRole);

        User anonymousUser = new User();
        anonymousUser.setUsername("anonymous");
        anonymousUser.setPassword("anonymous");
        anonymousUser.setFirstName("Anonymous");
        anonymousUser.setLastName("Anonymous");
        anonymousUser.setEmail("anonymous@gmail.com");

        // update the user with the role
        User savedUser = userRepository.save(anonymousUser);
        savedUser.setRoles(Collections.singleton(savedAnonymousRole));

        userRepository.save(savedUser);
    }
}
