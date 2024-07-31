package com.example.starwars.infrastructure.entity;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PersonInformationResponseTest {
    @Test
    void testPersonInformationResponseGettersAndSetters() {
        // Arrange
        PersonInformation person1 = PersonInformation.builder()
                .name("Luke Skywalker")
                .birth_year("19BBY")
                .build();

        PersonInformation person2 = PersonInformation.builder()
                .name("Darth Vader")
                .birth_year("41.9BBY")
                .build();

        PersonInformationResponse response = PersonInformationResponse.builder()
                .count(2)
                .next("http://swapi.dev/api/people/?page=2")
                .previous(null)
                .results(Arrays.asList(person1, person2))
                .build();

        // Act & Assert
        assertEquals(2, response.getCount());
        assertEquals("http://swapi.dev/api/people/?page=2", response.getNext());
        assertNull(response.getPrevious());
        assertEquals(Arrays.asList(person1, person2), response.getResults());
    }

    @Test
    void testPersonInformationResponseToString() {
        // Arrange
        PersonInformation person1 = PersonInformation.builder()
                .name("Luke Skywalker")
                .birth_year("19BBY")
                .build();

        PersonInformation person2 = PersonInformation.builder()
                .name("Darth Vader")
                .birth_year("41.9BBY")
                .build();

        PersonInformationResponse response = PersonInformationResponse.builder()
                .count(2)
                .next("http://swapi.dev/api/people/?page=2")
                .previous(null)
                .results(Arrays.asList(person1, person2))
                .build();

        // Act
        String result = response.toString();

        // Assert
        assertTrue(result.contains("count=2"));
        assertTrue(result.contains("next=http://swapi.dev/api/people/?page=2"));
        assertTrue(result.contains("previous=null"));
    }

    @Test
    void testPersonInformationResponseEqualsAndHashCode() {
        // Arrange
        PersonInformation person1 = PersonInformation.builder()
                .name("Luke Skywalker")
                .birth_year("19BBY")
                .build();

        PersonInformation person2 = PersonInformation.builder()
                .name("Darth Vader")
                .birth_year("41.9BBY")
                .build();

        PersonInformationResponse response1 = PersonInformationResponse.builder()
                .count(2)
                .next("http://swapi.dev/api/people/?page=2")
                .previous(null)
                .results(Arrays.asList(person1, person2))
                .build();

        PersonInformationResponse response2 = PersonInformationResponse.builder()
                .count(2)
                .next("http://swapi.dev/api/people/?page=2")
                .previous(null)
                .results(Arrays.asList(person1, person2))
                .build();

        PersonInformationResponse response3 = PersonInformationResponse.builder()
                .count(1)
                .next("http://swapi.dev/api/people/?page=1")
                .previous(null)
                .results(Arrays.asList(person1))
                .build();

        // Act & Assert
        assertEquals(response1, response2);  // Same attributes
        assertNotEquals(response1, response3);  // Different attributes

        // Test hashCode
        assertEquals(response1.hashCode(), response2.hashCode());
        assertNotEquals(response1.hashCode(), response3.hashCode());
    }
}
