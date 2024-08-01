package com.example.starwars.domain.Model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Information {
    private String name;
    private String birth_year;
    private String gender;
    private String planet_name;
    private String fastest_vehicle_driven;
    private List<FilmSummary> films;
}
