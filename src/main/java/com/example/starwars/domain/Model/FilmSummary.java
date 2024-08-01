package com.example.starwars.domain.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class FilmSummary {
    private String name;
    private LocalDate releaseDate;
}
