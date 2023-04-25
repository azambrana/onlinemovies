package org.online.movies.persistence;

import org.online.movies.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.username = ?1")
    User findByUsername(String userName);

    @Query("select u from User u where u.token = ?1")
    User findByToken(String token);
}
