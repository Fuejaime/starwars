package com.example.starwars.contract.rest.mapper;

import com.example.starwars.domain.Model.Information;
import com.example.starwars.infrastructure.entity.Film;
import com.example.starwars.model.GetPersonInfo200Response;
import com.example.starwars.model.GetPersonInfo200ResponseFilmsInner;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Component
@Mapper
public interface InformationToGetPersonInfoMapper {



    GetPersonInfo200Response informationToPersonInfoResponse(Information information);

    DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Adjust the pattern as necessary

    // Map the list of Film to List<GetPersonInfo200ResponseFilmsInner>
    default List<GetPersonInfo200ResponseFilmsInner> mapFilms(List<Film> films) {
        return films.stream()
                .map(film -> new GetPersonInfo200ResponseFilmsInner()
                        .name(film.title()) // Ensure getName() matches Film property
                        .releaseDate(parseReleaseDate(film.releaseDate()))) // Convert date string to LocalDate
                .toList();
    }

    // Helper method to parse the release date
    default LocalDate parseReleaseDate(String releaseDate) {
        if (releaseDate == null || releaseDate.isEmpty()) {
            return null;
        }
        return LocalDate.parse(releaseDate, DATE_FORMATTER); // Adjust format as necessary
    }
}

