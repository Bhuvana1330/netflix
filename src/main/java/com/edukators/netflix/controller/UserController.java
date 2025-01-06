package com.edukators.netflix.controller;

import com.edukators.netflix.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Getter
@Setter
@Builder

@RestController
@RequestMapping("/api/users")
public class UserController {

    @PostMapping
    public User createUser(@RequestBody User user) {
        return user;
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
