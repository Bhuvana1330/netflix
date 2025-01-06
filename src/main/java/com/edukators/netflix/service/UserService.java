package com.edukators.netflix.service;
import com.edukators.netflix.model.User;
import com.edukators.netflix.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final List<User> users = new ArrayList<>();

    public List<User>   getAllUsers() {
        return users;
    }
    public User getUserById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
    public void addUser(User user) {
        users.add(user);
    }
}
