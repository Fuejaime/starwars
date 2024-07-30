package com.example.starwars.application.service;

import com.example.starwars.application.usecase.GetInformationUseCase;
import com.example.starwars.domain.Model.Information;
import com.example.starwars.domain.Repository.GetInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetInformationUseCaseImpl implements GetInformationUseCase {

    private final GetInformationRepository getInformationRepository;

    @Override
    public void getInformation(String name) {
        final Information information = getInformationRepository.getInformation(name);
    }
}
