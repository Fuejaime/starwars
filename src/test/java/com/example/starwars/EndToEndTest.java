package com.example.starwars;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EndToEndTest {

    @Test
    void testGetInformation() {
        String baseUrl = "http://localhost:8080/swapi-proxy/person-info";
        String name = "Luke Skywalker";

        given()
                .param("name", name)
                .when()
                .get(baseUrl)
                .then()
                .statusCode(200)
                .body("name", equalTo(name))
                .body("birth_year", equalTo("19BBY"))
                .body("gender", equalTo("male"))
                .body("planet_name", equalTo("Tatooine"))
                .body("fastest_vehicle_driven", equalTo("X-wing"))
                .body("films.size()", equalTo(4))
                .body("films[0].name", equalTo("A New Hope"))
                .body("films[0].release_date", equalTo("1977-05-25"))
                .body("films[1].name", equalTo("The Empire Strikes Back"))
                .body("films[1].release_date", equalTo("1980-05-17"))
                .body("films[2].name", equalTo("Return of the Jedi"))
                .body("films[2].release_date", equalTo("1983-05-25"))
                .body("films[3].name", equalTo("Revenge of the Sith"))
                .body("films[3].release_date", equalTo("2005-05-19"));

    }

}
