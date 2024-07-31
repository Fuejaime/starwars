package com.example.starwars.infrastructure.entity;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FilmTest {

    @Test
    void testFilmGettersAndSetters() {
        // Arrange
        Film film = Film.builder()
                .title("A New Hope")
                .episodeId(4)
                .openingCrawl("It is a period of civil war...")
                .director("George Lucas")
                .producer("Gary Kurtz")
                .release_date("1977-05-25")
                .characters(Arrays.asList("url1", "url2"))
                .planets(Arrays.asList("url3", "url4"))
                .starships(Arrays.asList("url5", "url6"))
                .vehicles(Arrays.asList("url7", "url8"))
                .species(Arrays.asList("url9", "url10"))
                .created("2014-12-10T14:23:31.880000Z")
                .edited("2014-12-20T19:49:45.256000Z")
                .url("url11")
                .build();

        // Act & Assert
        assertEquals("A New Hope", film.getTitle());
        assertEquals(4, film.getEpisodeId());
        assertEquals("It is a period of civil war...", film.getOpeningCrawl());
        assertEquals("George Lucas", film.getDirector());
        assertEquals("Gary Kurtz", film.getProducer());
        assertEquals("1977-05-25", film.getRelease_date());
        assertEquals(Arrays.asList("url1", "url2"), film.getCharacters());
        assertEquals(Arrays.asList("url3", "url4"), film.getPlanets());
        assertEquals(Arrays.asList("url5", "url6"), film.getStarships());
        assertEquals(Arrays.asList("url7", "url8"), film.getVehicles());
        assertEquals(Arrays.asList("url9", "url10"), film.getSpecies());
        assertEquals("2014-12-10T14:23:31.880000Z", film.getCreated());
        assertEquals("2014-12-20T19:49:45.256000Z", film.getEdited());
        assertEquals("url11", film.getUrl());
    }

    @Test
    void testFilmToString() {
        // Arrange
        Film film = Film.builder()
                .title("A New Hope")
                .episodeId(4)
                .openingCrawl("It is a period of civil war...")
                .director("George Lucas")
                .producer("Gary Kurtz")
                .release_date("1977-05-25")
                .characters(Arrays.asList("url1", "url2"))
                .planets(Arrays.asList("url3", "url4"))
                .starships(Arrays.asList("url5", "url6"))
                .vehicles(Arrays.asList("url7", "url8"))
                .species(Arrays.asList("url9", "url10"))
                .created("2014-12-10T14:23:31.880000Z")
                .edited("2014-12-20T19:49:45.256000Z")
                .url("url11")
                .build();

        // Act
        String result = film.toString();

        // Assert
        assertTrue(result.contains("title=A New Hope"));
        assertTrue(result.contains("episodeId=4"));
        assertTrue(result.contains("openingCrawl=It is a period of civil war..."));
        assertTrue(result.contains("director=George Lucas"));
        assertTrue(result.contains("producer=Gary Kurtz"));
        assertTrue(result.contains("release_date=1977-05-25"));
        assertTrue(result.contains("characters=[url1, url2]"));
        assertTrue(result.contains("planets=[url3, url4]"));
        assertTrue(result.contains("starships=[url5, url6]"));
        assertTrue(result.contains("vehicles=[url7, url8]"));
        assertTrue(result.contains("species=[url9, url10]"));
        assertTrue(result.contains("created=2014-12-10T14:23:31.880000Z"));
        assertTrue(result.contains("edited=2014-12-20T19:49:45.256000Z"));
        assertTrue(result.contains("url=url11"));
    }

    @Test
    void testFilmEqualsAndHashCode() {
        // Arrange
        Film film1 = Film.builder()
                .title("A New Hope")
                .episodeId(4)
                .build();

        Film film2 = Film.builder()
                .title("A New Hope")
                .episodeId(4)
                .build();

        Film film3 = Film.builder()
                .title("The Empire Strikes Back")
                .episodeId(5)
                .build();

        // Act & Assert
        assertEquals(film1, film2);  // Same attributes
        assertNotEquals(film1, film3);  // Different attributes

        // Test hashCode
        assertEquals(film1.hashCode(), film2.hashCode());
        assertNotEquals(film1.hashCode(), film3.hashCode());
    }
}
