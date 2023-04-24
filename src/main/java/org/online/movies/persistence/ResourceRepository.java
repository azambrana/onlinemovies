package org.online.movies.persistence;

import org.online.movies.model.Permission;
import org.online.movies.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository  extends JpaRepository<Resource, Long> {
    Resource findByName(String resourceName);
}
