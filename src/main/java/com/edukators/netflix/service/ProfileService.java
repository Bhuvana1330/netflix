package com.edukators.netflix.service;
import com.edukators.netflix.model.Profile;
import com.edukators.netflix.service.ProfileService;

import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ProfileService {
    private final List<Profile> profiles = new ArrayList<>();

    // Retrieve all profiles
    public List<Profile> getAllProfiles() {
        return new ArrayList<>(profiles); // Return a copy to avoid external modifications
    }

    // Retrieve a profile by ID
    public Profile getProfileById(String id) {
        return profiles.stream()
                .filter(profile -> profile.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Profile not found with ID: " + id));
    }

    // Add a new profile
    public void addProfile(Profile profile) {
        if (profiles.stream().anyMatch(existingProfile -> existingProfile.getId().equals(profile.getId()))) {
            throw new IllegalArgumentException("Profile with ID " + profile.getId() + " already exists");
        }
        profiles.add(profile);
    }

    // Update an existing profile
    public void updateProfile(String id, Profile updatedProfile) {
        Profile existingProfile = getProfileById(id); // Will throw if profile doesn't exist
        existingProfile.setName(updatedProfile.getName() != null ? updatedProfile.getName() : existingProfile.getName());
        existingProfile.setAvatarUrl(updatedProfile.getAvatarUrl() != null ? updatedProfile.getAvatarUrl() : existingProfile.getAvatarUrl());
        existingProfile.setIsKidProfile(updatedProfile.getIsKidProfile() != null ? updatedProfile.getIsKidProfile() : existingProfile.getIsKidProfile());
        existingProfile.setUserId(updatedProfile.getUserId() != null ? updatedProfile.getUserId() : existingProfile.getUserId());
    }

    // Delete a profile by ID
    public void deleteProfile(String id) {
        Profile profile = getProfileById(id); // Will throw if profile doesn't exist
        profiles.remove(profile);
    }
}
