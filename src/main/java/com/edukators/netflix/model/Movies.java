package com.edukators.netflix.model;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class Movies  {
    private String id;
    private String name;
    private String genre;
    private String director;
    private String description;
    private int releaseDate;
    private double imdbRating;
    private List<String> language;
    private int duration;
    private String ageCategory;
    private List<String> cast;
}
