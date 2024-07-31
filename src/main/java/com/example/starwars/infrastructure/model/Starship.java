package com.example.starwars.infrastructure.model;

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
    private String max_atmosphering_speed; // Nota el nombre en CamelCase
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
