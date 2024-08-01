package com.example.starwars.infrastructure.service;

import com.example.starwars.domain.Model.FilmSummary;
import com.example.starwars.domain.Repository.ApiService;
import com.example.starwars.infrastructure.entity.Film;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class FilmSummaryServiceTest {

    @Mock
    private ApiService apiService;

    @InjectMocks
    private FilmSummaryService filmSummaryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetFilmSummaries() {
        // Arrange
        String filmUrl = "https://swapi.trileuco.com/api/films/1/";
        Film film = Film.builder()
                .title("A New Hope")
                .releaseDate("1977-05-25")
                .build();

        when(apiService.fetchObject(filmUrl, Film.class)).thenReturn(film);

        // Act
        List<FilmSummary> result = filmSummaryService.getFilmSummaries(Collections.singletonList(filmUrl));

        // Assert
        assertThat(result).hasSize(1);
        FilmSummary filmSummary = result.get(0);
        assertThat(filmSummary.getName()).isEqualTo("A New Hope");
        assertThat(filmSummary.getReleaseDate()).isEqualTo(LocalDate.of(1977, 5, 25));
    }

    @Test
    void testGetFilmSummariesWithNoFilms() {
        // Arrange
        String filmUrl = "https://swapi.trileuco.com/api/films/1/";

        when(apiService.fetchObject(filmUrl, Film.class)).thenReturn(null);

        // Act
        List<FilmSummary> result = filmSummaryService.getFilmSummaries(Collections.singletonList(filmUrl));

        // Assert
        assertThat(result).isEmpty();
    }

    @Test
    void testGetFilmSummariesWithMultipleFilms() {
        // Arrange
        String filmUrl1 = "https://swapi.trileuco.com/api/films/1/";
        String filmUrl2 = "https://swapi.trileuco.com/api/films/2/";

        Film film1 = Film.builder()
                .title("A New Hope")
                .releaseDate("1977-05-25")
                .build();

        Film film2 = Film.builder()
                .title("The Empire Strikes Back")
                .releaseDate("1980-05-21")
                .build();

        when(apiService.fetchObject(filmUrl1, Film.class)).thenReturn(film1);
        when(apiService.fetchObject(filmUrl2, Film.class)).thenReturn(film2);

        // Act
        List<FilmSummary> result = filmSummaryService.getFilmSummaries(List.of(filmUrl1, filmUrl2));

        // Assert
        assertThat(result).hasSize(2);
        assertThat(result).extracting(FilmSummary::getName).containsExactly("A New Hope", "The Empire Strikes Back");
        assertThat(result).extracting(FilmSummary::getReleaseDate)
                .containsExactly(LocalDate.of(1977, 5, 25), LocalDate.of(1980, 5, 21));
    }
}
