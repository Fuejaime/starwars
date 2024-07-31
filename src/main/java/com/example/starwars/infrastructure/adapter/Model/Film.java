package com.example.starwars.infrastructure.adapter.Model;

import lombok.Data;

import java.util.List;

@Data
public class Film {
    private String title;
    private int episodeId;  // Cambiado a int para seguir el tipo del JSON
    private String openingCrawl;
    private String director;
    private String producer;
    private String release_date;  // Usualmente se maneja como String, pero puede ser una clase de fecha si se prefiere
    private List<String> characters;  // Lista de URLs a los personajes
    private List<String> planets;     // Lista de URLs a los planetas
    private List<String> starships;   // Lista de URLs a las naves estelares
    private List<String> vehicles;    // Lista de URLs a los vehículos
    private List<String> species;     // Lista de URLs a las especies
    private String created;           // Fecha de creación
    private String edited;            // Fecha de última edición
    private String url;               // URL del recurso
}