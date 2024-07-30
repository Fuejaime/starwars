package com.example.starwars.contract.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/swapi-proxy/person-info")
public class InformationController {

    @GetMapping
    public String getInfo(@RequestParam ("name") String name) {
        return "Info" + name;
    }
}
