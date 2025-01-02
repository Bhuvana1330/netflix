package com.edukators.netflix.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class subscription {
    private String id;
    private String planName;
    private String planDescription;
    private Double price;
    private int maxProfile;
    private Boolean supportsHD;
    private Boolean supportsUHD;
}
