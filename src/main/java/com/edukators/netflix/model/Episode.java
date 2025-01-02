package com.edukators.netflix.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Episode   {

    private String id;
    private String seasonId; // Reference to Season
    private String title;
    private int duration;
    private int episodeNumber;
    private String releaseDate;
    private String description;
}
