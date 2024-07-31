package com.example.starwars.infrastructure.adapter.Model;

import lombok.Data;

@Data
public class Vehicle {
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
    private String vehicleClass;
    private String created;
    private String edited;
    private String url;
}
