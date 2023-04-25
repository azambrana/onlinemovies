package org.online.movies.service;

import org.online.movies.model.Role;
import org.online.movies.persistence.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role getRoleByName(String roleName) {
        return roleRepository.findByName(roleName);
    }
}
