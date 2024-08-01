package com.example.starwars.infrastructure.service;

import com.example.starwars.contract.rest.controller.PersonNotFoundException;
import com.example.starwars.domain.Repository.ApiService;
import com.example.starwars.infrastructure.entity.PersonInformation;
import com.example.starwars.infrastructure.entity.PersonInformationResponse;
import com.example.starwars.infrastructure.entity.PlanetInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataFetcherService {

    private final ApiService apiService;

    @Value("${api.url}")
    private String apiUrl;

    public PersonInformation fetchPersonInformation(String name) {
        int page = 1;

        while (true) {
            String url = apiUrl + page;
            //Rest Template por WebClient
            PersonInformationResponse response = apiService.fetchObject(url, PersonInformationResponse.class);

            if (response == null || response.getResults().isEmpty()) {
                throw new PersonNotFoundException("Person not found");
            }

            PersonInformation personInfo = response.getResults().stream()
                    .filter(p -> p.getName().equalsIgnoreCase(name))
                    .findFirst()
                    .orElse(null);

            if (personInfo != null) {
                return personInfo;
            }

            if (response.getNext() == null) {
                throw new PersonNotFoundException("Person not found");
            }

            page++;
        }
    }
    public PlanetInformation fetchPlanet(String planetUrl) {
        return apiService.fetchObject(planetUrl, PlanetInformation.class);
    }

}