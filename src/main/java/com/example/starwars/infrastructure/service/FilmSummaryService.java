package com.example.starwars.infrastructure.service;

import com.example.starwars.domain.Model.FilmSummary;
import com.example.starwars.domain.Repository.ApiService;
import com.example.starwars.infrastructure.entity.Film;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class FilmSummaryService {
    private final ApiService apiService;

    public List<FilmSummary> getFilmSummaries(List<String> filmUrls) {
        return filmUrls.stream()
                .map(url -> apiService.fetchObject(url, Film.class))
                .filter(Objects::nonNull)
                .map(this::toFilmSummary)
                .toList();
    }

    private FilmSummary toFilmSummary(Film film) {
        return FilmSummary.builder()
                .name(film.getTitle())
                .releaseDate(LocalDate.parse(film.getRelease_date()))
                .build();
    }
}
