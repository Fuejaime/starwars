package com.example.starwars.infrastructure.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlanetInformation {
        private String name;
        private String climate;
        private String terrain;
        private String population;
}

