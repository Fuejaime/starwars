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

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InformationControllerTest {

    @InjectMocks
    //InformationController underTest;

    @Mock
    GetInformationUseCase getInformationUseCase;

    @Mock
    InformationToGetPersonInfoMapper informationToGetPersonInfoMapper;

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

        GetPersonInfo200Response response = new GetPersonInfo200Response();
        response.setName(name);
        response.setBirthYear("19BBY");
        response.setGender("male");
        response.setPlanetName("Tatooine");
        response.setFastestVehicleDriven("Speeder");
        response.setFilms(List.of());

        when(getInformationUseCase.getInformation(name)).thenReturn(information);
        when(informationToGetPersonInfoMapper.informationToPersonInfoResponse(information)).thenReturn(response);

        //Act
        //GetPersonInfo200Response result = underTest.getPersonInfo(name).getBody();

        //Assert
        /*assert result != null;
        assertEquals(information.getName(), result.getName());
        assertEquals(information.getBirth_year(), result.getBirthYear());
        assertEquals(information.getGender(), result.getGender());
        assertEquals(information.getPlanet_name(), result.getPlanetName());
        assertEquals(information.getFastest_vehicle_driven(), result.getFastestVehicleDriven());
        assertEquals(information.getFilms(), result.getFilms());
*/
    }
}
