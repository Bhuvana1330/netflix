package com.edukators.netflix.controller;

import com.edukators.netflix.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @PostMapping
    public User createUser(@RequestBody User user) {
        return user;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        return new User();
    }

    @GetMapping
    public List<User> getAllUsers() {
        return List.of(new User());
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user) {
        return user;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        // Add logic to delete the user by ID
    }
}
