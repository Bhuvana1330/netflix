package com.edukators.netflix.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Content {
    private Long id;
    private String title;
    private String description;
    private String type;
    private String language;
    private Double rating;
    private String image;
    private int releaseDate;
    private String trailerUrl;
    private String videoUrl;

}
