package com.edukators.netflix.controller;

import com.edukators.netflix.model.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Profile")
public class ProfileController {


    @PostMapping
    public Profile createProfile(@RequestBody Profile profile) {
        return profile;
    }

    @GetMapping("/{id}")
    public Profile getProfile(@PathVariable String id) {
        return new Profile();
    }

    @GetMapping
    public List<Profile> getAllProfile() {
        return List.of(new Profile());
    }

    @PutMapping("/{id}")
    public Profile updateProfile(@PathVariable String id, @RequestBody Profile profile) {
        return profile;
    }

    @DeleteMapping("/{id}")
    public void deleteProfile(@PathVariable String id) {
        // Logic for deletion can be added here
    }
}