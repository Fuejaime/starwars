package com.example.starwars.infrastructure.service;

import com.example.starwars.domain.Repository.ApiService;
import com.example.starwars.infrastructure.model.PersonInformation;
import com.example.starwars.infrastructure.model.PersonInformationResponse;
import com.example.starwars.infrastructure.model.PlanetInformation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataFetcherService {
    private final ApiService apiService;


    public PersonInformation fetchPersonInformation(String name) {
        String apiUrl = "https://swapi.trileuco.com/api/people/?page=";
        int page = 1;

        while (true) {
            String url = apiUrl + page;
            PersonInformationResponse response = apiService.fetchObject(url, PersonInformationResponse.class);

            if (response == null || response.getResults().isEmpty()) {
                throw new RuntimeException("Person not found");
            }

            PersonInformation personInfo = response.getResults().stream()
                    .filter(p -> p.getName().equalsIgnoreCase(name))
                    .findFirst()
                    .orElse(null);

            if (personInfo != null) {
                return personInfo;
            }

            if (response.getNext() == null) {
                throw new RuntimeException("Person not found");
            }
            page++;
        }
    }

    public PlanetInformation fetchPlanet(String planetUrl) {
        return apiService.fetchObject(planetUrl, PlanetInformation.class);
    }
}