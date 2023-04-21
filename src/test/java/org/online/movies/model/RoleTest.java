package org.online.movies.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {
    @Test
    public void testIdentityOfRoles() {
        Role role = new Role();
        role.setId(1L);
        role.setName("Admin");

        Role adminRole = new Role(1L, "Admin2", null);

        assertEquals(role, adminRole);
    }

}