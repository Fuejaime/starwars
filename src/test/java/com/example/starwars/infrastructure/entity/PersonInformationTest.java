package com.example.starwars.infrastructure.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PersonInformationTest {

    @Test
    void testPersonInformationGettersAndSetters() {
        // Arrange
        PersonInformation person = PersonInformation.builder()
                .name("Luke Skywalker")
                .height("172")
                .mass("77")
                .hairColor("blond")
                .skinColor("fair")
                .eyeColor("blue")
                .birth_year("19BBY")
                .gender("male")
                .homeworld("Tatooine")
                .films(Arrays.asList("A New Hope", "The Empire Strikes Back"))
                .species(List.of("Human"))
                .vehicles(Arrays.asList("Speeder", "X-Wing"))
                .starships(Arrays.asList("X-Wing", "Imperial Shuttle"))
                .created("2014-12-09T13:50:51.644000Z")
                .edited("2014-12-20T21:17:56.891000Z")
                .url("http://swapi.dev/api/people/1/")
                .build();

        // Act & Assert
        assertEquals("Luke Skywalker", person.getName());
        assertEquals("172", person.getHeight());
        assertEquals("77", person.getMass());
        assertEquals("blond", person.getHairColor());
        assertEquals("fair", person.getSkinColor());
        assertEquals("blue", person.getEyeColor());
        assertEquals("19BBY", person.getBirth_year());
        assertEquals("male", person.getGender());
        assertEquals("Tatooine", person.getHomeworld());
        assertEquals(Arrays.asList("A New Hope", "The Empire Strikes Back"), person.getFilms());
        assertEquals(List.of("Human"), person.getSpecies());
        assertEquals(Arrays.asList("Speeder", "X-Wing"), person.getVehicles());
        assertEquals(Arrays.asList("X-Wing", "Imperial Shuttle"), person.getStarships());
        assertEquals("2014-12-09T13:50:51.644000Z", person.getCreated());
        assertEquals("2014-12-20T21:17:56.891000Z", person.getEdited());
        assertEquals("http://swapi.dev/api/people/1/", person.getUrl());
    }

    @Test
    void testPersonInformationToString() {
        // Arrange
        PersonInformation person = PersonInformation.builder()
                .name("Luke Skywalker")
                .height("172")
                .mass("77")
                .hairColor("blond")
                .skinColor("fair")
                .eyeColor("blue")
                .birth_year("19BBY")
                .gender("male")
                .homeworld("Tatooine")
                .films(Arrays.asList("A New Hope", "The Empire Strikes Back"))
                .species(List.of("Human"))
                .vehicles(Arrays.asList("Speeder", "X-Wing"))
                .starships(Arrays.asList("X-Wing", "Imperial Shuttle"))
                .created("2014-12-09T13:50:51.644000Z")
                .edited("2014-12-20T21:17:56.891000Z")
                .url("http://swapi.dev/api/people/1/")
                .build();

        // Act
        String result = person.toString();

        // Assert
        assertTrue(result.contains("name=Luke Skywalker"));
        assertTrue(result.contains("height=172"));
        assertTrue(result.contains("mass=77"));
        assertTrue(result.contains("hairColor=blond"));
        assertTrue(result.contains("skinColor=fair"));
        assertTrue(result.contains("eyeColor=blue"));
        assertTrue(result.contains("birth_year=19BBY"));
        assertTrue(result.contains("gender=male"));
        assertTrue(result.contains("homeworld=Tatooine"));
        assertTrue(result.contains("films=[A New Hope, The Empire Strikes Back]"));
        assertTrue(result.contains("species=[Human]"));
        assertTrue(result.contains("vehicles=[Speeder, X-Wing]"));
        assertTrue(result.contains("starships=[X-Wing, Imperial Shuttle]"));
        assertTrue(result.contains("created=2014-12-09T13:50:51.644000Z"));
        assertTrue(result.contains("edited=2014-12-20T21:17:56.891000Z"));
        assertTrue(result.contains("url=http://swapi.dev/api/people/1/"));
    }

    @Test
    void testPersonInformationEqualsAndHashCode() {
        // Arrange
        PersonInformation person1 = PersonInformation.builder()
                .name("Luke Skywalker")
                .birth_year("19BBY")
                .build();

        PersonInformation person2 = PersonInformation.builder()
                .name("Luke Skywalker")
                .birth_year("19BBY")
                .build();

        PersonInformation person3 = PersonInformation.builder()
                .name("Darth Vader")
                .birth_year("41.9BBY")
                .build();

        // Act & Assert
        assertEquals(person1, person2);  // Same attributes
        assertNotEquals(person1, person3);  // Different attributes

        // Test hashCode
        assertEquals(person1.hashCode(), person2.hashCode());
        assertNotEquals(person1.hashCode(), person3.hashCode());
    }
}
