package com.example.starwars.contract.rest.controller;

import com.example.starwars.api.SwapiProxyApi;
import com.example.starwars.application.usecase.GetInformationUseCase;
import com.example.starwars.contract.rest.mapper.InformationToGetPersonInfoMapper;
import com.example.starwars.model.GetPersonInfo200Response;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InformationController implements SwapiProxyApi {

    private final GetInformationUseCase getInformationUseCase;

    private final InformationToGetPersonInfoMapper informationToGetPersonInfoMapper;

    @Override
    @Cacheable(value = "information", key = "#name")
    public ResponseEntity<GetPersonInfo200Response> getPersonInfo(String name) {
        return  ResponseEntity.ok(informationToGetPersonInfoMapper.informationToPersonInfoResponse(getInformationUseCase.getInformation(name)));
    }
}
