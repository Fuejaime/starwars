package com.example.starwars.domain.Model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Information {
    private String name;
    private String birthYear;
    private String gender;
    private String planetName;
    private String fastestVehicleDriven;
    private List<FilmSummary> films;
}
