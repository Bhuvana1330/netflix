package com.edukators.netflix.controller;

import com.edukators.netflix.model.Movies;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @PostMapping
    public Movies createMovie(@RequestBody Movies movie) {

        return movie;
    }

    @GetMapping("/{id}")
    public Movies getMovie(@PathVariable String id) {

        return new Movies();
    }

    @GetMapping
    public List<Movies> getAllMovies() {
        return List.of(new Movies());
    }

    @PutMapping("/{id}")
    public Movies updateMovie(@PathVariable String id, @RequestBody Movies movie) {
        return movie;
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable String id) {
    }
}