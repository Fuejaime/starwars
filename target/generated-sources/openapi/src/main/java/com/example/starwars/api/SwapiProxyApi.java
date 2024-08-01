/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.0.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.example.starwars.api;

import com.example.starwars.model.GetPersonInfo200Response;
import com.example.starwars.model.GetPersonInfo404Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-08-01T11:30:18.691919+02:00[Europe/Madrid]")
@Validated
@Tag(name = "swapi-proxy", description = "API para obtener información sobre personajes de Star Wars.")
public interface SwapiProxyApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /swapi-proxy/person-info : Obtener información del personaje de Star Wars
     * Devuelve información detallada sobre un personaje de Star Wars basado en el nombre proporcionado.
     *
     * @param name Nombre del personaje de Star Wars. (required)
     * @return Información del personaje encontrada con éxito. (status code 200)
     *         or Personaje no encontrado. (status code 404)
     */
    @Operation(
        operationId = "getPersonInfo",
        summary = "Obtener información del personaje de Star Wars",
        tags = { "StarWarsAPI" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Información del personaje encontrada con éxito.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = GetPersonInfo200Response.class))
            }),
            @ApiResponse(responseCode = "404", description = "Personaje no encontrado.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = GetPersonInfo404Response.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/swapi-proxy/person-info",
        produces = { "application/json" }
    )
    default ResponseEntity<GetPersonInfo200Response> getPersonInfo(
        @NotNull @Parameter(name = "name", description = "Nombre del personaje de Star Wars.", required = true) @Valid @RequestParam(value = "name", required = true) String name
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"films\" : [ { \"release_date\" : \"1977-05-25T00:00:00.000+00:00\", \"name\" : \"A New Hope\" }, { \"release_date\" : \"1977-05-25T00:00:00.000+00:00\", \"name\" : \"A New Hope\" } ], \"gender\" : \"male\", \"name\" : \"Luke Skywalker\", \"fastest_vehicle_driven\" : \"X-wing\", \"planet_name\" : \"Tatooine\", \"birth_year\" : \"19BBY\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}