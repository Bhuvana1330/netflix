package com.edukators.netflix.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Profile {
    private String id;
    private String name;
    private String avatarUrl;
    private Boolean isKidProfile;
    private String userId;
}
