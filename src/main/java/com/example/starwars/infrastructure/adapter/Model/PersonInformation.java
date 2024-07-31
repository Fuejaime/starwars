package com.example.starwars.infrastructure.adapter.Model;

import lombok.Data;

import java.util.List;

@Data
public class PersonInformation {
    private String name;
    private String height;
    private String mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birth_year;
    private String gender;
    private String homeworld;
    private List<String> films;
    private List<String> species;
    private List<String> vehicles;
    private List<String> starships;
    private String created;
    private String edited;
    private String url;
}
