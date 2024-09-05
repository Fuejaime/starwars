package com.example.starwars.infrastructure.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PersonTest {

    @Test
    void testPersonGettersAndSetters() {
        // Arrange
        Person person = new Person();
        person.setName("Luke Skywalker");
        person.setBirth_year("19BBY");
        person.setGender("male");
        person.setHomeworld("Tatooine");
        person.setVehicles(Arrays.asList("Speeder", "X-Wing"));
        person.setStarships(Arrays.asList("X-Wing", "Imperial Shuttle"));

        // Act & Assert
        assertEquals("Luke Skywalker", person.getName());
        assertEquals("19BBY", person.getBirth_year());
        assertEquals("male", person.getGender());
        assertEquals("Tatooine", person.getHomeworld());
        assertEquals(Arrays.asList("Speeder", "X-Wing"), person.getVehicles());
        assertEquals(Arrays.asList("X-Wing", "Imperial Shuttle"), person.getStarships());
    }

    @Test
    void testPersonToString() {
        // Arrange
        Person person = new Person();
        person.setName("Luke Skywalker");
        person.setBirth_year("19BBY");
        person.setGender("male");
        person.setHomeworld("Tatooine");
        person.setVehicles(Arrays.asList("Speeder", "X-Wing"));
        person.setStarships(Arrays.asList("X-Wing", "Imperial Shuttle"));

        // Act
        String result = person.toString();

        // Assert
        assertTrue(result.contains("name=Luke Skywalker"));
        assertTrue(result.contains("birth_year=19BBY"));
        assertTrue(result.contains("gender=male"));
        assertTrue(result.contains("homeworld=Tatooine"));
        assertTrue(result.contains("vehicles=[Speeder, X-Wing]"));
        assertTrue(result.contains("starships=[X-Wing, Imperial Shuttle]"));
    }

    @Test
    void testPersonEqualsAndHashCode() {
        // Arrange
        Person person1 = new Person();
        person1.setName("Luke Skywalker");
        person1.setBirth_year("19BBY");

        Person person2 = new Person();
        person2.setName("Luke Skywalker");
        person2.setBirth_year("19BBY");

        Person person3 = new Person();
        person3.setName("Darth Vader");
        person3.setBirth_year("41.9BBY");

        // Act & Assert
        assertEquals(person1, person2);  // Same attributes
        assertNotEquals(person1, person3);  // Different attributes

        // Test hashCode
        assertEquals(person1.hashCode(), person2.hashCode());
        assertNotEquals(person1.hashCode(), person3.hashCode());
    }
}