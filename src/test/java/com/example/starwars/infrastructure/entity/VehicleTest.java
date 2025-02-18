package com.example.starwars.infrastructure.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class VehicleTest {

    @Test
    void testVehicleBuilder() {
        // Arrange
        String name = "Speeder";
        String model = "S-200";
        String manufacturer = "Speeder Co.";
        String costInCredits = "7500";
        String length = "3.4";
        String maxAtmospheringSpeed = "250";
        String crew = "1";
        String passengers = "0";
        String cargoCapacity = "10";
        String consumables = "1 week";
        String vehicleClass = "Speeder";
        String created = "2014-12-10T15:18:20.000Z";
        String edited = "2014-12-20T21:30:21.661Z";
        String url = "https://swapi.dev/api/vehicles/4/";

        // Act
        Vehicle vehicle = Vehicle.builder()
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
                .vehicleClass(vehicleClass)
                .created(created)
                .edited(edited)
                .url(url)
                .build();

        // Assert
        assertThat(vehicle).isNotNull();
        assertThat(vehicle.getName()).isEqualTo(name);
        assertThat(vehicle.getModel()).isEqualTo(model);
        assertThat(vehicle.getManufacturer()).isEqualTo(manufacturer);
        assertThat(vehicle.getCostInCredits()).isEqualTo(costInCredits);
        assertThat(vehicle.getLength()).isEqualTo(length);
        assertThat(vehicle.getMaxAtmospheringSpeed()).isEqualTo(maxAtmospheringSpeed);
        assertThat(vehicle.getCrew()).isEqualTo(crew);
        assertThat(vehicle.getPassengers()).isEqualTo(passengers);
        assertThat(vehicle.getCargoCapacity()).isEqualTo(cargoCapacity);
        assertThat(vehicle.getConsumables()).isEqualTo(consumables);
        assertThat(vehicle.getVehicleClass()).isEqualTo(vehicleClass);
        assertThat(vehicle.getCreated()).isEqualTo(created);
        assertThat(vehicle.getEdited()).isEqualTo(edited);
        assertThat(vehicle.getUrl()).isEqualTo(url);
    }

    @Test
    void testVehicleToString() {
        // Arrange
        Vehicle vehicle = Vehicle.builder()
                .name("Speeder")
                .model("S-200")
                .manufacturer("Speeder Co.")
                .costInCredits("7500")
                .length("3.4")
                .maxAtmospheringSpeed("250")
                .crew("1")
                .passengers("0")
                .cargoCapacity("10")
                .consumables("1 week")
                .vehicleClass("Speeder")
                .created("2014-12-10T15:18:20.000Z")
                .edited("2014-12-20T21:30:21.661Z")
                .url("https://swapi.dev/api/vehicles/4/")
                .build();

        // Act
        String result = vehicle.toString();

        // Assert
        String expectedSubstring = "Vehicle(name=Speeder, model=S-200, manufacturer=Speeder Co., costInCredits=7500, length=3.4, maxAtmospheringSpeed=250, crew=1, passengers=0, cargoCapacity=10, consumables=1 week, vehicleClass=Speeder, created=2014-12-10T15:18:20.000Z, edited=2014-12-20T21:30:21.661Z, url=https://swapi.dev/api/vehicles/4/)";
        assertThat(result).contains(expectedSubstring);
    }
}
