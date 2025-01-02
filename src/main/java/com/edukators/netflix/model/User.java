package com.edukators.netflix.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private String subscriptionPlan;
    private Boolean isActive;
    private LocalDateTime expiryDate;
}
