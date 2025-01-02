package com.edukators.netflix.controller;

import com.edukators.netflix.model.Content;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Content")
public class ContentController {


    @PostMapping
    public Content createContent(@RequestBody Content content) {
        return content;
    }


    @GetMapping("/{id}")
    public Content getContent(@PathVariable String id) {
        return new Content();
    }


    @GetMapping
    public List<Content> getAllContent() {
        return List.of(new Content());
    }

    @PutMapping("/{id}")
    public Content updateContent(@PathVariable String id, @RequestBody Content content) {
        return content;
    }

    @DeleteMapping("/{id}")
    public void deleteSubscription(@PathVariable String id) {
        // Logic for deletion can be added here
    }
}