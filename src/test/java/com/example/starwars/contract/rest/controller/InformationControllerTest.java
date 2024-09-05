package com.example.starwars.contract.rest.controller;

import com.example.starwars.application.usecase.GetInformationUseCase;
import com.example.starwars.contract.rest.mapper.InformationToGetPersonInfoMapper;
import com.example.starwars.domain.Model.Information;
import com.example.starwars.model.GetPersonInfo200Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InformationControllerTest {

    @InjectMocks
    InformationController underTest;

    @Mock
    GetInformationUseCase getInformationUseCase;

    @Mock
    InformationToGetPersonInfoMapper informationToGetPersonInfoMapper;

    @Test
    void testGetPersonInfo() {
        // Arrange
        String name = "Luke Skywalker";
        var information =  Information.builder()
                .name("Luke Skywalker")
                .birthYear("19BBY")
                .gender("male")
                .planetName("Tatooine")
                .fastestVehicleDriven("X-34 landspeeder")
                .films(List.of())
                .build();

        var response = new GetPersonInfo200Response(); // Create a valid response object
        when(getInformationUseCase.getInformation(name)).thenReturn((information));
        when(informationToGetPersonInfoMapper.informationToPersonInfoResponse(information)).thenReturn(response);

        // Act
        ResponseEntity<GetPersonInfo200Response> result = underTest.getPersonInfo(name);

        // Assert
        assertEquals(ResponseEntity.ok(response), result);
        verify(getInformationUseCase).getInformation(name);
        verify(informationToGetPersonInfoMapper).informationToPersonInfoResponse(information);
    }
}
