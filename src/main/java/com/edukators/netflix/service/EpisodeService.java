package com.edukators.netflix.service;

import com.edukators.netflix.model.Episode;
import com.edukators.netflix.service.EpisodeService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class EpisodeService {
    private final List<Episode> episodes = new ArrayList<>();

    // Retrieve all episodes
    public List<Episode> getAllEpisodes() {
        return new ArrayList<>(episodes); // Return a copy to avoid external modifications
    }

    // Retrieve episode by ID
    public Episode getEpisodeById(String id) {
        return episodes.stream()
                .filter(episode -> episode.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Episode not found with ID: " + id));
    }

    // Retrieve episodes by season ID
    public List<Episode> getEpisodesBySeasonId(String seasonId) {
        return episodes.stream()
                .filter(episode -> episode.getSeasonId().equals(seasonId))
                .toList();
    }

    // Add a new episode
    public void addEpisode(Episode episode) {
        if (episodes.stream().anyMatch(existingEpisode -> existingEpisode.getId().equals(episode.getId()))) {
            throw new IllegalArgumentException("Episode with ID " + episode.getId() + " already exists");
        }
        episodes.add(episode);
    }

    // Update an existing episode
    public void updateEpisode(String id, Episode updatedEpisode) {
        Episode existingEpisode = getEpisodeById(id); // Will throw if episode doesn't exist
        existingEpisode.setTitle(updatedEpisode.getTitle() != null ? updatedEpisode.getTitle() : existingEpisode.getTitle());
        existingEpisode.setSeasonId(updatedEpisode.getSeasonId() != null ? updatedEpisode.getSeasonId() : existingEpisode.getSeasonId());
        existingEpisode.setDuration(updatedEpisode.getDuration() > 0 ? updatedEpisode.getDuration() : existingEpisode.getDuration());
        existingEpisode.setEpisodeNumber(updatedEpisode.getEpisodeNumber() > 0 ? updatedEpisode.getEpisodeNumber() : existingEpisode.getEpisodeNumber());
        existingEpisode.setReleaseDate(updatedEpisode.getReleaseDate() != null ? updatedEpisode.getReleaseDate() : existingEpisode.getReleaseDate());
        existingEpisode.setDescription(updatedEpisode.getDescription() != null ? updatedEpisode.getDescription() : existingEpisode.getDescription());
    }

    // Delete an episode by ID
    public void deleteEpisode(String id) {
        Episode episode = getEpisodeById(id); // Will throw if episode doesn't exist
        episodes.remove(episode);
    }
}
