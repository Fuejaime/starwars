package com.example.starwars.infrastructure.adapter;

import com.example.starwars.domain.Model.FilmSummary;
import com.example.starwars.domain.Model.Information;
import com.example.starwars.infrastructure.entity.PersonInformation;
import com.example.starwars.infrastructure.entity.PlanetInformation;
import com.example.starwars.infrastructure.entity.Starship;
import com.example.starwars.infrastructure.entity.Vehicle;
import com.example.starwars.infrastructure.service.DataFetcherService;
import com.example.starwars.infrastructure.service.FilmSummaryService;
import com.example.starwars.infrastructure.service.SpeedCalculatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetInformationRepositoryImplTest {

    @InjectMocks
    private GetInformationRepositoryImpl getInformationRepository;


    @Mock
    DataFetcherService dataFetcherService;

    @Mock
    SpeedCalculatorService speedCalculatorService;

    @Mock
    FilmSummaryService filmSummaryService;


    @Test
    void testGetInformation() {
        // Arrange
        String name = "Luke Skywalker";
        String homeworldUrl = "https://swapi.trileuco.com/api/planets/1/";
        List<String> vehicleUrls = List.of("https://swapi.trileuco.com/api/vehicles/8/");
        List<String> starshipUrls = List.of("https://swapi.trileuco.com/api/starships/9/");

        PersonInformation personInfo = PersonInformation.builder()
                .name(name)
                .homeworld(homeworldUrl)
                .vehicles(vehicleUrls)
                .starships(starshipUrls)
                .films(Collections.singletonList("https://swapi.trileuco.com/api/films/1/"))
                .build();

        PlanetInformation planetInfo = PlanetInformation.builder()
                .name("Tatooine")
                .build();

        FilmSummary filmSummary = FilmSummary.builder()
                .name("A New Hope")
                .release_date(LocalDate.parse("1977-05-25"))
                .build();
        String fastestVehicleName = "Speeder";
        String fastestStarshipName = "X-Wing";
        int maxVehicleSpeed = 1200;
        int maxStarshipSpeed = 1500;

        when(dataFetcherService.fetchPersonInformation(name)).thenReturn(personInfo);
        when(dataFetcherService.fetchPlanet(personInfo.getHomeworld())).thenReturn(planetInfo);
        when(filmSummaryService.getFilmSummaries(personInfo.getFilms())).thenReturn(List.of(filmSummary));

        // Capturing and stubbing the getMaxSpeed method
        ArgumentCaptor<List<String>> urlCaptor = ArgumentCaptor.forClass(List.class);
        ArgumentCaptor<Class<?>> classCaptor = ArgumentCaptor.forClass(Class.class);
        ArgumentCaptor<Function> functionCaptor = ArgumentCaptor.forClass(Function.class);

        when(speedCalculatorService.getMaxSpeed(
                urlCaptor.capture(), classCaptor.capture(), functionCaptor.capture()
        )).thenAnswer(invocation -> {
            Function<?, Integer> function = functionCaptor.getValue();
            if (classCaptor.getValue().equals(Vehicle.class)) {
                return maxVehicleSpeed;
            } else if (classCaptor.getValue().equals(Starship.class)) {
                return maxStarshipSpeed;
            }
            return 0;
        });

        // Capturing and stubbing the getFastestName method
        ArgumentCaptor<List<String>> urlNameCaptor = ArgumentCaptor.forClass(List.class);
        ArgumentCaptor<Class<?>> classNameCaptor = ArgumentCaptor.forClass(Class.class);
        ArgumentCaptor<Function> functionSpeedCaptor = ArgumentCaptor.forClass(Function.class);
        ArgumentCaptor<Function> functionNameCaptor = ArgumentCaptor.forClass(Function.class);

        when(speedCalculatorService.getFastestName(
                urlNameCaptor.capture(), classNameCaptor.capture(), anyInt(),
                functionSpeedCaptor.capture(), functionNameCaptor.capture()
        )).thenAnswer(invocation -> {
            if (classNameCaptor.getValue().equals(Vehicle.class)) {
                return fastestVehicleName;
            } else if (classNameCaptor.getValue().equals(Starship.class)) {
                return fastestStarshipName;
            }
            return "None";
        });


            // Act
        Information result = getInformationRepository.getInformation(name);

        // Assert
        assertEquals(name, result.getName());
        assertEquals("Tatooine", result.getPlanet_name());
        assertEquals("X-Wing", result.getFastest_vehicle_driven());
        assertEquals(1, result.getFilms().size());
        assertEquals("A New Hope", result.getFilms().get(0).getName());
        assertEquals(LocalDate.parse("1977-05-25"), result.getFilms().get(0).getRelease_date());
    }
}
