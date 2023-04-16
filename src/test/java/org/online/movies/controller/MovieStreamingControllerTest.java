package org.online.movies.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.online.movies.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class MovieStreamingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllMovies() throws Exception {
        mockMvc.perform(get("/movies"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
    }

    @Test
    public void testAddMovie() throws Exception {
        // create a Movie object and add it to the repository and then test the POST method for the movies endpoint
        Movie movie = new Movie("Avengers", "Action", 2012);
        mockMvc.perform(post("/movies")
                .contentType("application/json")
                .content("{ \"title\": \"Avengers\", \"genre\": \"Action\", \"year\": 2012 }"))
                .andExpect(status().isOk());
    }
}
