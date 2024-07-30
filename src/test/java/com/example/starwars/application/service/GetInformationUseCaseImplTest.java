package com.example.starwars.application.service;

import com.example.starwars.domain.Repository.GetInformationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GetInformationUseCaseImplTest {

    @InjectMocks
    GetInformationUseCaseImpl underTest;

    @Mock
    GetInformationRepository getInformationRepository;

    @Test
    void getInformation() {
        String name = "Luke";
        this.underTest.getInformation(name);
        //Pending Test correct functionality
    }
}
