package org.online.movies.persistence;

import org.online.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    int countByTitle(String title);

    @Query("SELECT m FROM Movie m WHERE m.title = :title")
    Movie findByTitle(String title);

}
