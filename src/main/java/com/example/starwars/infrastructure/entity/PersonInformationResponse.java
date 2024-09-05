package com.example.starwars.infrastructure.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PersonInformationResponse {
    private int count;
    private String next;
    private String previous;
    private List<PersonInformation> results;
}
