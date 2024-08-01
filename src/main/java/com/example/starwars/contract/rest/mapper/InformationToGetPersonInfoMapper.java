package com.example.starwars.contract.rest.mapper;

import com.example.starwars.domain.Model.Information;
import com.example.starwars.model.GetPersonInfo200Response;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface InformationToGetPersonInfoMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "birth_year", target = "birthYear")
    @Mapping(source = "planet_name", target = "planetName")
    @Mapping(source = "fastest_vehicle_driven", target = "fastestVehicleDriven")
    @Mapping(source = "films", target = "films")
    GetPersonInfo200Response informationToPersonInfoResponse(Information information);
}

