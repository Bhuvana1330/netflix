package com.edukators.netflix.controller;

import com.edukators.netflix.model.Genre;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Genre")
public class GenreController {

    @PostMapping
    public Genre createGenre(@RequestBody Genre genre) {
        return genre;
    }

    @GetMapping("/{id}")
    public Genre getGenre(@PathVariable String id) {
        return new Genre();
    }

    @GetMapping
    public List<Genre> getAllGenre() {
        return List.of(new Genre());
    }

    @PutMapping("/{id}")
    public Genre updateGenre(@PathVariable String id, @RequestBody Genre genre) {
        return genre;
    }

    @DeleteMapping("/{id}")
    public void deleteGenre(@PathVariable String id) {
    }
}