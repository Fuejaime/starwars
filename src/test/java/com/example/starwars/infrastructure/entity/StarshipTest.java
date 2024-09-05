package com.example.starwars.infrastructure.entity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
 class StarshipTest {

    @Test
    void testStarshipBuilder() {
        // Arrange
        String name = "X-Wing";
        String model = "T-65 X-wing";
        String manufacturer = "Incom";
        String costInCredits = "149999";
        String length = "12.5";
        String maxAtmospheringSpeed = "1050";
        String crew = "1";
        String passengers = "0";
        String cargoCapacity = "110";
        String consumables = "1 week";
        String hyperdriveRating = "1.0";
        String mglt = "65";
        String starshipClass = "Starfighter";
        String created = "2014-12-10T15:18:20.000Z";
        String edited = "2014-12-20T21:30:21.661Z";
        String url = "https://swapi.dev/api/starships/12/";

        // Act
        Starship starship = Starship.builder()
                .name(name)
                .model(model)
                .manufacturer(manufacturer)
                .costInCredits(costInCredits)
                .length(length)
                .maxAtmospheringSpeed(maxAtmospheringSpeed)
                .crew(crew)
                .passengers(passengers)
                .cargoCapacity(cargoCapacity)
                .consumables(consumables)
                .hyperdriveRating(hyperdriveRating)
                .MGLT(mglt)
                .starshipClass(starshipClass)
                .created(created)
                .edited(edited)
                .url(url)
                .build();

        // Assert
        assertThat(starship).isNotNull();
        assertThat(starship.getName()).isEqualTo(name);
        assertThat(starship.getModel()).isEqualTo(model);
        assertThat(starship.getManufacturer()).isEqualTo(manufacturer);
        assertThat(starship.getCostInCredits()).isEqualTo(costInCredits);
        assertThat(starship.getLength()).isEqualTo(length);
        assertThat(starship.getMaxAtmospheringSpeed()).isEqualTo(maxAtmospheringSpeed);
        assertThat(starship.getCrew()).isEqualTo(crew);
        assertThat(starship.getPassengers()).isEqualTo(passengers);
        assertThat(starship.getCargoCapacity()).isEqualTo(cargoCapacity);
        assertThat(starship.getConsumables()).isEqualTo(consumables);
        assertThat(starship.getHyperdriveRating()).isEqualTo(hyperdriveRating);
        assertThat(starship.getMGLT()).isEqualTo(mglt);
        assertThat(starship.getStarshipClass()).isEqualTo(starshipClass);
        assertThat(starship.getCreated()).isEqualTo(created);
        assertThat(starship.getEdited()).isEqualTo(edited);
        assertThat(starship.getUrl()).isEqualTo(url);
    }

    @Test
    void testStarshipToString() {
        // Arrange
        Starship starship = Starship.builder()
                .name("X-Wing")
                .model("T-65 X-wing")
                .manufacturer("Incom")
                .costInCredits("149999")
                .length("12.5")
                .maxAtmospheringSpeed("1050")
                .crew("1")
                .passengers("0")
                .cargoCapacity("110")
                .consumables("1 week")
                .hyperdriveRating("1.0")
                .MGLT("65")
                .starshipClass("Starfighter")
                .created("2014-12-10T15:18:20.000Z")
                .edited("2014-12-20T21:30:21.661Z")
                .url("https://swapi.dev/api/starships/12/")
                .build();

        // Act
        String result = starship.toString();

        // Assert
        String expectedSubstring = "Starship(name=X-Wing, model=T-65 X-wing, manufacturer=Incom, costInCredits=149999, length=12.5, maxAtmospheringSpeed=1050, crew=1, passengers=0, cargoCapacity=110, consumables=1 week, hyperdriveRating=1.0, MGLT=65, starshipClass=Starfighter, created=2014-12-10T15:18:20.000Z, edited=2014-12-20T21:30:21.661Z, url=https://swapi.dev/api/starships/12/)";
        assertThat(result).contains(expectedSubstring);
    }
}
