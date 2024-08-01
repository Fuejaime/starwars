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
                .releaseDate("1977-05-25")
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
        assertEquals("A New Hope", film.title());
        assertEquals(4, film.episodeId());
        assertEquals("It is a period of civil war...", film.openingCrawl());
        assertEquals("George Lucas", film.director());
        assertEquals("Gary Kurtz", film.producer());
        assertEquals("1977-05-25", film.releaseDate());
        assertEquals(Arrays.asList("url1", "url2"), film.characters());
        assertEquals(Arrays.asList("url3", "url4"), film.planets());
        assertEquals(Arrays.asList("url5", "url6"), film.starships());
        assertEquals(Arrays.asList("url7", "url8"), film.vehicles());
        assertEquals(Arrays.asList("url9", "url10"), film.species());
        assertEquals("2014-12-10T14:23:31.880000Z", film.created());
        assertEquals("2014-12-20T19:49:45.256000Z", film.edited());
        assertEquals("url11", film.url());
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
                .releaseDate("1977-05-25")
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
        assertTrue(result.contains("releaseDate=1977-05-25"));
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
