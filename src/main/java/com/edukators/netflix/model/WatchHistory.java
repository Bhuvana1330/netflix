package com.edukators.netflix.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class WatchHistory {
    private String id;
    private String profileId;
    private int contentId;
    private LocalDateTime lastWatched;
    private Double progress;
}
