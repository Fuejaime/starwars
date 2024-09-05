package com.example.starwars.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * GetPersonInfo200ResponseFilmsInner
 */

@JsonTypeName("getPersonInfo_200_response_films_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-01T11:30:18.691919+02:00[Europe/Madrid]")
public class GetPersonInfo200ResponseFilmsInner {

  @JsonProperty("name")
  private String name;

  @JsonProperty("release_date")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate releaseDate;

  public GetPersonInfo200ResponseFilmsInner name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  
  @Schema(name = "name", example = "A New Hope", required = false)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GetPersonInfo200ResponseFilmsInner releaseDate(LocalDate releaseDate) {
    this.releaseDate = releaseDate;
    return this;
  }

  /**
   * Get releaseDate
   * @return releaseDate
  */
  @Valid 
  @Schema(name = "release_date", example = "Wed May 25 02:00:00 CEST 1977", required = false)
  public LocalDate getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(LocalDate releaseDate) {
    this.releaseDate = releaseDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetPersonInfo200ResponseFilmsInner getPersonInfo200ResponseFilmsInner = (GetPersonInfo200ResponseFilmsInner) o;
    return Objects.equals(this.name, getPersonInfo200ResponseFilmsInner.name) &&
        Objects.equals(this.releaseDate, getPersonInfo200ResponseFilmsInner.releaseDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, releaseDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetPersonInfo200ResponseFilmsInner {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    releaseDate: ").append(toIndentedString(releaseDate)).append("\n");
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

