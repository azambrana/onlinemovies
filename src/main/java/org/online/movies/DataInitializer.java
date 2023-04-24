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

        Permission permission = new Permission(1L, "CREATE", Collections.singleton(userResource));
        permissionRepository.save(permission);

        Role anonymousRole = new Role();
        anonymousRole.setId(1L);
        anonymousRole.setName("ROLE_ANONYMOUS");
        anonymousRole.setPermissions(Collections.singleton(permission));

        Role savedRole = roleRepository.save(anonymousRole);

        User anonymousUser = new User();
        anonymousUser.setUsername("anonymous");
        anonymousUser.setPassword("anonymous");
        anonymousUser.setFirstName("Anonymous");
        anonymousUser.setLastName("Anonymous");
        anonymousUser.setEmail("anonymous@gmail.com");

        // update the user with the role
        User savedUser = userRepository.save(anonymousUser);
        savedUser.setRoles(Collections.singleton(savedRole));

        userRepository.save(savedUser);
    }
}
