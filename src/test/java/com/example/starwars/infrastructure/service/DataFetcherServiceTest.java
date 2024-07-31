package com.example.starwars.infrastructure.service;

import com.example.starwars.domain.Repository.ApiService;
import com.example.starwars.infrastructure.entity.PersonInformation;
import com.example.starwars.infrastructure.entity.PersonInformationResponse;
import com.example.starwars.infrastructure.entity.PlanetInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class DataFetcherServiceTest {

    @Mock
    private ApiService apiService;

    @InjectMocks
    private DataFetcherService dataFetcherService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFetchPersonInformationFound() {
        // Arrange
        String personName = "Luke Skywalker";
        PersonInformation personInformation = PersonInformation.builder()
                .name(personName)
                .build();

        PersonInformationResponse response = PersonInformationResponse.builder()
                .results(List.of(personInformation))
                .build();

        when(apiService.fetchObject("https://swapi.trileuco.com/api/people/?page=1", PersonInformationResponse.class))
                .thenReturn(response);

        // Act
        PersonInformation result = dataFetcherService.fetchPersonInformation(personName);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo(personName);
    }

    @Test
    void testFetchPersonInformationNotFound() {
        // Arrange
        String personName = "Unknown Person";

        PersonInformationResponse response = PersonInformationResponse.builder()
                .results(Collections.emptyList())
                .build();

        when(apiService.fetchObject("https://swapi.trileuco.com/api/people/?page=1", PersonInformationResponse.class))
                .thenReturn(response);

        // Act & Assert
        assertThrows(RuntimeException.class, () -> dataFetcherService.fetchPersonInformation(personName));
    }

    @Test
    void testFetchPlanet() {
        // Arrange
        String planetUrl = "https://swapi.trileuco.com/api/planets/1/";
        PlanetInformation planetInformation = PlanetInformation.builder()
                .name("Tatooine")
                .climate("Arid")
                .terrain("Desert")
                .population("200000")
                .build();

        when(apiService.fetchObject(planetUrl, PlanetInformation.class))
                .thenReturn(planetInformation);

        // Act
        PlanetInformation result = dataFetcherService.fetchPlanet(planetUrl);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo("Tatooine");
        assertThat(result.getClimate()).isEqualTo("Arid");
        assertThat(result.getTerrain()).isEqualTo("Desert");
        assertThat(result.getPopulation()).isEqualTo("200000");
    }
}