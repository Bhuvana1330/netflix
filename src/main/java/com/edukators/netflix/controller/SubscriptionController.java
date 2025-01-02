package com.edukators.netflix.controller;

import com.edukators.netflix.model.subscription;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    @PostMapping
    public subscription createSubscription(@RequestBody subscription subscription) {
        return subscription;
    }

    @GetMapping("/{id}")
    public subscription getSubscription(@PathVariable String id) {
        return new subscription();
    }

    @GetMapping
    public List<subscription> getAllSubscriptions() {
        return List.of(new subscription());
    }

    @PutMapping("/{id}")
    public subscription updateSubscription(@PathVariable String id, @RequestBody subscription subscription) {
        return subscription;
    }

    @DeleteMapping("/{id}")
    public void deleteSubscription(@PathVariable String id) {
    }
}