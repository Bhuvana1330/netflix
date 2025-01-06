package com.edukators.netflix.service;

import com.edukators.netflix.model.Content;
import com.edukators.netflix.service.ContentService;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;



public class ContentService {
    private final List<Content> contents = new ArrayList<>();

    // Retrieve all content
    public List<Content> getAllContents() {
        return new ArrayList<>(contents); // Return a copy to avoid external modifications
    }

    // Retrieve content by ID
    public Content getContentById(Long id) {
        return contents.stream()
                .filter(content -> content.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Content not found with ID: " + id));
    }

    // Add new content
    public void addContent(Content content) {
        if (contents.stream().anyMatch(existingContent -> existingContent.getId().equals(content.getId()))) {
            throw new IllegalArgumentException("Content with ID " + content.getId() + " already exists");
        }
        contents.add(content);
    }

    // Update existing content
    public void updateContent(Long id, Content updatedContent) {
        Content existingContent = getContentById(id); // Will throw if content doesn't exist
        existingContent.setTitle(updatedContent.getTitle() != null ? updatedContent.getTitle() : existingContent.getTitle());
        existingContent.setDescription(updatedContent.getDescription() != null ? updatedContent.getDescription() : existingContent.getDescription());
        existingContent.setType(updatedContent.getType() != null ? updatedContent.getType() : existingContent.getType());
        existingContent.setLanguage(updatedContent.getLanguage() != null ? updatedContent.getLanguage() : existingContent.getLanguage());
        existingContent.setRating(updatedContent.getRating() != null ? updatedContent.getRating() : existingContent.getRating());
        existingContent.setImage(updatedContent.getImage() != null ? updatedContent.getImage() : existingContent.getImage());
        existingContent.setReleaseDate(updatedContent.getReleaseDate() > 0 ? updatedContent.getReleaseDate() : existingContent.getReleaseDate());
        existingContent.setTrailerUrl(updatedContent.getTrailerUrl() != null ? updatedContent.getTrailerUrl() : existingContent.getTrailerUrl());
        existingContent.setVideoUrl(updatedContent.getVideoUrl() != null ? updatedContent.getVideoUrl() : existingContent.getVideoUrl());
    }

    // Delete content by ID
    public void deleteContent(Long id) {
        Content content = getContentById(id); // Will throw if content doesn't exist
        contents.remove(content);
    }
}
