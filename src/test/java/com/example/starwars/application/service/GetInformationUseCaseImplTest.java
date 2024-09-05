package com.example.starwars.application.service;

import com.example.starwars.domain.Model.Information;
import com.example.starwars.domain.Repository.GetInformationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetInformationUseCaseImplTest {

    @InjectMocks
    GetInformationUseCaseImpl underTest;

    @Mock
    GetInformationRepository getInformationRepository;

    @Test
    void getInformation() {
        //Arrange
        String name = "Luke Skywalker";
        Information expectedInformation = Information.builder()
                .name("Luke Skywalker")
                .birthYear("19BBY")
                .gender("male")
                .planetName("Tatooine")
                .fastestVehicleDriven("X-34 landspeeder")
                .films(List.of())
                .build();
        when(getInformationRepository.getInformation(name)).thenReturn(expectedInformation);

        //Act
        Information result = underTest.getInformation(name);

        //Assert
        assertNotNull(result);
        assertEquals(expectedInformation.getName(), result.getName());
        assertEquals(expectedInformation.getBirthYear(), result.getBirthYear());
        assertEquals(expectedInformation.getGender(), result.getGender());
        assertEquals(expectedInformation.getPlanetName(), result.getPlanetName());
        assertEquals(expectedInformation.getFastestVehicleDriven(), result.getFastestVehicleDriven());
        assertEquals(expectedInformation.getFilms(), result.getFilms());

        verify(getInformationRepository).getInformation(name);

    }
}
