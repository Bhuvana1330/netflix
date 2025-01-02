package com.edukators.netflix.controller;

import com.edukators.netflix.model.WatchHistory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/watch-history")
public class WatchHistoryController {

    @PostMapping
    public WatchHistory createWatchHistory(@RequestBody WatchHistory watchHistory) {
        return watchHistory;
    }

    @GetMapping("/{id}")
    public WatchHistory getWatchHistory(@PathVariable String id) {
        return new WatchHistory();
    }

    @GetMapping
    public List<WatchHistory> getAllWatchHistory() {
        return List.of(new WatchHistory());
    }

    @PutMapping("/{id}")
    public WatchHistory updateWatchHistory(@PathVariable String id, @RequestBody WatchHistory watchHistory) {
        return watchHistory;
    }

    @DeleteMapping("/{id}")
    public void deleteWatchHistory(@PathVariable String id) {
        // Logic for deletion can be added here
    }
}
