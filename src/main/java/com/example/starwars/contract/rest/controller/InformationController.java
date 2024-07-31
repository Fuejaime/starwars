package com.example.starwars.contract.rest.controller;

import com.example.starwars.application.usecase.GetInformationUseCase;
import com.example.starwars.domain.Model.Information;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/swapi-proxy/person-info")
public class InformationController {

    private final GetInformationUseCase getInformationUseCase;
    @GetMapping
    @Cacheable(value = "information", key = "#name")
    public Information getInfo(@RequestParam ("name") String name) {
        return getInformationUseCase.getInformation(name);
    }
}
