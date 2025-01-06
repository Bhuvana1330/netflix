package com.edukators.netflix.service;

import com.edukators.netflix.model.Genre;
import com.edukators.netflix.service.GenreService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
public class GenreService {
    private final List<Genre> genres = new ArrayList<>();

    // Retrieve all genres
    public List<Genre> getAllGenres() {
        return new ArrayList<>(genres); // Return a copy to avoid external modifications
    }

    // Retrieve genre by ID
    public Genre getGenreById(Long id) {
        return genres.stream()
                .filter(genre -> genre.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Genre not found with ID: " + id));
    }

    // Add a new genre
    public void addGenre(Genre genre) {
        if (genres.stream().anyMatch(existingGenre -> existingGenre.getId().equals(genre.getId()))) {
            throw new IllegalArgumentException("Genre with ID " + genre.getId() + " already exists");
        }
        genres.add(genre);
    }

    // Update an existing genre
    public void updateGenre(Long id, Genre updatedGenre) {
        Genre existingGenre = getGenreById(id); // Will throw if genre doesn't exist
        existingGenre.setName(updatedGenre.getName() != null ? updatedGenre.getName() : existingGenre.getName());
    }

    // Delete a genre by ID
    public void deleteGenre(Long id) {
        Genre genre = getGenreById(id); // Will throw if genre doesn't exist
        genres.remove(genre);
    }

}
