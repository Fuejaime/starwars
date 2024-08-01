package com.example.starwars.infrastructure.adapter;

import com.example.starwars.domain.Model.FilmSummary;
import com.example.starwars.domain.Model.Information;
import com.example.starwars.domain.Repository.GetInformationRepository;
import com.example.starwars.infrastructure.entity.PersonInformation;
import com.example.starwars.infrastructure.entity.PlanetInformation;
import com.example.starwars.infrastructure.entity.Starship;
import com.example.starwars.infrastructure.entity.Vehicle;
import com.example.starwars.infrastructure.service.DataFetcherService;
import com.example.starwars.infrastructure.service.FilmSummaryService;
import com.example.starwars.infrastructure.service.SpeedCalculatorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class GetInformationRepositoryImpl implements GetInformationRepository {

    private final DataFetcherService dataFetcherService;
    private final SpeedCalculatorService speedCalculatorService;
    private final FilmSummaryService filmSummaryService;

    @Override
    public Information getInformation(String name) {
        PersonInformation personInfo = dataFetcherService.fetchPersonInformation(name);
        String planetName = fetchPlanetName(personInfo.getHomeworld());
        String fastestItem = findFastestItem(personInfo.getVehicles(), personInfo.getStarships());
        List<FilmSummary> films = filmSummaryService.getFilmSummaries(personInfo.getFilms());

        return Information.builder()
                .name(personInfo.getName())
                .birthYear(personInfo.getBirth_year())
                .gender(personInfo.getGender())
                .planetName(planetName)
                .fastestVehicleDriven(fastestItem)
                .films(films)
                .build();
    }

    private String fetchPlanetName(String planetUrl) {
        return Optional.ofNullable(planetUrl)
                .map(dataFetcherService::fetchPlanet)
                .map(PlanetInformation::getName)
                .orElse("Unknown");
    }

    private String findFastestItem(List<String> vehicleUrls, List<String> starshipUrls) {
        Integer maxVehicleSpeed = speedCalculatorService.getMaxSpeed(
                vehicleUrls, Vehicle.class, vehicle -> parseSpeed(vehicle.getMaxAtmospheringSpeed())
        );
        Integer maxStarshipSpeed = speedCalculatorService.getMaxSpeed(
                starshipUrls, Starship.class, starship -> parseSpeed(starship.getMax_atmosphering_speed())
        );

        String fastestVehicleName = speedCalculatorService.getFastestName(
                vehicleUrls, Vehicle.class, maxVehicleSpeed,
                vehicle -> parseSpeed(vehicle.getMaxAtmospheringSpeed()), Vehicle::getName
        );
        String fastestStarshipName = speedCalculatorService.getFastestName(
                starshipUrls, Starship.class, maxStarshipSpeed,
                starship -> parseSpeed(starship.getMax_atmosphering_speed()), Starship::getName
        );

        return maxVehicleSpeed > maxStarshipSpeed ? fastestVehicleName : fastestStarshipName;
    }

    private Integer parseSpeed(String speed) {
        if (speed == null || speed.trim().isEmpty()) {
            return 0;
        }
        try {
            return Integer.parseInt(speed);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
