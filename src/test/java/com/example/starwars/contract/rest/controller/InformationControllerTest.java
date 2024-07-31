package com.example.starwars.contract.rest.controller;

import com.example.starwars.application.usecase.GetInformationUseCase;
import com.example.starwars.domain.Model.Information;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InformationControllerTest {

    @InjectMocks
    InformationController underTest;

    @Mock
    GetInformationUseCase getInformationUseCase;

    @Test
    void getInfo() {
        // Arrange
        String name = "Luke Skywalker";
        Information information = Information.builder()
                .name(name)
                .birth_year("19BBY")
                .gender("male")
                .planet_name("Tatooine")
                .fastest_vehicle_driven("Speeder")
                .films(List.of()) // Puedes agregar films si es necesario
                .build();

        when(getInformationUseCase.getInformation(name)).thenReturn(information);

        //Act
        Information result = underTest.getInfo(name);

        //Assert
        assertEquals(information.getName(), result.getName());
        assertEquals(information.getBirth_year(), result.getBirth_year());
        assertEquals(information.getGender(), result.getGender());
        assertEquals(information.getPlanet_name(), result.getPlanet_name());
        assertEquals(information.getFastest_vehicle_driven(), result.getFastest_vehicle_driven());
        assertEquals(information.getFilms(), result.getFilms());
    }
}
