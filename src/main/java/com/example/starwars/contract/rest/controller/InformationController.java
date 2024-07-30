package com.example.starwars.contract.rest.controller;

import com.example.starwars.application.usecase.GetInformationUseCase;
import lombok.RequiredArgsConstructor;
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
    public String getInfo(@RequestParam ("name") String name) {
        this.getInformationUseCase.getInformation(name);
        return "Info" + name;
    }
}
