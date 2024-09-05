package com.example.starwars.infrastructure.service;

import com.example.starwars.domain.Repository.ApiService;
import com.example.starwars.infrastructure.entity.Vehicle;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SpeedCalculatorServiceTest {

    @Mock
    private ApiService apiService;

    @InjectMocks
    private SpeedCalculatorService speedCalculatorService;

    public SpeedCalculatorServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetMaxSpeed() {
        // Arrange
        Vehicle vehicle1 = Vehicle.builder().name("Speeder").maxAtmospheringSpeed("120").build();
        Vehicle vehicle2 = Vehicle.builder().name("Starship").maxAtmospheringSpeed("500").build();
        Vehicle vehicle3 = Vehicle.builder().name("Podracer").maxAtmospheringSpeed("800").build();

        List<String> urls = Arrays.asList("url1", "url2", "url3");

        when(apiService.fetchObject("url1", Vehicle.class)).thenReturn(vehicle1);
        when(apiService.fetchObject("url2", Vehicle.class)).thenReturn(vehicle2);
        when(apiService.fetchObject("url3", Vehicle.class)).thenReturn(vehicle3);

        Function<Vehicle, Integer> speedExtractor = vehicle -> Integer.parseInt(vehicle.getMaxAtmospheringSpeed());

        // Act
        Integer maxSpeed = speedCalculatorService.getMaxSpeed(urls, Vehicle.class, speedExtractor);

        // Assert
        assertEquals(800, maxSpeed);
    }

    @Test
    void testGetFastestName() {
        // Arrange
        Vehicle vehicle1 = Vehicle.builder().name("Speeder").maxAtmospheringSpeed("120").build();
        Vehicle vehicle2 = Vehicle.builder().name("Starship").maxAtmospheringSpeed("500").build();
        Vehicle vehicle3 = Vehicle.builder().name("Racer").maxAtmospheringSpeed("800").build();

        List<String> urls = Arrays.asList("url1", "url2", "url3");

        when(apiService.fetchObject("url1", Vehicle.class)).thenReturn(vehicle1);
        when(apiService.fetchObject("url2", Vehicle.class)).thenReturn(vehicle2);
        when(apiService.fetchObject("url3", Vehicle.class)).thenReturn(vehicle3);

        Function<Vehicle, Integer> speedExtractor = vehicle -> Integer.parseInt(vehicle.getMaxAtmospheringSpeed());
        Function<Vehicle, String> nameExtractor = Vehicle::getName;

        // Act
        String fastestName = speedCalculatorService.getFastestName(urls, Vehicle.class, 800, speedExtractor, nameExtractor);

        // Assert
        assertEquals("Racer", fastestName);
    }
}
