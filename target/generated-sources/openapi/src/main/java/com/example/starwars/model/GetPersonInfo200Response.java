package com.example.starwars.model;

import java.net.URI;
import java.util.Objects;
import com.example.starwars.model.GetPersonInfo200ResponseFilmsInner;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * GetPersonInfo200Response
 */

@JsonTypeName("getPersonInfo_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-01T11:30:18.691919+02:00[Europe/Madrid]")
public class GetPersonInfo200Response {

  @JsonProperty("name")
  private String name;

  @JsonProperty("birth_year")
  private String birthYear;

  @JsonProperty("gender")
  private String gender;

  @JsonProperty("planet_name")
  private String planetName;

  @JsonProperty("fastest_vehicle_driven")
  private String fastestVehicleDriven;

  @JsonProperty("films")
  @Valid
  private List<GetPersonInfo200ResponseFilmsInner> films = null;

  public GetPersonInfo200Response name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  
  @Schema(name = "name", example = "Luke Skywalker", required = false)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GetPersonInfo200Response birthYear(String birthYear) {
    this.birthYear = birthYear;
    return this;
  }

  /**
   * Get birthYear
   * @return birthYear
  */
  
  @Schema(name = "birth_year", example = "19BBY", required = false)
  public String getBirthYear() {
    return birthYear;
  }

  public void setBirthYear(String birthYear) {
    this.birthYear = birthYear;
  }

  public GetPersonInfo200Response gender(String gender) {
    this.gender = gender;
    return this;
  }

  /**
   * Get gender
   * @return gender
  */
  
  @Schema(name = "gender", example = "male", required = false)
  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public GetPersonInfo200Response planetName(String planetName) {
    this.planetName = planetName;
    return this;
  }

  /**
   * Get planetName
   * @return planetName
  */
  
  @Schema(name = "planet_name", example = "Tatooine", required = false)
  public String getPlanetName() {
    return planetName;
  }

  public void setPlanetName(String planetName) {
    this.planetName = planetName;
  }

  public GetPersonInfo200Response fastestVehicleDriven(String fastestVehicleDriven) {
    this.fastestVehicleDriven = fastestVehicleDriven;
    return this;
  }

  /**
   * Get fastestVehicleDriven
   * @return fastestVehicleDriven
  */
  
  @Schema(name = "fastest_vehicle_driven", example = "X-wing", required = false)
  public String getFastestVehicleDriven() {
    return fastestVehicleDriven;
  }

  public void setFastestVehicleDriven(String fastestVehicleDriven) {
    this.fastestVehicleDriven = fastestVehicleDriven;
  }

  public GetPersonInfo200Response films(List<GetPersonInfo200ResponseFilmsInner> films) {
    this.films = films;
    return this;
  }

  public GetPersonInfo200Response addFilmsItem(GetPersonInfo200ResponseFilmsInner filmsItem) {
    if (this.films == null) {
      this.films = new ArrayList<>();
    }
    this.films.add(filmsItem);
    return this;
  }

  /**
   * Get films
   * @return films
  */
  @Valid 
  @Schema(name = "films", required = false)
  public List<GetPersonInfo200ResponseFilmsInner> getFilms() {
    return films;
  }

  public void setFilms(List<GetPersonInfo200ResponseFilmsInner> films) {
    this.films = films;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetPersonInfo200Response getPersonInfo200Response = (GetPersonInfo200Response) o;
    return Objects.equals(this.name, getPersonInfo200Response.name) &&
        Objects.equals(this.birthYear, getPersonInfo200Response.birthYear) &&
        Objects.equals(this.gender, getPersonInfo200Response.gender) &&
        Objects.equals(this.planetName, getPersonInfo200Response.planetName) &&
        Objects.equals(this.fastestVehicleDriven, getPersonInfo200Response.fastestVehicleDriven) &&
        Objects.equals(this.films, getPersonInfo200Response.films);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, birthYear, gender, planetName, fastestVehicleDriven, films);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetPersonInfo200Response {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    birthYear: ").append(toIndentedString(birthYear)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    planetName: ").append(toIndentedString(planetName)).append("\n");
    sb.append("    fastestVehicleDriven: ").append(toIndentedString(fastestVehicleDriven)).append("\n");
    sb.append("    films: ").append(toIndentedString(films)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

