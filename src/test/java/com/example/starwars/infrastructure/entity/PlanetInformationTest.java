package com.example.starwars.infrastructure.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PlanetInformationTest {
    @Test
    void testPlanetInformationBuilder() {
        // Arrange
        String name = "Tatooine";
        String climate = "Arid";
        String terrain = "Desert";
        String population = "200000";

        // Act
        PlanetInformation planetInfo = PlanetInformation.builder()
                .name(name)
                .climate(climate)
                .terrain(terrain)
                .population(population)
                .build();

        // Assert
        assertThat(planetInfo).isNotNull();
        assertThat(planetInfo.getName()).isEqualTo(name);
        assertThat(planetInfo.getClimate()).isEqualTo(climate);
        assertThat(planetInfo.getTerrain()).isEqualTo(terrain);
        assertThat(planetInfo.getPopulation()).isEqualTo(population);
    }

    @Test
    void testPlanetInformationToString() {
        // Arrange
        PlanetInformation planetInfo = PlanetInformation.builder()
                .name("Tatooine")
                .climate("Arid")
                .terrain("Desert")
                .population("200000")
                .build();

        // Act
        String result = planetInfo.toString();

        // Print for debugging (optional)
        System.out.println("Resulting toString(): " + result);

        // Assert
        // You might need to adjust this based on the actual toString output
        String expectedSubstring = "PlanetInformation(name=Tatooine, climate=Arid, terrain=Desert, population=200000)";
        assertThat(result).contains(expectedSubstring);
    }
}
