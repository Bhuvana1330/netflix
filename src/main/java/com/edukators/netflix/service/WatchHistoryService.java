package com.edukators.netflix.service;

import com.edukators.netflix.model.WatchHistory;
import com.edukators.netflix.service.WatchHistoryService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class WatchHistoryService {
    private final List<WatchHistory> watchHistories = new ArrayList<>();

    // Retrieve all watch histories
    public List<WatchHistory> getAllWatchHistories() {
        return new ArrayList<>(watchHistories); // Return a copy to avoid external modifications
    }

    // Retrieve watch history by ID
    public WatchHistory getWatchHistoryById(String id) {
        return watchHistories.stream()
                .filter(history -> history.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("WatchHistory not found with ID: " + id));
    }

    // Retrieve watch history by profile ID
    public List<WatchHistory> getWatchHistoryByProfileId(String profileId) {
        return watchHistories.stream()
                .filter(history -> history.getProfileId().equals(profileId))
                .toList();
    }

    // Add a new watch history record
    public void addWatchHistory(WatchHistory watchHistory) {
        if (watchHistories.stream().anyMatch(existingHistory -> existingHistory.getId().equals(watchHistory.getId()))) {
            throw new IllegalArgumentException("WatchHistory with ID " + watchHistory.getId() + " already exists");
        }
        watchHistories.add(watchHistory);
    }

    // Update an existing watch history record
    public void updateWatchHistory(String id, WatchHistory updatedHistory) {
        WatchHistory existingHistory = getWatchHistoryById(id); // Will throw if watch history doesn't exist
        existingHistory.setProfileId(updatedHistory.getProfileId() != null ? updatedHistory.getProfileId() : existingHistory.getProfileId());
        existingHistory.setContentId(updatedHistory.getContentId() > 0 ? updatedHistory.getContentId() : existingHistory.getContentId());
        existingHistory.setLastWatched(updatedHistory.getLastWatched() != null ? updatedHistory.getLastWatched() : existingHistory.getLastWatched());
        existingHistory.setProgress(updatedHistory.getProgress() != null ? updatedHistory.getProgress() : existingHistory.getProgress());
    }

    // Delete a watch history record by ID
    public void deleteWatchHistory(String id) {
        WatchHistory history = getWatchHistoryById(id); // Will throw if watch history doesn't exist
        watchHistories.remove(history);
    }
}
