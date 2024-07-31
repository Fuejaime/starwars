package com.example.starwars.infrastructure.model;

import lombok.Data;

import java.util.List;

@Data
public class PersonInformationResponse {
    private int count;
    private String next;
    private String previous;
    private List<PersonInformation> results;
}
