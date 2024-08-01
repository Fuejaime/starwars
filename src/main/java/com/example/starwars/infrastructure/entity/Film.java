package com.example.starwars.infrastructure.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
public record Film(
        String title,
        int episodeId,
        String openingCrawl,
        String director,
        String producer,
        String releaseDate,  // Use camelCase for consistency
        List<String> characters,
        List<String> planets,
        List<String> starships,
        List<String> vehicles,
        List<String> species,
        String created,
        String edited,
        String url
) { }