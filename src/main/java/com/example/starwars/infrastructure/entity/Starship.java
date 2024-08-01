package com.example.starwars.infrastructure.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Starship {
    private String name;
    private String model;
    private String manufacturer;
    private String costInCredits;
    private String length;
    private String maxAtmospheringSpeed;
    private String crew;
    private String passengers;
    private String cargoCapacity;
    private String consumables;
    private String hyperdriveRating;
    private String MGLT;
    private String starshipClass;
    private String created;
    private String edited;
    private String url;
}
