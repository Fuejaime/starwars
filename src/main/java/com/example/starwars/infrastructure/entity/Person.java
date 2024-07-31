package com.example.starwars.infrastructure.entity;

import lombok.Data;

import java.util.List;

@Data
public class Person {
    private String name;
    private String birth_year;
    private String gender;
    private String homeworld;
    private List<String> vehicles;
    private List<String> starships;
}
