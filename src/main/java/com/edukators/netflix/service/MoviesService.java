package com.edukators.netflix.service;

import com.edukators.netflix.model.Movies;
import com.edukators.netflix.service.MoviesService;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
@Getter
@Setter
@Builder
public class MoviesService {
    private final List<Movies> movies = new ArrayList<>();

    // Retrieve all movies
    public List<Movies> getAllMovies() {
        return new ArrayList<>(movies); // Return a copy to avoid external modifications
    }

    public Movies getMovieById(String id) {
        return movies.stream()
                .filter(movie -> movie.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Movie not found with ID: " + id));
    }

    public void addMovie(Movies movie) {
        if (movies.stream().anyMatch(existingMovie -> existingMovie.getId().equals(movie.getId()))) {
            throw new IllegalArgumentException("Movie with ID " + movie.getId() + " already exists");
        }
        movies.add(movie);
    }

    public void updateMovie(String id, Movies updatedMovie) {
        Movies existingMovie = getMovieById(id);

        existingMovie.setName(updatedMovie.getName() != null ? updatedMovie.getName() : existingMovie.getName());
        existingMovie.setGenre(updatedMovie.getGenre() != null ? updatedMovie.getGenre() : existingMovie.getGenre());
        existingMovie.setDirector(updatedMovie.getDirector() != null ? updatedMovie.getDirector() : existingMovie.getDirector());
        existingMovie.setDescription(updatedMovie.getDescription() != null ? updatedMovie.getDescription() : existingMovie.getDescription());
        existingMovie.setLanguage(updatedMovie.getLanguage() != null ? updatedMovie.getLanguage() : existingMovie.getLanguage());
        existingMovie.setDuration(updatedMovie.getDuration() > 0 ? updatedMovie.getDuration() : existingMovie.getDuration());
        existingMovie.setAgeCategory(updatedMovie.getAgeCategory() != null ? updatedMovie.getAgeCategory() : existingMovie.getAgeCategory());
        existingMovie.setCast(updatedMovie.getCast() != null ? updatedMovie.getCast() : existingMovie.getCast());

    }

    public void deleteMovie(String id) {
        Movies movie = getMovieById(id); // Will throw if movie doesn't exist
        movies.remove(movie);
    }
}
